package com.example.soccerinfo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerinfo.R
import com.example.soccerinfo.model.InfoModel
import org.jetbrains.anko.find

class CustomAdapter(
    var context: Context,
    val resources: ArrayList<InfoModel>,
) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount() = resources.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val model = resources[position]



    }





    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}