package com.nandits.potenz.ui.choice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentChooseMotivationBinding
import com.nandits.potenz.ui.adapter.ChoiceAdapter
import com.nandits.potenz.utils.ListData
import org.koin.android.ext.android.inject


class ChooseMotivationFragment : Fragment() {
    private var _binding: FragmentChooseMotivationBinding? = null
    private val binding get() = _binding!!
    private val mAdapter by inject<ChoiceAdapter>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseMotivationBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
        initListener()
    }
    
    private fun initListener() {
        with(binding) {
            btnClose.setOnClickListener { findNavController().navigateUp() }
            btnNext.setOnClickListener { findNavController().navigate(R.id.action_chooseMotivationFragment_to_chooseInterestFragment) }
        }
    }
    
    private fun initRv() {
        with(binding.rvMotivation) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
            setHasFixedSize(true)
            mAdapter.setData(ListData.listMotivation)
            mAdapter.onItemClick = {
                it.isSelected = !it.isSelected
                isSelected = it.isSelected
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}