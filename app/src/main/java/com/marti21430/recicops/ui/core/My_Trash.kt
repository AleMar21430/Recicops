package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R

class My_Trash : Fragment(R.layout.fragment_my_trash) {
    private lateinit var bottombar: BottomNavigationView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        setBottomBar()
    }
    private fun setBottomBar(){
        bottombar.selectedItemId = R.id.menu_item_consumos
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_myprogress -> requireView().findNavController().navigate(My_TrashDirections.actionMyTrashToProgress2())
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
}