package com.csquare.codingtask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import com.csquare.codingtask.databinding.UserListRowBinding
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csquare.codingtask.database.UserEntity

class UserListAdapter(var context: Context, var userList: List<UserEntity>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        var userListRowBinding = UserListRowBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(userListRowBinding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindModel(userList[position])
    }

    inner class UserViewHolder(view: UserListRowBinding) : RecyclerView.ViewHolder(view.root) {

        fun bindModel(userEntity: UserEntity) {

        }
    }
}
