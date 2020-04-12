package com.example.appsyncandroid.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.appsyncandroid.EXTRA_PET
import com.example.appsyncandroid.R
import com.example.appsyncandroid.appSyncClient
import com.example.appsyncandroid.graphql.MyDeletePetMutation
import com.example.appsyncandroid.graphql.MyListPetsQuery
import kotlinx.android.synthetic.main.activity_pet_delete.*
import type.DeletePetInput
import javax.annotation.Nonnull

class PetDeleteActivity : AppCompatActivity() {

    lateinit var pet : MyListPetsQuery.Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_delete)

        pet = intent.extras.get(EXTRA_PET) as MyListPetsQuery.Item

        txt_name.text = pet.name()
        txt_description.text = pet.description()

        btn_delete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                delete()
            }
        })
    }

    private fun delete() {
        val input = DeletePetInput.builder()
            .id(pet.id())
            .build()

        val deletePetMutation = MyDeletePetMutation.builder()
            .input(input)
            .build()
        appSyncClient()?.mutate(deletePetMutation)?.enqueue(mutateCallback)
    }

    private val mutateCallback: GraphQLCall.Callback<MyDeletePetMutation.Data?> =
        object : GraphQLCall.Callback<MyDeletePetMutation.Data?>() {

            override fun onFailure(@Nonnull e: ApolloException) {
                runOnUiThread {
                    Log.e("", "Failed to perform AddPetMutation", e)
                    Toast.makeText(this@PetDeleteActivity, "Failed to delete pet named ${pet.name()}", Toast.LENGTH_LONG)
                        .show()
                    finish()
                }
            }

            override fun onResponse(@Nonnull response: Response<MyDeletePetMutation.Data?>) {
                runOnUiThread {
                    Toast.makeText(this@PetDeleteActivity, "Deleted pet named ${pet.name()}", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }

}
