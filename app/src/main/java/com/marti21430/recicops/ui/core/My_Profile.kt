package com.marti21430.recicops.ui.core

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.*
import androidx.navigation.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class My_Profile : Fragment(R.layout.fragment_my_profile) {

    private lateinit var tutorial: Button
    private lateinit var logout: Button
    private lateinit var whoarewe: Button
    private lateinit var bottombar: BottomNavigationView
    private lateinit var username: TextView
    private lateinit var user: String
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tutorial = view.findViewById(R.id.button_como_usar)
        logout = view.findViewById(R.id.button_cerrar_sesion)
        whoarewe = view.findViewById(R.id.button_quienes_somos)
        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_profile
        username = view.findViewById(R.id.text_Name)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this.requireActivity(),gso)

        setListeners()
        setBottomBar()
        setName()
    }

    private fun setName(){
        CoroutineScope(Dispatchers.IO).launch {
            user = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            username.setText(user)
        }
    }

    private fun setListeners() {
        tutorial.setOnClickListener {
            requireView().findNavController().navigate(My_ProfileDirections.actionMyProfileToTutorial())
        }
        logout.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                requireContext().dataStore.savePreferencesValue(KEY_LOGOUT, "true")
            }
            mGoogleSignInClient.signOut().addOnCompleteListener {
                requireView().findNavController().navigate(
                    My_ProfileDirections.actionMyProfileToLogin()
                )
            }
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
                R.id.menu_item_my_trash -> requireView().findNavController().navigate(
                    My_ProfileDirections.actionMyProfileToMyTrash()
                )
            }
            true
        }
    }
}