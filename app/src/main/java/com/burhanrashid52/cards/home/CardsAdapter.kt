package com.burhanrashid52.cards.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.burhanrashid52.cards.R
import com.burhanrashid52.cards.home.models.Character
import ja.burhanrashid52.base.loadFromUrl
import kotlinx.android.synthetic.main.row_cards.view.*

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    var characterList = mutableListOf<Character>()
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
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun removeTopItem() {
        characterList.removeAt(0)
        notifyDataSetChanged()
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            with(itemView) {
                imgProfilePic.loadFromUrl(character.poster)
                txtName.text = character.title
                txtDescription.text = character.description
            }
        }
    }
}