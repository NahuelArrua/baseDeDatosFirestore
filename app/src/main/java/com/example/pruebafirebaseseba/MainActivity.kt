package com.example.pruebafirebaseseba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun result(){
        val db = FirebaseFirestore.getInstance()
        db.collection("producto")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d("jj","${document.data["nombre"]}")
                }

            }
            .addOnFailureListener { exception ->

            }

    }
}