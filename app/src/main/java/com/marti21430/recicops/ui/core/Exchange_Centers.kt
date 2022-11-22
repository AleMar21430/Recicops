package com.marti21430.recicops.ui.core

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.gms.maps.MapView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R

class Exchange_Centers : Fragment(R.layout.fragment_exchange_centers) {
    private lateinit var bottombar: BottomNavigationView
    private lateinit var maps: Button
    private lateinit var maps_img: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        maps = view.findViewById(R.id.button_Maps)
        maps_img = view.findViewById(R.id.button_Map_Img)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_location
        setListeners()
        setBottomBar()
    }

    private fun setListeners() {
        maps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:14.603797535533332, -90.48936031586945"))
            val Maps = Intent.createChooser(intent, "Launch Maps")
            startActivity(Maps)
        }
        maps_img.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:14.603797535533332, -90.48936031586945"))
            val Maps = Intent.createChooser(intent, "Launch Maps")
            startActivity(Maps)
        }
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