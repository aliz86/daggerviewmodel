package com.example.daggerviewmodelexample.di

import com.example.daggerviewmodelexample.model.UserRepository
import com.example.daggerviewmodelexample.model.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }
}