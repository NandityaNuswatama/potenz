package com.nandits.potenz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandits.potenz.R
import com.nandits.potenz.data.remote.Resource
import com.nandits.potenz.databinding.FragmentHomeBinding
import com.nandits.potenz.ui.adapter.CardItemAdapter
import com.nandits.potenz.utils.ListData
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val mAdapter by inject<CardItemAdapter>()
    private val viewModel by viewModel<HomeViewModel>()
    
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHeader()
        initListener()
        initRv()
    }
    
    private fun initHeader(){
        viewModel.getUser().observe(viewLifecycleOwner, {
            when(it){
                is Resource.Loading -> {}
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Something is wrong...", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    val data = it.data
                    with(binding){
                        tvSubs.text = data?.subscription
                        tvStatus.text = data?.status
                        tvPendidikan.text = data?.level
                        tvName.text = resources.getString(R.string.hi_placeholder, data?.name)
                    }
                }
            }
        })
    }
    
    private fun initListener(){
        with(binding){
            btnPsikotes.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_landingTestFragment)
            }
        }
    }
    
    private fun initRv(){
        with(binding.rvArticle){
            layoutManager =LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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