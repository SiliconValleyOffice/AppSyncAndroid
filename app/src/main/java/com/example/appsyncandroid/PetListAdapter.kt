package com.example.appsyncandroid

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.appsyncandroid.activity.PetDeleteActivity
import com.example.appsyncandroid.graphql.MyListPetsQuery
import kotlinx.android.synthetic.main.pet_list_row.view.*

class PetListAdapter internal constructor(context: Context?) :
    RecyclerView.Adapter<PetListAdapter.PetViewHolder>() {
    private var mData: List<MyListPetsQuery.Item> = ArrayList()
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view: View = mInflater.inflate(
            R.layout.pet_list_row,
            parent,
            false
        )
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bindData(mData[position])

        holder.itemView.btn_pet_options.setOnClickListener(View.OnClickListener {
            val popup = PopupMenu(it.context, holder.itemView.btn_pet_options)
            popup.inflate(R.menu.menu_pet)

            popup.setOnMenuItemClickListener { menuItem: MenuItem ->
                val itemID = menuItem
                when (menuItem.itemId) {
                    R.id.pet_update -> {

                    }
                    R.id.pet_delete -> {
                        val intent = Intent(holder.itemView.context, PetDeleteActivity::class.java)
                        holder.itemView.context.startActivity(intent)
                        true
                    }
                }
                true
            }
            popup.show()
        })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setItems(items: List<MyListPetsQuery.Item>) {
        mData = items
    }

    inner class PetViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindData(item: MyListPetsQuery.Item) {
            itemView.txt_name.text = item.name()
            itemView.txt_description.text = item.description()
        }
    }
}