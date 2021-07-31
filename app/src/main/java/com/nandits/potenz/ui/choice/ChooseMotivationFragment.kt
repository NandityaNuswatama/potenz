package com.nandits.potenz.ui.choice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentChooseMotivationBinding
import com.nandits.potenz.ui.adapter.MultiSelectAdapter
import com.nandits.potenz.utils.ListData
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseMotivationFragment : Fragment() {
    private var _binding: FragmentChooseMotivationBinding? = null
    private val binding get() = _binding!!
    private val mAdapter by inject<MultiSelectAdapter>()
    private val viewModel by viewModel<ChoiceViewModel>()
    
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
            btnNext.setOnClickListener { findNavController().navigate(R.id.action_chooseMotivationFragment_to_navigation_home) }
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
                viewModel
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}