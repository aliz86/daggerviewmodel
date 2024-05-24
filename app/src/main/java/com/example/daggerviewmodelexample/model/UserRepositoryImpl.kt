package com.example.daggerviewmodelexample.model

import javax.inject.Inject


class UserRepositoryImpl @Inject constructor() : UserRepository {
    override fun getUsers(): List<User> {
        // Simulate fetching data (replace with actual data source logic)
        return listOf(
            User(1, "John Doe", "john@example.com"),
            User(2, "Jane Doe", "jane@example.com")
        )
    }
}