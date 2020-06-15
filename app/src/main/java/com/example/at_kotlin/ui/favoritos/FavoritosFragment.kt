package com.example.at_kotlin.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.at_kotlin.R

class FavoritosFragment : Fragment() {

    private lateinit var favoritosViewModel: FavoritosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritosViewModel =
            ViewModelProviders.of(this).get(FavoritosViewModel::class.java)

        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }
}