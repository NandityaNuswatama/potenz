package com.nandits.potenz.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentCourseBinding
import com.nandits.potenz.databinding.FragmentLandingTestBinding
import com.nandits.potenz.ui.test.TestFragment.Companion.QUESTION_INDEX

class LandingTestFragment : Fragment() {
    private var _binding: FragmentLandingTestBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLandingTestBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_landingTestFragment_to_testFragment,
                bundleOf(QUESTION_INDEX to "1")
            )
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}