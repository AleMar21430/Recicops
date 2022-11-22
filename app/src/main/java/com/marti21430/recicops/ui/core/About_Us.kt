package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R


class Info : Fragment(R.layout.fragment_about_us,) {
    private lateinit var bottombar: BottomNavigationView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_profile
        setBottomBar()
    }
    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_myprogress -> requireView().findNavController().navigate(
                    InfoDirections.actionInfo2ToProgress()
                )
                R.id.menu_item_location -> requireView().findNavController().navigate(
                    InfoDirections.actionInfo2ToExchangeCenters()
                )
                R.id.menu_item_consumos -> requireView().findNavController().navigate(
                    InfoDirections.actionInfo2ToMyTrash()
                )
                R.id.menu_item_profile -> requireView().findNavController().popBackStack()
            }

            true
        }
    }
}