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


class History_List : Fragment(R.layout.fragment_history_list) {
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
        setBottomBar()
    }



    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_profile ->{
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToMyProfile3()
                    )
                }
                R.id.menu_item_my_trash -> {
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToMyTrash()
                    )
                }
                R.id.menu_item_location -> {
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToExchangeCenters()
                    )
                }
            }
            true
        }
    }
}