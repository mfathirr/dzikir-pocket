package com.thir.doadandzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thir.doadandzikirapp.R
import com.thir.doadandzikirapp.model.DoaDzikirItem

class DoaDzikirAdapter : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>() {
    private val listData = ArrayList<DoaDzikirItem>()
    // set data from data source to adapter
    fun setData(list: List<DoaDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    // ViewHoler take responsibility for initialize item from layout
    // in this class we will describes our view from layout
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemArabic = view.findViewById<TextView>(R.id.item_arabic)
        val itemTranslate = view.findViewById<TextView>(R.id.item_translate)
    }

    //    onCreateViewHolder provides layout to be used by viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DzikirViewHolder {
        return DzikirViewHolder(
            // LayoutInflater is class to inflat a layout
            LayoutInflater.from(parent.context).inflate(R.layout.item_doa, parent, false)
        )
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        val data = listData[position]
        holder.apply {
            itemTitle.text = data.title
            itemArabic.text = data.arabic
            itemTranslate.text = data.translate
        }
    }
}