package com.example.appsyncandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appsyncandroid.graphql.MyListPetsQuery
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.annotation.Nonnull

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: MyAdapter

    private var mPets: ArrayList<MyListPetsQuery.Item>? = null
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = recycler_view
        // use a linear layout manager
        mRecyclerView.setLayoutManager(LinearLayoutManager(this));

        // specify an adapter (see also next example)
        mAdapter = MyAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        appSyncClientInit(this)

        btn_addPet.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val addPetIntent = Intent(this@MainActivity, AddPetActivity::class.java)
                this@MainActivity.startActivity(addPetIntent)
            }
        })
    }


    override fun onResume() {
        super.onResume()

        // Query list data when we return to the screen
        query()
    }

    fun query() {
        appSyncClient()?.query(MyListPetsQuery.builder().build())
            ?.responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
            ?.enqueue(queryCallback)
    }

    private val queryCallback: GraphQLCall.Callback<MyListPetsQuery.Data?> =
        object : GraphQLCall.Callback<MyListPetsQuery.Data?>() {

            override fun onFailure(@Nonnull e: ApolloException) {
                Log.e(TAG, e.toString())
            }

            override fun onResponse(response: com.apollographql.apollo.api.Response<MyListPetsQuery.Data?>) {
                mPets = ArrayList(response.data()?.listPets()?.items())
                Log.i(TAG, "Retrieved list items: " + mPets.toString())
                runOnUiThread {
                    mAdapter.setItems(mPets!!)
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
}
