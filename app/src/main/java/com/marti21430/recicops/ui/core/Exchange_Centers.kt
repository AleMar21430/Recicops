package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R

class Exchange_Centers : Fragment(R.layout.fragment_exchange_centers) {
    private lateinit var bottombar: BottomNavigationView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_location
        setBottomBar()
    }
    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_profile ->{
                    requireView().findNavController().navigate(
                        Exchange_CentersDirections.actionExchangeCentersToMyProfile()
                    )
                }

                R.id.menu_item_myprogress -> {
                    requireView().findNavController().navigate(
                        Exchange_CentersDirections.actionExchangeCentersToProgress()
                    )
                }
                R.id.menu_item_consumos -> {
                    requireView().findNavController().navigate(
                        Exchange_CentersDirections.actionExchangeCentersToMyTrash()
                    )
                }
            }
            true
        }
    }
}