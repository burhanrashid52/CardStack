package com.burhanrashid52.cards.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.burhanrashid52.cards.R
import com.burhanrashid52.cards.home.models.Movies
import ja.burhanrashid52.base.loadFromUrl
import kotlinx.android.synthetic.main.row_cards.view.*

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    var moviesList = mutableListOf<Movies>()
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
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun removeTopItem() {
        moviesList.removeAt(0)
        notifyDataSetChanged()
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: Movies) {
            with(itemView) {
                imgProfilePic.loadFromUrl(movies.poster)
                txtName.text = movies.title
                txtDescription.text = movies.description
            }
        }
    }
}