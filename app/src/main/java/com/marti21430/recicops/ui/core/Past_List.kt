package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import java.util.Calendar


class Past_List : Fragment(R.layout.fragment_past_list) {
    private lateinit var bottombar: BottomNavigationView
    private lateinit var syncdata: Button

    private lateinit var fecha: TextView
    private lateinit var botellas_plast: TextView
    private lateinit var botellas_vid: TextView
    private lateinit var bolsas_plast: TextView
    private lateinit var envases_plast: TextView
    private lateinit var envases_duro: TextView
    private lateinit var libras_basura: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        syncdata = view.findViewById(R.id.button_Sync)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_myprogress

        fecha = view.findViewById(R.id.textView_Fecha)
        botellas_plast = view.findViewById(R.id.textView_botellas_plast)
        botellas_vid = view.findViewById(R.id.textView_botellas_vid)
        bolsas_plast = view.findViewById(R.id.textView_bolsas_plast)
        envases_plast = view.findViewById(R.id.textView_envases_plast)
        envases_duro = view.findViewById(R.id.textView_envases_duro)
        libras_basura = view.findViewById(R.id.textView_libras_basura)

        setBottomBar()
        setListeners()
    }

    private fun setListeners() {
        syncdata.setOnClickListener {
            fecha.setText(Calendar.getInstance().time.toString())
            botellas_plast.setText("0")
            botellas_vid.setText("0")
            bolsas_plast.setText("0")
            envases_plast.setText("0")
            envases_duro.setText("0")
            libras_basura.setText("0.05")
        }
    }

    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_profile ->{
                    requireView().findNavController().navigate(
                        Past_ListDirections.actionProgressToMyProfile3()
                    )
                }
                R.id.menu_item_my_trash -> {
                    requireView().findNavController().navigate(
                        Past_ListDirections.actionProgressToMyTrash()
                    )
                }
                R.id.menu_item_location -> {
                    requireView().findNavController().navigate(
                        Past_ListDirections.actionProgressToExchangeCenters()
                    )
                }
            }
            true
        }
    }
}