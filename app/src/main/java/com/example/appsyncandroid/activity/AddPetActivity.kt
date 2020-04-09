package com.example.appsyncandroid.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.exception.ApolloException
import com.example.appsyncandroid.R
import com.example.appsyncandroid.appSyncClient
import com.example.appsyncandroid.graphql.MyCreatePetMutation
import kotlinx.android.synthetic.main.activity_add_pet.*
import type.CreatePetInput
import javax.annotation.Nonnull


class AddPetActivity : AppCompatActivity() {

    private val TAG = AddPetActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet)
        btn_save.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                save()
            }
        })
    }

    private fun save() {
        val name =
            editTxt_name.text.toString()
        val description =
            editText_description.text
                .toString()
        val input = CreatePetInput.builder()
            .name(name)
            .description(description)
            .build()
        val addPetMutation = MyCreatePetMutation.builder()
            .input(input)
            .build()
        appSyncClient()?.mutate(addPetMutation)?.enqueue(mutateCallback)
    }

    // Mutation callback code
    private val mutateCallback: GraphQLCall.Callback<MyCreatePetMutation.Data?> =
        object : GraphQLCall.Callback<MyCreatePetMutation.Data?>() {

            override fun onFailure(@Nonnull e: ApolloException) {
                runOnUiThread {
                    Log.e("", "Failed to perform AddPetMutation", e)
                    Toast.makeText(this@AddPetActivity, "Failed to add pet", Toast.LENGTH_SHORT)
                        .show()
                    finish()
                }
            }

            override fun onResponse(response: com.apollographql.apollo.api.Response<MyCreatePetMutation.Data?>) {
                runOnUiThread {
                    Toast.makeText(this@AddPetActivity, "Added pet", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

}
