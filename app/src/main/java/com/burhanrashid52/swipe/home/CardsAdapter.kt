package com.burhanrashid52.swipe.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.burhanrashid52.swipe.R

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.MyViewHolder>() {

    var list = mutableListOf<Int>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_cards, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // ImageView avatarImageView = ((MyViewHolder) holder).avatarImageView;
        //avatarImageView.setImageResource(list.get(position));
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}