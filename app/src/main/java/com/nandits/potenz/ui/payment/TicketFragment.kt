package com.nandits.potenz.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentTicketBinding
import com.nandits.potenz.ui.vm.PaymentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketFragment : Fragment() {
    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<PaymentViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnBack.setOnClickListener { findNavController().navigateUp() }
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_ticketFragment_to_paymentFragment)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}