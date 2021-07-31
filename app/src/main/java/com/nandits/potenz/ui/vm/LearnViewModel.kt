package com.nandits.potenz.ui.vm

import androidx.lifecycle.ViewModel
import com.nandits.potenz.data.Repository

class LearnViewModel(private val repository: Repository) : ViewModel() {
    fun getTicket() = repository.getTicket()
}