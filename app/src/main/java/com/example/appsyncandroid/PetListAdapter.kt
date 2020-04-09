package com.example.appsyncandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appsyncandroid.graphql.MyListPetsQuery
import kotlinx.android.synthetic.main.pet_list_row.view.*


class PetListAdapter internal constructor(context: Context?) :
    RecyclerView.Adapter<PetListAdapter.ViewHolder>() {
    private var mData: List<MyListPetsQuery.Item> = ArrayList()
    private val mInflater: LayoutInflater

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(
            R.layout.pet_list_row,
            parent,
            false
        )
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(mData[position])
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }

    // resets the list with a new set of data
    fun setItems(items: List<MyListPetsQuery.Item>) {
        mData = items
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindData(item: MyListPetsQuery.Item) {
            itemView.txt_name.text = item.name()
            itemView.txt_description.text = item.description()
        }
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
    }
}