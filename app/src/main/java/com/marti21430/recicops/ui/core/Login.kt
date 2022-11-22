package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.datastore.dataStore
import android.widget.Toast
import androidx.navigation.findNavController
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Login : Fragment(R.layout.fragment_login) {
    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var email:EditText
    private lateinit var password:EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = view.findViewById(R.id.button_Login)
        register = view.findViewById(R.id.button_Register)
        email = view.findViewById(R.id.edit_loginFragment_email)
        password = view.findViewById(R.id.edit_loginFragment_password)
        checkIsLogged()
        setListeners()
    }

    private fun checkIsLogged() {
        CoroutineScope(Dispatchers.IO).launch {
            val currentUser = requireContext().dataStore.getPreferencesValue(KEY_EMAIL)
            if (currentUser != null) {
                requireView().findNavController().navigate(
                    LoginDirections.actionLoginToMyProfile()
                )
            }
        }
    }

    private fun setListeners() {
        login.setOnClickListener {
            loginUser(
                email = email.text.toString(),
                password = password.text.toString()
            )
            Toast.makeText(
                context,
                getString(R.string.Login_Success),
                Toast.LENGTH_LONG
            ).show()
            requireView().findNavController().navigate(
                LoginDirections.actionLoginToMyProfile()
            )
            }
        register.setOnClickListener {
            requireView().findNavController().navigate(
                LoginDirections.actionLoginToRegister()
            )
        }
    }

    private fun loginUser(email: String, password: String) {
        if ((email == getString(R.string.my_email)) && email == password) {
            saveLoggedUser(email)
        } else {
            Toast.makeText(requireContext(), getString(R.string.Login_Error), Toast.LENGTH_LONG).show()
        }
    }

    private fun saveLoggedUser(email: String) {
        CoroutineScope(Dispatchers.IO).launch {
            requireContext().dataStore.savePreferencesValue(KEY_EMAIL, email)
            requireView().findNavController().navigate(
                LoginDirections.actionLoginToMyProfile()
            )
        }
    }
}