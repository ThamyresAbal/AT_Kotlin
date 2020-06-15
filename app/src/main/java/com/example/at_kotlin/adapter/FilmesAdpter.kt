package com.example.at_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_kotlin.R
import com.example.at_kotlin.model.Filme
import kotlinx.android.synthetic.main.layouthome.view.*

class FilmesAdpter(
    private val filmes : List<Filme>
) : RecyclerView.Adapter
<FilmesAdpter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtNomeFilme = itemView.txtNomeFilme
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder{
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layouthome,
                parent,
                false
            )
        val filmeViewHolder =
            FilmeViewHolder(
                view
            )
        return filmeViewHolder
    }

    override fun getItemCount(): Int = filmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder , position: Int) {
        val filme = filmes[position]
        // filme.capa : Bitmap | Int (Resource)
        // ImageView.setImageBitmap(filme.capa)
        // ImageView.setImageResource(filme.capa)
        holder.txtNomeFilme.text = filme.en

    }
}