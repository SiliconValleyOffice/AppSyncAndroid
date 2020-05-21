package com.example.appsyncandroid.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.mobile.client.*
import com.example.appsyncandroid.R

class AuthenticationActivity : AppCompatActivity() {
    private val TAG =
        AuthenticationActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        // 1)
        // should be injected/initialized as a singleton into the application class to survive zombie mode
        // zombie mode can occur in certain scenarios when the OS kills the app
        // 2)
        // initialized() is overloaded or mis-named
        // is it initializing, or initializing the login session ?
        // need to look at the source of the SDK
        AWSMobileClient.getInstance().initialize(  // should be initialized in the application object
            applicationContext,
            object : Callback<UserStateDetails> {
                override fun onResult(userStateDetails: UserStateDetails) {
                    Log.i(TAG, userStateDetails.userState.toString())  // should be conditional for DEBUG only
                    when (userStateDetails.userState) {
                        UserState.SIGNED_IN -> {
                            val i =
                                Intent(this@AuthenticationActivity, MainActivity::class.java)
                            startActivity(i)
                        }
                        UserState.SIGNED_OUT -> showSignIn()
                        else -> {
                            AWSMobileClient.getInstance().signOut()
                            showSignIn()
                        }
                    }
                }

                override fun onError(e: Exception) {
                    // just eating errors
                    Log.e(TAG, e.toString())
                }
            })
    }

    private fun showSignIn() {
        try {
            AWSMobileClient.getInstance().showSignIn(
                this,
                SignInUIOptions.builder().nextActivity(MainActivity::class.java).build()
            )
        } catch (e: Exception) {
            // swallowing all exceptions
            Log.e(TAG, e.toString())
        }
    }
}