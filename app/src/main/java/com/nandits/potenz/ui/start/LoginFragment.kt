package com.nandits.potenz.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandits.potenz.R
import com.nandits.potenz.data.model.UserModel
import com.nandits.potenz.data.remote.Resource
import com.nandits.potenz.databinding.FragmentLoginBinding
import com.nandits.potenz.utils.NONE
import com.nandits.potenz.utils.STATUS_DEF
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<LoginViewModel>()
    private var spinnerIndex = 0
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.pendidikan_options,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
            spinner.onItemSelectedListener = this@LoginFragment
            btnNext.setOnClickListener {
                val name = edtName.text.toString()
                val level = spinner.selectedItem.toString()
                viewModel.getUser(name).observe(viewLifecycleOwner, { user ->
                    when (user) {
                        is Resource.Loading -> {
                        }
                        is Resource.Error -> {
                            viewModel.login(name, UserModel(name, NONE, STATUS_DEF, level))
                                .observe(viewLifecycleOwner, { login ->
                                    when (login) {
                                        is Resource.Loading -> {
                                        }
                                        is Resource.Error -> {
                                            Toast.makeText(
                                                requireContext(),
                                                login.message,
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                        is Resource.Success -> {
                                            viewModel.saveUser(login.data as UserModel)
                                            findNavController().navigate(R.id.action_loginFragment_to_chooseInterestFragment)
                                        }
                                    }
                                })
                        }
                        is Resource.Success -> {
                            viewModel.getListUser().observe(viewLifecycleOwner, { list ->
                                when (list) {
                                    is Resource.Loading -> {
                                    }
                                    is Resource.Error -> {
                                        Toast.makeText(
                                            requireContext(),
                                            list.message,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    is Resource.Success -> {
                                        if (list.data?.contains(user.data) == true) {
                                            user.data?.let { userName -> viewModel.saveUser(userName) }
                                            findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
                                        }
                                    }
                                }
                            })
                        }
                    }
                })
            }
        }
    }
    
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinnerIndex = position + 1
    }
    
    override fun onNothingSelected(parent: AdapterView<*>?) {
        spinnerIndex = 0
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}