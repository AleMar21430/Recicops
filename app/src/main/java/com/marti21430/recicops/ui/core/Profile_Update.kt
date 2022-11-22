package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Profile_Update : Fragment(R.layout.fragment_profile_update) {
    private lateinit var cancel: Button
    private lateinit var update: Button
    private lateinit var bottombar: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancel = view.findViewById(R.id.button_Login)
        update = view.findViewById(R.id.button_Register)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        setBottomBar()
        setListeners()
    }

    private fun setListeners() {
        cancel.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                requireView().findNavController().popBackStack()
            }
        }
        update.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                requireView().findNavController().popBackStack()
            }
        }
    }
    private fun setBottomBar(){
        bottombar.selectedItemId = R.id.menu_item_profile
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_myprogress -> requireView().findNavController().navigate(
                    Profile_UpdateDirections.actionProfileUpdateToProgress()
                )
                R.id.menu_item_location -> requireView().findNavController().navigate(
                    Profile_UpdateDirections.actionProfileUpdateToExchangeCenters()
                )
                R.id.menu_item_consumos -> requireView().findNavController().navigate(
                    Profile_UpdateDirections.actionProfileUpdateToMyTrash()
                )
                R.id.menu_item_profile -> requireView().findNavController().popBackStack()
            }

            true
        }
    }
}