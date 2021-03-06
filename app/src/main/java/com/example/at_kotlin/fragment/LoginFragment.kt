package com.example.at_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at_kotlin.R
import com.example.at_kotlin.viewModel.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private lateinit var usuarioViewModel: UsuarioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }
        txtSemCadastro.setOnClickListener{
            findNavController().navigate(R.id.cadastroFragment)
        }
        btnLogin.setOnClickListener {
            if(txtEmail.text.isNullOrBlank()|| txtSenha.text.isNullOrBlank()) {
                Toast.makeText(context, "Preencha todas as informações", Toast.LENGTH_SHORT).show()
            }else{
                usuarioViewModel.loginFirestore(requireContext().applicationContext,txtEmail.text.toString(), txtSenha.text.toString())
                }
            }
        }
    }
