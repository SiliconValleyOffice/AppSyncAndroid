package com.example.appsyncandroid

import android.content.Context
import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.sigv4.CognitoUserPoolsAuthProvider

@Volatile
private var client: AWSAppSyncClient? = null

// first access is the only one that needs to be synchronized
// lazy init client
// singleton should be managed by Dagger

@Synchronized
fun appSyncClientInit(context: Context) {  // eventually converted into an application context
    if (client == null) {
        val awsConfiguration = AWSConfiguration(context)
        client = AWSAppSyncClient.builder()
            .context(context)
            .awsConfiguration(awsConfiguration)   // why doesn't the builder build its own AWSConfiguration
            .cognitoUserPoolsAuthProvider(CognitoUserPoolsAuthProvider {
                try {
                    return@CognitoUserPoolsAuthProvider AWSMobileClient.getInstance().tokens.idToken
                        .tokenString
                } catch (e: Exception) {
                    Log.e("APPSYNC_ERROR", e.localizedMessage)
                    return@CognitoUserPoolsAuthProvider e.localizedMessage  // is this being handled too low ???
                }
            }).build()
    }
}

fun appSyncClient(): AWSAppSyncClient? {
    return client
}