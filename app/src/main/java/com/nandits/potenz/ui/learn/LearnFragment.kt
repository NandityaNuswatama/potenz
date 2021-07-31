package com.nandits.potenz.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nandits.potenz.databinding.FragmentLearnBinding
import com.nandits.potenz.ui.adapter.ViewPagerAdapter


class LearnFragment : Fragment() {
    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerAdapter(requireContext(), childFragmentManager)
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