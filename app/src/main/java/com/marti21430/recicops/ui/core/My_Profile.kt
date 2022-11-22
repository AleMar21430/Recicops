package com.marti21430.recicops.ui.core

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.*
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R

class My_Profile : Fragment(R.layout.fragment_my_profile) {

    private lateinit var tutorial: Button
    private lateinit var logout: Button
    private lateinit var canjes: Button
    private lateinit var whoarewe: Button
    private lateinit var bottombar : BottomNavigationView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tutorial = view.findViewById(R.id.button_como_usar)
        logout = view.findViewById(R.id.button_cerrar_sesion)
        whoarewe = view.findViewById(R.id.button_quienes_somos)
        canjes = view.findViewById(R.id.button_consumoscanjeados_myprofile)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_profile
        setListeners()
        setBottomBar()
    }

    private fun setListeners() {
        tutorial.setOnClickListener {
            requireView().findNavController().navigate(My_ProfileDirections.actionMyProfileToTutorial())
        }
        logout.setOnClickListener {
            requireView().findNavController().navigate(
                My_ProfileDirections.actionMyProfileToLogin()
            )
        }
        canjes.setOnClickListener {

        }
        whoarewe.setOnClickListener {
            requireView().findNavController().navigate(My_ProfileDirections.actionMyProfileToInfo2())
        }

    }
    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_myprogress -> requireView().findNavController().navigate(
                    My_ProfileDirections.actionMyProfileToProgress()
                )
                R.id.menu_item_location -> requireView().findNavController().navigate(
                    My_ProfileDirections.actionMyProfileToExchangeCenters()
                )
                R.id.menu_item_consumos -> requireView().findNavController().navigate(
                    My_ProfileDirections.actionMyProfileToMyTrash()
                )
            }

            true
        }
    }


}