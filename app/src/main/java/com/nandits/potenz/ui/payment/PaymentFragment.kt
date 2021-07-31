package com.nandits.potenz.ui.payment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.data.remote.Resource
import com.nandits.potenz.databinding.FragmentPaymentBinding
import com.nandits.potenz.ui.vm.PaymentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentFragment : Fragment() {
    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<PaymentViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnBack.setOnClickListener { findNavController().navigateUp() }
            btnNext.setOnClickListener {
                viewModel.buyTicket("11").observe(viewLifecycleOwner, {
                    when(it){
                        is Resource.Loading -> {}
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), "Something is wrong...", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Success -> {
                            linePayment.isGone = false
                            Toast.makeText(requireContext(), "Mohon tunggu sebentar", Toast.LENGTH_SHORT).show()
                            Handler(Looper.getMainLooper()).postDelayed({
                                linePayment.isGone = true
                                findNavController().navigate(R.id.action_paymentFragment_to_successFragment)
                            }, 2000)
                        }
                    }
                })
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}