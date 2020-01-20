package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val data: List<JsonData>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.userID.text = data[position].userID.toString()
        holder.id.text = data[position].id.toString()
        holder.title.text = data[position].title
        holder.body.text = data[position].body
    }

    class CustomViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val userID: TextView = itemView.findViewById(R.id.userID)
        val id: TextView = itemView.findViewById(R.id.ID)
        val title: TextView = itemView.findViewById(R.id.title)
        val body: TextView = itemView.findViewById(R.id.body)
    }

}
