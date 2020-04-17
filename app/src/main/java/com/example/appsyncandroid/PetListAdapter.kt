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
import com.example.appsyncandroid.activity.PetUpdateActivity
import com.example.appsyncandroid.graphql.MyListPetsQuery
import kotlinx.android.synthetic.main.pet_list_row.view.*

const val EXTRA_PET = "EXTRA_PET"

class PetListAdapter internal constructor(context: Context?) :
    RecyclerView.Adapter<PetListAdapter.PetViewHolder>() {
    private var mData: List<MyListPetsQuery.Item> = emptyList()  // immutable, must change whole list
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
//        val view: View = mInflater.inflate(
//            R.layout.pet_list_row,
//            parent,
//            false
//        )
//        return PetViewHolder(view)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder =
        mInflater
            .inflate(
                R.layout.pet_list_row,
                parent,
                false
            )
            .let { PetViewHolder(it) }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bindData(mData[position])

        // create the menu just once
        holder.itemView.btn_pet_options.setOnClickListener(View.OnClickListener {
            val popup = PopupMenu(it.context, holder.itemView.btn_pet_options)
            popup.inflate(R.menu.menu_pet)

            popup.setOnMenuItemClickListener { menuItem: MenuItem ->
                when (menuItem.itemId) {
                    R.id.pet_update -> {  // make it DRY
                        val intent = Intent(holder.itemView.context, PetUpdateActivity::class.java)
                        intent.putExtra(EXTRA_PET, mData[position])
                        holder.itemView.context.startActivity(intent)
                    }
                    R.id.pet_delete -> {
                        val intent = Intent(holder.itemView.context, PetDeleteActivity::class.java)
                        intent.putExtra(EXTRA_PET, mData[position])
                        holder.itemView.context.startActivity(intent)
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

    inner class PetViewHolder(itemView: View) :  // don't need an inner class
        RecyclerView.ViewHolder(itemView) {
        fun bindData(item: MyListPetsQuery.Item) {
            itemView.txt_name.text = item.name()
            itemView.txt_description.text = item.description()
        }
    }
}