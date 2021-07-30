package com.nandits.potenz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nandits.potenz.data.model.CardItem
import com.nandits.potenz.databinding.ItemCardviewBinding

class CardItemAdapter: RecyclerView.Adapter<CardItemAdapter.CardViewHolder>() {
    private var listData = ArrayList<CardItem>()
    var onItemClick: ((CardItem) -> Unit)?= null
    
    fun setData(list: List<CardItem>?){
        if (list == null) return
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
    
    inner class CardViewHolder(private val binding: ItemCardviewBinding): RecyclerView.ViewHolder(binding.root)  {
        fun bind(item: CardItem){
            with(binding){
                tvCard.text = item.title
                imgCard.load(item.image)
                
                root.setOnClickListener{
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = ItemCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(listData[position])
    }
    
    override fun getItemCount(): Int {
        return listData.size
    }
    
}