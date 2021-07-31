package com.nandits.potenz.ui.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandits.potenz.databinding.ActivityMainBinding.inflate
import com.nandits.potenz.databinding.FragmentTestResult2Binding
import com.nandits.potenz.databinding.FragmentTestResultBinding
import com.nandits.potenz.ui.adapter.CardItemAdapter
import com.nandits.potenz.ui.vm.LearnViewModel
import com.nandits.potenz.utils.ListData
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestResultFragment : Fragment() {
    private var _binding: FragmentTestResult2Binding? = null
    private val binding get() = _binding!!
    private lateinit var mAdapter: CardItemAdapter
    private val viewModel by viewModel<LearnViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestResult2Binding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initRv()
    }
    
    private fun initListener(){
        with(binding){
        
        }
    }
    
    private fun initRv(){
        mAdapter = CardItemAdapter(viewModel.getTicket().toString())
        with(binding.rvJurusan){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
            setHasFixedSize(true)
            mAdapter.setData(ListData.listArticle)
            mAdapter.onItemClick = {
                Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
            }
        }
        with(binding.rvKarir){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
            setHasFixedSize(true)
            mAdapter.setData(ListData.listArticle)
            mAdapter.onItemClick = {
                Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}