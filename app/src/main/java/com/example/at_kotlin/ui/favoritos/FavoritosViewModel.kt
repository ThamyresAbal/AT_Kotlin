package com.example.at_kotlin.ui.favoritos

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.at_kotlin.adapter.ListaFavoritosAdpter
import com.example.at_kotlin.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.*

class FavoritosViewModel : ViewModel() {
    //var listaFavoritos: ListaFavorito? = null
    private val firebaseStore = FirebaseFirestore.getInstance()

    fun setupRecycleView(
        recycleView: RecyclerView, context: Context
    ){

        //progressBar.visibility = View.VISIBLE
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var collection =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")

        val task = collection.get()

        task.addOnSuccessListener {

            val listaFavoritos = it.toObjects(ListaFavorito::class.java)

            recycleView.adapter = ListaFavoritosAdpter(listaFavoritos, this::callbackListaFavoritos)
            recycleView.layoutManager = LinearLayoutManager(context)

        }.addOnFailureListener{
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }
    }

    fun callbackListaFavoritos(listaFavorito: ListaFavorito, view: View, context: Context) {
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser



        view.btncExcluir.setOnClickListener{

            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito").document(view.txtNomeListaFavorito.text.toString())
                .delete()
                .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error deleting document", e) }


        }


    }
}