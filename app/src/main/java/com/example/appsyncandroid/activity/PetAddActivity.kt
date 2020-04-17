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
import kotlinx.android.synthetic.main.activity_pet_add.*
import type.CreatePetInput
import javax.annotation.Nonnull


class PetAddActivity : AppCompatActivity() {

    private val tag = PetAddActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_add)
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

    private val mutateCallback: GraphQLCall.Callback<MyCreatePetMutation.Data?> =
        object : GraphQLCall.Callback<MyCreatePetMutation.Data?>() {

            override fun onFailure(@Nonnull e: ApolloException) {
                runOnUiThread {
                    Log.e(tag, "Failed to perform AddPetMutation", e)  // if DEBUG
                    Toast.makeText(this@PetAddActivity, "Failed to add pet", Toast.LENGTH_LONG)
                        .show()
                    finish()
                }
            }

            override fun onResponse(response: com.apollographql.apollo.api.Response<MyCreatePetMutation.Data?>) {
                runOnUiThread {
                    Toast.makeText(this@PetAddActivity, "Added pet", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }

}
