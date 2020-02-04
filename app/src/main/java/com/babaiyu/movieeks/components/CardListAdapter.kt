package com.babaiyu.movieeks.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.DataDetail
import com.bumptech.glide.Glide

class CardListAdapter(private val listItem: ArrayList<DataDetail>) :
    RecyclerView.Adapter<CardListAdapter.CardListHolder>() {

    var onItemClick: ((DataDetail) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardListHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: CardListHolder, position: Int) {
        val (title, release, description, score, duration, director, caster, photo) = listItem[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.photo)
        holder.title.text = title
        holder.release.text = release
        holder.description.text = description
    }

    inner class CardListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_title)
        val release: TextView = itemView.findViewById(R.id.item_release)
        val description: TextView = itemView.findViewById(R.id.item_description)
        val photo: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listItem[adapterPosition])
            }
        }
    }

}