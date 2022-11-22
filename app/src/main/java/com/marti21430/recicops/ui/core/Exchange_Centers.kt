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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        maps = view.findViewById(R.id.button_Maps)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_location
        setListeners()
        setBottomBar()
    }

    private fun setListeners() {
        maps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:14.603797535533332, -90.48936031586945"))
            //https://www.google.com/maps/place/Pizza+Vesuvio+%E2%80%A2+Cayal%C3%A1/@14.6096919,-90.4879125,17z/data=!4m5!3m4!1s0x8589a4b4142b1dff:0x11b3c522940c2e18!8m2!3d14.6086548!4d-90.4867692
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