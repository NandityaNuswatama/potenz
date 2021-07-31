package com.nandits.potenz.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentTestBinding
import com.nandits.potenz.ui.adapter.TestAdapter
import com.nandits.potenz.utils.ListData
import org.koin.android.ext.android.inject

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    private val mAdapter by inject<TestAdapter>()
    private val index by lazy {
        arguments?.getString(QUESTION_INDEX, "1")
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }
    
    private fun initRv(){
        with(binding.rvTest){
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            setHasFixedSize(true)
            when(index){
                INDEX1 ->{
                    binding.tvQuestion.text = resources.getString(R.string.question1)
                    mAdapter.setData(ListData.question1)
                    mAdapter.onItemClick = {
                        findNavController().navigate(R.id.action_testFragment_self, bundleOf(
                            QUESTION_INDEX to INDEX2))
                    }
                }
                INDEX2 ->{
                    binding.tvQuestion.text = resources.getString(R.string.question2)
                    mAdapter.setData(ListData.question2)
                    mAdapter.onItemClick = {
                        findNavController().navigate(R.id.action_testFragment_self, bundleOf(
                            QUESTION_INDEX to INDEX3))
                    }
                }
                INDEX3 ->{
                    binding.tvQuestion.text = resources.getString(R.string.question3)
                    mAdapter.setData(ListData.question3)
                    mAdapter.onItemClick = {
                        findNavController().navigate(R.id.action_testFragment_to_loadingResultFragment)
                    }
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    companion object{
        const val QUESTION_INDEX = "1"
        const val INDEX1 = "1"
        const val INDEX2= "2"
        const val INDEX3 = "3"
    }
}