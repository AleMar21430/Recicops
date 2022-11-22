package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R

class Past_Recyclers : Fragment() {
    private lateinit var bottombar: BottomNavigationView
    private lateinit var botellas_plast: TextView
    private lateinit var botellas_vid: TextView
    private lateinit var bolsas_plast: TextView
    private lateinit var envases_plast: TextView
    private lateinit var envases_duro: TextView
    private lateinit var libras_basura: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botellas_plast = view.findViewById(R.id.textView_botellas_plast)
        botellas_vid = view.findViewById(R.id.textView_botellas_vid)
        bolsas_plast = view.findViewById(R.id.textView_botellas_plast)
        envases_plast = view.findViewById(R.id.textView_envases_plast)
        envases_duro = view.findViewById(R.id.textView_envases_duro)
        libras_basura = view.findViewById(R.id.textView_libras_basura)

        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_location
    }

    private  fun getData() {
        Toast.makeText(
            requireContext(),getString(R.string.firebase_fetch_error), Toast.LENGTH_LONG
        ).show()
    }


}