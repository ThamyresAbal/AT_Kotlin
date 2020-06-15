package com.example.at_kotlin.ui.novaLista

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.at_kotlin.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NovaListaViewModel : ViewModel() {

    var listaFavoritos: ListaFavorito? = null
    private val firebaseStore = FirebaseFirestore.getInstance()

    fun verificarNulo(
        view: View, context: Context
    ): Boolean {
        //Verifico se algum campo está nulo ou vazio
        if(
            view.txtNomeLista.text.isNullOrBlank()
        ) {
            return false
        } else {
            //Caso tudo ocorra ok, começo a alimentar o view model com o resto das informações
            listaFavoritos = ListaFavorito(
                listaFavorito = view.txtNomeLista.text.toString()
            )
            return true
        }
    }

    fun salvarNoFirestore(context: Context){
        var collection = firebaseStore.collection("favoritos")

        var lista: MutableMap<String, Any> = HashMap()
        lista["nomeListaFavorito"] = listaFavoritos!!.listaFavorito!!

        collection.document(listaFavoritos!!.listaFavorito!!).set(lista)
    }


    fun fireAddListToUser(view: View) {
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var listaFavoritosRef =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")
        listaFavoritosRef
            .document(view.txtNomeLista.text.toString())
            .set({})

    }


}