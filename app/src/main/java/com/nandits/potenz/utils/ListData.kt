package com.nandits.potenz.utils

import com.nandits.potenz.R
import com.nandits.potenz.data.model.CardItem

object ListData {
    private val articleImages = intArrayOf(
        R.drawable.icon_self_dev,
        R.drawable.icon_career,
        R.drawable.icon_top_resource
    )
    
    private val articleTitles = arrayOf(
        "Top 15 Resources For Self-Development",
        "How to Think About Your Career",
        "Top 15 Resources For Self-Development"
    )
    
    val listArticle: ArrayList<CardItem>get(){
        val list = arrayListOf<CardItem>()
        for (position in articleImages.indices){
            list.add(
                CardItem(
                    image = articleImages[position],
                    title = articleTitles[position]
                )
            )
        }
        return list
    }
}