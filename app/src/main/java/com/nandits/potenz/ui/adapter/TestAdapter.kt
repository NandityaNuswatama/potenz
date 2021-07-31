package com.nandits.potenz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandits.potenz.databinding.ItemTestBinding

class TestAdapter :
    RecyclerView.Adapter<TestAdapter.TestViewHolder>() {
    private var listData = ArrayList<String>()
    var onItemClick: ((String) -> Unit)? = null
    
    fun setData(list: List<String>?) {
        if (list == null) return
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
    
    inner class TestViewHolder(private val binding: ItemTestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            with(binding) {
                btnTest.text = item
                root.setOnClickListener {
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view =
            ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(listData[position])
    }
    
    override fun getItemCount(): Int {
        return listData.size
    }
}
