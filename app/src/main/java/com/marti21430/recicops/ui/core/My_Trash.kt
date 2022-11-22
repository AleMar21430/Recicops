package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class My_Trash : Fragment(R.layout.fragment_my_trash) {
    private lateinit var enterdata: Button
    private lateinit var bottombar: BottomNavigationView
    private lateinit var botellas_plast: EditText
    private lateinit var botellas_vid: EditText
    private lateinit var bolsas_plast: EditText
    private lateinit var envases_plast: EditText
    private lateinit var envases_duro: EditText
    private lateinit var libras_basura: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        enterdata = view.findViewById(R.id.button)

        botellas_plast = view.findViewById(R.id.editText_botellas_plast)
        botellas_vid = view.findViewById(R.id.editText_botellas_vid)
        bolsas_plast = view.findViewById(R.id.editText_bolsas_plast)
        envases_plast = view.findViewById(R.id.editText_envases_plast)
        envases_duro = view.findViewById(R.id.editText_envases_duro)
        libras_basura = view.findViewById(R.id.editText_libras_basura)

        setBottomBar()
        setListeners()
    }
    private fun setBottomBar(){
        bottombar.selectedItemId = R.id.menu_item_my_trash
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
    private fun setListeners() {
        enterdata.setOnClickListener {
            var var1 = botellas_plast.text.toString().toFloat()
            var var2 = botellas_vid.text.toString().toFloat()
            var var3 = bolsas_plast.text.toString().toFloat()
            var var4 = envases_plast.text.toString().toFloat()
            var var5 = envases_duro.text.toString().toFloat()
            var var6 = libras_basura.text.toString().toFloat()
            var var7 = Calendar.getInstance().time.time.toFloat()
            CoroutineScope(Dispatchers.IO).launch {
                var var8 = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            }

        }
    }
}