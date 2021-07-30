package com.nandits.potenz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nandits.potenz.R
import com.nandits.potenz.data.model.CardItem
import com.nandits.potenz.databinding.ItemMotivationBinding

class MultiSelectAdapter : RecyclerView.Adapter<MultiSelectAdapter.MotivationViewHolder>() {
    private var listData = ArrayList<CardItem>()
    var onItemClick: ((CardItem) -> Unit)? = null
    private var selectedItem = arrayListOf<CardItem>()
    
    init {
        setHasStableIds(true)
    }
    
    fun setData(list: List<CardItem>?) {
        if (list == null) return
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
    
    inner class MotivationViewHolder(private val binding: ItemMotivationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardItem) {
            with(binding) {
                tvCard.text = item.title
                imgCard.load(item.image)
                
                root.setOnClickListener {
                    selectItem(binding, listData[adapterPosition])
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
    
    private fun selectItem(binding: ItemMotivationBinding, item: CardItem) {
        if (!selectedItem.contains(item)) {
            selectedItem.add(item)
            binding.root.setBackgroundResource(R.drawable.background_card_pink)
        } else {
            selectedItem.remove(item)
            binding.root.setBackgroundResource(R.drawable.background_card_white)
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
    
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    
}