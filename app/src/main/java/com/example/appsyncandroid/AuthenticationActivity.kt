package com.example.appsyncandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.mobile.client.*

class AuthenticationActivity : AppCompatActivity() {
    private val TAG =
        AuthenticationActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        AWSMobileClient.getInstance().initialize(
            applicationContext,
            object : Callback<UserStateDetails> {
                override fun onResult(userStateDetails: UserStateDetails) {
                    Log.i(TAG, userStateDetails.userState.toString())
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
            Log.e(TAG, e.toString())
        }
    }
}