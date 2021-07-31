package com.nandits.potenz.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.data.remote.Resource
import com.nandits.potenz.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<ProfileViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUser()
        with(binding) {
            btnLogout.setOnClickListener {
                viewModel.logOut()
                findNavController().navigate(R.id.action_navigation_profile_to_loginFragment)
            }
        }
    }
    
    private fun initUser() {
        viewModel.getUser().observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Something is wrong...", Toast.LENGTH_SHORT)
                        .show()
                }
                is Resource.Success -> {
                    val data = it.data
                    with(binding) {
                        tvPendidikanProfil.text = data?.level
                        tvNameProfil.text = data?.name
                    }
                }
            }
        })
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}