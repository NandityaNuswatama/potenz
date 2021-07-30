package com.nandits.potenz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nandits.potenz.R
import com.nandits.potenz.data.model.CardItem
import com.nandits.potenz.databinding.ItemMotivationBinding

class ChoiceAdapter: RecyclerView.Adapter<ChoiceAdapter.MotivationViewHolder>() {
    private var listData = ArrayList<CardItem>()
    var onItemClick: ((CardItem) -> Unit)?= null
    
    fun setData(list: List<CardItem>?){
        if (list == null) return
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
    
    inner class MotivationViewHolder(private val binding: ItemMotivationBinding): RecyclerView.ViewHolder(binding.root)  {
        fun bind(item: CardItem){
            with(binding){
                tvCard.text = item.title
                imgCard.load(item.image)
                if (item.isSelected) root.setBackgroundColor(itemView.context.getColor(R.color.pink_accent_soft))
                root.setOnClickListener{
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotivationViewHolder {
        val view = ItemMotivationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MotivationViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: MotivationViewHolder, position: Int) {
        holder.bind(listData[position])
    }
    
    override fun getItemCount(): Int {
        return listData.size
    }
    
}