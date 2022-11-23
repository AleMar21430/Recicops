package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import com.marti21430.recicops.data.dao.Database
import com.marti21430.recicops.data.model.User
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

    private lateinit var database: Database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        enterdata = view.findViewById(R.id.button_commit)

        botellas_plast = view.findViewById(R.id.editText_botellas_plast)
        botellas_vid = view.findViewById(R.id.editText_botellas_vid)
        bolsas_plast = view.findViewById(R.id.editText_bolsas_plast)
        envases_plast = view.findViewById(R.id.editText_envases_plast)
        envases_duro = view.findViewById(R.id.editText_envases_duro)
        libras_basura = view.findViewById(R.id.editText_libras_basura)

        database = Room.databaseBuilder(
            requireContext(),
            Database::class.java,
            "dbname"
        ).build()

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
            var L_bolsas_plast = bolsas_plast.text.toString()
            var L_botellas_plast = botellas_plast.text.toString()
            var L_botellas_vid = botellas_vid.text.toString()
            var L_envases_plast = envases_plast.text.toString()
            var L_envases_duro = envases_duro.text.toString()
            var L_libras_basura = libras_basura.text.toString()
            var L_user = "Error"
            CoroutineScope(Dispatchers.IO).launch {
                L_user = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            }

            if (L_user == ""){ L_user = "User_Empty" }
            if (L_bolsas_plast == ""){ L_bolsas_plast = "0" }
            if (L_botellas_plast == ""){ L_botellas_plast = "0" }
            if (L_botellas_vid == ""){ L_botellas_vid = "0" }
            if (L_envases_duro == ""){ L_envases_duro = "0" }
            if (L_envases_plast == ""){ L_envases_plast = "0" }
            if (L_libras_basura == ""){ L_libras_basura = "0.0" }

            val user = User(
                L_user = L_user,
                L_time = L_time,
                L_bolsas_plast = L_bolsas_plast,
                L_botellas_plast = L_botellas_plast,
                L_botellas_vid = L_botellas_vid,
                L_envases_plast = L_envases_plast,
                L_envases_duro = L_envases_duro,
                L_libras_basura = L_libras_basura,
            )
            CoroutineScope(Dispatchers.IO).launch {
                database.userDao().insert(user)
            }
            Toast.makeText(requireContext(), getString(R.string.success), Toast.LENGTH_LONG).show()
            requireView().findNavController().navigate(
                My_TrashDirections.actionMyTrashToProgress2()
            )
        }
    }
}