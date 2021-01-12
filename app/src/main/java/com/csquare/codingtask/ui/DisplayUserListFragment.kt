package com.csquare.codingtask.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csquare.codingtask.AppApplication
import com.csquare.codingtask.R
import com.csquare.codingtask.database.UserEntity
import com.csquare.codingtask.ui.adapter.UserListAdapter
import com.csquare.codingtask.viewmodel.UserListViewModel
import com.csquare.codingtask.viewmodel.ViewModeUserList

class DisplayUserListFragment : Fragment() {

    var userEntityList: List<UserEntity>? = null
    lateinit var userListViewModel: UserListViewModel
    lateinit var userList: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_display_user_list, container, false)
        userList = view.findViewById<RecyclerView>(R.id.rvUserList)

        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        return view;
    }



    private fun displayUserInList() {
        var listAdapter = UserListAdapter(this!!.activity!!, this!!.userEntityList!!)
        userList.layoutManager = LinearLayoutManager(activity)
        userList.adapter = listAdapter
    }
}


