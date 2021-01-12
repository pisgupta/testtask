package com.csquare.codingtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.csquare.codingtask.database.UserEntity
import com.csquare.codingtask.repository.UserListRepository
import com.csquare.codingtask.repository.UserRepository
import kotlinx.coroutines.launch

class ViewModeUserList(private val repository: UserRepository): ViewModel() {

    val allWords: LiveData<List<UserEntity>> = repository.userList


    fun insert(word: UserEntity) = viewModelScope.launch {
        repository.insert(word)
    }

    class ViewModelUserFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModeUserList::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ViewModeUserList(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}