package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R


class Past_List : Fragment(R.layout.fragment_past_list) {
    private lateinit var bottombar: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_myprogress
        setBottomBar()
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