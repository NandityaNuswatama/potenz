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
    
    private val motivationImages = intArrayOf(
        R.drawable.img_mencari_potensi,
        R.drawable.img_menentukan_jurusan,
        R.drawable.img_mencari_opsi,
        R.drawable.img_mengasah_potensi,
        R.drawable.img_mengisi_waktu,
        R.drawable.img_mempersiapkan_diri
    )
    
    private val motivationTitles = arrayOf(
        "Mencari tahu potensi diri",
        "Menentukan pilihan jurusan yang tepat",
        "Mencari tahu beragam opsi",
        "Mengasah potensi diri dan hardskill",
        "Mengisi waktu luang",
        "Mempersiapkan karier impian"
    )
    
    val listMotivation: ArrayList<CardItem>get(){
        val list = arrayListOf<CardItem>()
        for (position in motivationImages.indices){
            list.add(
                CardItem(
                    image = motivationImages[position],
                    title = motivationTitles[position]
                )
            )
        }
        return list
    }
    
    private val interestImages = intArrayOf(
        R.drawable.img_ilmuwan,
        R.drawable.img_lifestyle,
        R.drawable.img_programmer,
        R.drawable.img_desainer,
        R.drawable.img_manager,
        R.drawable.img_dokter
    )
    
    private val interestTitles = arrayOf(
        "Ilmuwan atau Peneliti",
        "Lifestyle Blogger atau Youtuber",
        "Engineer atau Programmer",
        "Desainer",
        "Manajer",
        "Dokter"
    )
    
    val listInterest: ArrayList<CardItem>get(){
        val list = arrayListOf<CardItem>()
        for (position in interestImages.indices){
            list.add(
                CardItem(
                    image = interestImages[position],
                    title = interestTitles[position]
                )
            )
        }
        return list
    }
    
    val question1 = listOf(
        "Saya analitis dan terorganisasi",
        "Saya bergaul dan menentukan",
        "Saya empati dan teliti",
        "Saya jeli dan kreatif",
        "Saya bergairah dan spontan",
        "Saya ambisius dan ingin tahu"
    )
    
    val question2 = listOf(
        "Memutuskan berdasarkan pada pilihan yang akan lebih menarik bagi pengguna",
        "Melakukan penelitian untuk mencari data guna mendukung keputusanmu",
        "Melakukan beberapa tes pada pilihan yang berbeda sebelum membuat keputusan",
        "Membuat mindmap untuk menentukan pilihan terbaik",
        "Mengevaluasi semua kemungkinan solusi untuk menentukan pendekatan terbaik",
        "Membuat keputusan yang memiliki dampak terbesar pada perusahaan",
        "Mencari keputusan yang paling unik yang orang-orang belum pernah coba sebelumnya"
    )
    
    val question3 = listOf(
        "Kamu melihat catatan masa lalu untuk menganalisa data dan mengidentifikasi wawasan berharga untuk mengidentifikasi",
        "Kamu memecah masalah, menarik pengetahuan dari data yang kompleks, dan merancang solusi praktis dan berskala",
        "Melakukan beberapa tes pada pilihan yang berbeda sebelum membuat keputusan",
        "Kamu membangun struktur dan kerangka proyek dan menguji hipotesis sebelum memberikan produk akhir",
        "Kamu melakukan brainstorm ide dengan anggota tim dan fokus pada sisi kreatif",
        "Kamu menetapkan tujuan dan membuat rencana aksi yang rinci untuk memberikan hasil yang baik",
        "Kamu merencanakan roadmap proyek dan memastikan setiap detail kecil sudah dimasukkan",
        "Kamu merancang ide dan membuat berbagai rencana sebelum kamu mengerjakan draft pertamamu"
    )
}