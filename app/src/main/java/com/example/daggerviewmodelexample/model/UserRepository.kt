package com.example.daggerviewmodelexample.model

interface UserRepository {
    fun getUsers(): List<User>
}