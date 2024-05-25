package com.example.daggerviewmodelexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.daggerviewmodelexample.di.DaggerAppComponent
import com.example.daggerviewmodelexample.ui.theme.DaggerViewModelExampleTheme
import com.example.daggerviewmodelexample.viewmodel.UserViewModel
import com.example.daggerviewmodelexample.viewmodel.UserViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var userViewModel: UserViewModel

    @Inject lateinit var userViewModelFactory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dagger injection
        val appComponent = DaggerAppComponent.create()
        appComponent.inject(this)

        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)

        // Now you can use userViewModel
        userViewModel.users.observe(this) { users ->
            // Update your UI with the list of users
        }

        setContent {
            DaggerViewModelExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerViewModelExampleTheme {
        Greeting("Android")
    }
}