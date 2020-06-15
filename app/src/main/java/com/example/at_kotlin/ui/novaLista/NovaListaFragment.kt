package com.example.at_kotlin.ui.novaLista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.at_kotlin.R

class NovaListaFragment : Fragment() {

    private lateinit var novaListaViewModel: NovaListaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        novaListaViewModel =
            ViewModelProviders.of(this).get(NovaListaViewModel::class.java)

        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }
}