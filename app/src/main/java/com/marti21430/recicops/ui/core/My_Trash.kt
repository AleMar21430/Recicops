package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class My_Trash : Fragment(R.layout.fragment_my_trash) {
    private lateinit var enterdata: Button
    private lateinit var bottombar: BottomNavigationView
    private lateinit var botellas_plast: EditText
    private lateinit var botellas_vid: EditText
    private lateinit var bolsas_plast: EditText
    private lateinit var envases_plast: EditText
    private lateinit var envases_duro: EditText
    private lateinit var libras_basura: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        enterdata = view.findViewById(R.id.button_commit_firebase)

        botellas_plast = view.findViewById(R.id.editText_botellas_plast)
        botellas_vid = view.findViewById(R.id.editText_botellas_vid)
        bolsas_plast = view.findViewById(R.id.editText_bolsas_plast)
        envases_plast = view.findViewById(R.id.editText_envases_plast)
        envases_duro = view.findViewById(R.id.editText_envases_duro)
        libras_basura = view.findViewById(R.id.editText_libras_basura)

        setBottomBar()
        setListeners()
    }
    private fun setBottomBar(){
        bottombar.selectedItemId = R.id.menu_item_my_trash
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_myprogress -> requireView().findNavController().navigate(
                    My_TrashDirections.actionMyTrashToProgress2()
                )
                R.id.menu_item_location -> requireView().findNavController().navigate(
                    My_TrashDirections.actionMyTrashToExchangeCenters()
                )
                R.id.menu_item_profile -> requireView().findNavController().navigate(
                    My_TrashDirections.actionMyTrashToMyProfile()
                )
            }
            true
        }
    }
    private fun setListeners() {
        enterdata.setOnClickListener {
            val L_time = Calendar.getInstance().time.toString()
            var L_bolsas_plast = bolsas_plast.text.toString().toIntOrNull()
            var L_botellas_plast = botellas_plast.text.toString().toIntOrNull()
            var L_botellas_vid = botellas_vid.text.toString().toIntOrNull()
            var L_envases_plast = envases_plast.text.toString().toIntOrNull()
            var L_envases_duro = envases_duro.text.toString().toIntOrNull()
            var L_libras_basura = libras_basura.text.toString().toFloatOrNull()
            var L_user = ""
            CoroutineScope(Dispatchers.IO).launch {
                L_user = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            }

            if (L_bolsas_plast == null){ L_bolsas_plast = 0 }
            if (L_botellas_plast == null){ L_botellas_plast = 0 }
            if (L_botellas_vid == null){ L_botellas_vid = 0 }
            if (L_envases_duro == null){ L_envases_duro = 0 }
            if (L_envases_plast == null){ L_envases_plast = 0 }
            if (L_libras_basura == null){ L_libras_basura = 0.0f }

            val Fire_Container = hashMapOf(
                "User" to L_user,
                "Time" to L_time,
                "Bolsas de Plástico" to L_bolsas_plast,
                "Botellas de Plástico" to L_botellas_plast,
                "Botellas de Vidrio" to L_botellas_vid,
                "Envases de Plástico" to L_envases_plast,
                "Envases de Duroport" to L_envases_duro,
                "Libras de Basura" to L_libras_basura,
            )

            val firestore = FirebaseFirestore.getInstance()

            firestore.collection("user_data")
                .add(Fire_Container)
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),getString(R.string.firebase_upload_succes), Toast.LENGTH_LONG
                    ).show()
                    requireView().findNavController().navigate(
                        My_TrashDirections.actionMyTrashToProgress2()
                    )
                }.addOnFailureListener {
                    Toast.makeText(
                        requireContext(),getString(R.string.firebase_upload_error), Toast.LENGTH_LONG
                    ).show()
                }

        }
    }
}