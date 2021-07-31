package com.nandits.potenz.ui.insight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nandits.potenz.databinding.FragmentInsightBinding
import com.nandits.potenz.ui.adapter.ViewPagerAdapterInsight

class InsightFragment : Fragment() {
    private var _binding: FragmentInsightBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInsightBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerAdapterInsight(requireContext(), childFragmentManager)
        with(binding) {
            viewPager.adapter = viewPagerAdapter
            tab.setupWithViewPager(viewPager)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}