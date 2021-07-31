package com.nandits.potenz.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentSuccessBinding
import com.nandits.potenz.ui.vm.PaymentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuccessFragment : Fragment() {
    private var _binding: FragmentSuccessBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_navigation_home)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}