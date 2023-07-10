package com.example.pruebafirebaseseba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onResume() {
        super.onResume()
        runBlocking {
            val listaProductos = result()

//            Toast.makeText(this,"Algo",Toast.LENGTH_SHORT).show()
        }
    }

     private fun result(): List<String>? {
         val miLista: MutableList<String> = mutableListOf()

         val db = FirebaseFirestore.getInstance()
         db.collection("producto")
             .get()
             .addOnSuccessListener { result ->
                 for (document in result){
                     Log.d("jj","${document.data["nombre"]}")
                     miLista.add(document.data["nombre"].toString())
                 }

             }
             .addOnFailureListener { _ ->
                 Log.d("jj","Entra por exception")
             }
         return if (miLista.size > 0) {
             Log.d("jj","resultado de la lista ${miLista.size}")
             miLista
         } else null
     }
}