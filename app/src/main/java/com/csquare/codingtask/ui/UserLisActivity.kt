package com.csquare.codingtask.ui

import android.app.ApplicationErrorReport
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.csquare.codingtask.AppApplication
import com.csquare.codingtask.R
import com.csquare.codingtask.database.UserEntity
import com.csquare.codingtask.model.DataModel
import com.csquare.codingtask.repository.UserListRepository
import com.csquare.codingtask.repository.UserRepository
import com.csquare.codingtask.viewmodel.LoginViewModel
import com.csquare.codingtask.viewmodel.UserListViewModel
import com.csquare.codingtask.viewmodel.ViewModeUserList

class UserLisActivity : BaseActivity() {

    lateinit var userListViewModel: UserListViewModel
    var userRepository: UserRepository? = null
    var displayUserListFragment:DisplayUserListFragment?=null


    private val wordViewModel: ViewModeUserList by viewModels {
        ViewModeUserList.ViewModelUserFactory((application as AppApplication).repository)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_lis)
        init()
        getUserList()
    }

    fun init(){
        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)
        displayUserListFragment = DisplayUserListFragment()
    }


    fun getUserList(){

        var  userListModel = userListViewModel.getUserList()

        userRepository = UserRepository(application)

        insertUserData(userListModel?.value?.data)

        displayUserInList()

    }

    fun insertUserData(userList: ArrayList<DataModel>?) {
        if (userList != null) {
            for (model in userList) {
                userRepository?.insert(buildUserEntityModel(model))
            }
        }
    }

    fun buildUserEntityModel(model: DataModel): UserEntity {
        return UserEntity(model.id, model.email, model.first_name, model.last_name, model.avatar)
    }


    fun displayUserInList(){
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, displayUserListFragment!!,"UserList")
        fragmentTransaction.addToBackStack("UserList")
        fragmentTransaction.commit()
    }

}
