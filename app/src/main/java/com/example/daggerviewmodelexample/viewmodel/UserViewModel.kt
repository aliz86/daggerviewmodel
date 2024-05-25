package com.example.daggerviewmodelexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerviewmodelexample.model.User
import com.example.daggerviewmodelexample.model.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        // Usually, you would use coroutines (viewModelScope.launch) for asynchronous operations
        val data = userRepository.getUsers()
        _users.value = data
    }
}