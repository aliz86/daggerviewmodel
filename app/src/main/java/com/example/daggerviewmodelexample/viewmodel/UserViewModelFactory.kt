package com.example.daggerviewmodelexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerviewmodelexample.model.UserRepository
import javax.inject.Inject
import javax.inject.Provider

class UserViewModelFactory @Inject constructor(
//Why "Provider" and not just instance of UserRepository?
    //Lazy Instantiation: Provider enables lazy instantiation of the UserRepository. This means the repository instance is created only when it's first needed by the ViewModel. This can be more efficient if the repository is expensive to create and might not always be used in every instance of the ViewModel.
    //Potential for Scoping Issues (Advanced): In more advanced scenarios where you might be dealing with scoped dependencies in Dagger (like @ActivityScoped or custom scopes), directly injecting the UserRepository into the factory could lead to scoping issues. Using Provider helps you avoid these potential problems.
private val userRepositoryProvider: Provider<UserRepository>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userRepositoryProvider.get()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
