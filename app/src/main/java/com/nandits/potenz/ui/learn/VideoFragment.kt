package com.nandits.potenz.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandits.potenz.R
import com.nandits.potenz.databinding.FragmentVideoBinding
import com.nandits.potenz.ui.adapter.CardItemAdapter
import com.nandits.potenz.ui.adapter.CardItemAdapter1
import com.nandits.potenz.ui.adapter.CardItemAdapter2
import com.nandits.potenz.ui.vm.LearnViewModel
import com.nandits.potenz.utils.ListData
import com.nandits.potenz.utils.dialogShow
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoFragment : Fragment() {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAdapter: CardItemAdapter
    private lateinit var mAdapter1: CardItemAdapter1
    private lateinit var mAdapter2: CardItemAdapter2
    private val viewModel by viewModel<LearnViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }
    
    private fun initRv(){
        with(binding.rvFirst) {
            mAdapter = CardItemAdapter(viewModel.getTicket().toString())
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
            setHasFixedSize(true)
            mAdapter.setData(ListData.listSoftDev)
            mAdapter.onItemClick = {
                findNavController().navigate(
                    R.id.action_navigation_course_to_detailVideoFragment
                )
            }
            mAdapter.cantOpenClick = {
                activity?.dialogShow {
                    findNavController().navigate(R.id.action_navigation_course_to_ticketFragment)
                }
            }
        }
        with(binding.rvSecond) {
            mAdapter1 = CardItemAdapter1(viewModel.getTicket().toString())
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter1
            setHasFixedSize(true)
            mAdapter1.setData(ListData.listTech)
            mAdapter1.onItemClick = {
                findNavController().navigate(
                    R.id.action_navigation_course_to_detailVideoFragment
                )
            }
            mAdapter.cantOpenClick = {
                activity?.dialogShow {
                    findNavController().navigate(R.id.action_navigation_course_to_ticketFragment)
                }
            }
        }
        with(binding.rvThird) {
            mAdapter2 = CardItemAdapter2(viewModel.getTicket().toString())
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter2
            setHasFixedSize(true)
            mAdapter2.setData(ListData.listArticle)
            mAdapter2.onItemClick = {
                findNavController().navigate(
                    R.id.action_navigation_course_to_detailVideoFragment
                )
            }
            mAdapter2.cantOpenClick = {
                activity?.dialogShow {
                    findNavController().navigate(R.id.action_navigation_course_to_ticketFragment)
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}