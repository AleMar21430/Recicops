package com.marti21430.recicops.ui.core

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.marti21430.recicops.R
import com.marti21430.recicops.ui.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Login : Fragment(R.layout.fragment_login) {
    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var currentPassword:String
    private lateinit var currentUser:String
    private lateinit var googlesignin: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = view.findViewById(R.id.button_Login)
        register = view.findViewById(R.id.button_Register)
        email = view.findViewById(R.id.edit_loginFragment_email)
        password = view.findViewById(R.id.edit_loginFragment_password)
        googlesignin = view.findViewById(R.id.button_Login_google)
        CoroutineScope(Dispatchers.IO).launch {
            currentUser = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            currentPassword = requireContext().dataStore.getPreferencesValue(KEY_PASSWORD).toString()
        }
        checkIsLogged()
        setListeners()
    }

    private fun checkIsLogged() {
        CoroutineScope(Dispatchers.IO).launch {

            if (requireContext().dataStore.getPreferencesValue(KEY_LOGOUT).toString() == "false") {
                navigateToListScreen()
            }
        }
    }

    private fun navigateToListScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            requireView().findNavController().navigate(
                LoginDirections.actionLoginToMyProfile()
            )
        }
    }

    private fun setListeners() {
        login.setOnClickListener {
            loginUser(
                email = email.text.toString(),
                password = password.text.toString()
            )
            }
        register.setOnClickListener {
            requireView().findNavController().navigate(
                LoginDirections.actionLoginToRegister()
            )
        }
        googlesignin.setOnClickListener {
            activity?.let{
                val intent = Intent (this@Login.context, LoginActivity::class.java)
                requireActivity().startActivity(intent)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            currentUser = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            currentPassword = requireContext().dataStore.getPreferencesValue(KEY_PASSWORD).toString()
        }
        if (email == currentUser && password == currentPassword) {
            CoroutineScope(Dispatchers.IO).launch {
                requireContext().dataStore.savePreferencesValue(KEY_LOGOUT, "false")
            }
            saveLoggedUser(email,password)
        } else {
            Toast.makeText(requireContext(), getString(R.string.Login_Error), Toast.LENGTH_LONG).show()
        }
    }

    private fun saveLoggedUser(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            requireContext().dataStore.savePreferencesValue(KEY_USERNAME, email)
        }
        CoroutineScope(Dispatchers.IO).launch {
            requireContext().dataStore.savePreferencesValue(KEY_PASSWORD, password)
        }
        navigateToListScreen()
    }
}