package com.example.daggerviewmodelexample.di

import com.example.daggerviewmodelexample.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity) // Specify the activity where you need injection
}