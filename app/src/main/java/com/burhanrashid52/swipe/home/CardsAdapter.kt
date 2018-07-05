package com.burhanrashid52.swipe.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.burhanrashid52.swipe.R
import ja.burhanrashid52.base.loadFromUrl
import kotlinx.android.synthetic.main.row_cards.view.*

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    var list = mutableListOf(
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/a954krk3f25z.jpg?alt=media&token=c5d73a1d-8c5d-427d-8235-e52a1448f28f",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/stranger_things-HD.jpg?alt=media&token=b156267d-07a9-4f22-a8d8-fc2ff6863bf5",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/westworld_s2.jpg?alt=media&token=99a3c1d2-4165-4a41-9b67-9604273d73c4",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/a954krk3f25z.jpg?alt=media&token=c5d73a1d-8c5d-427d-8235-e52a1448f28f",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/stranger_things-HD.jpg?alt=media&token=b156267d-07a9-4f22-a8d8-fc2ff6863bf5",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/westworld_s2.jpg?alt=media&token=99a3c1d2-4165-4a41-9b67-9604273d73c4",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/a954krk3f25z.jpg?alt=media&token=c5d73a1d-8c5d-427d-8235-e52a1448f28f",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/stranger_things-HD.jpg?alt=media&token=b156267d-07a9-4f22-a8d8-fc2ff6863bf5",
            "https://firebasestorage.googleapis.com/v0/b/rashiddemo-2eca3.appspot.com/o/westworld_s2.jpg?alt=media&token=99a3c1d2-4165-4a41-9b67-9604273d73c4"
    )
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_cards, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemView.imgProfilePic.loadFromUrl(list[position])
        // ImageView avatarImageView = ((MyViewHolder) holder).avatarImageView;
        //avatarImageView.setImageResource(list.get(position));
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun removeTopItem() {
        if (list.size > 0) {
            list.removeAt(0)
            notifyDataSetChanged()
        }
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}