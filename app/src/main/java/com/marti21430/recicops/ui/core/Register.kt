package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Register : Fragment(R.layout.fragment_register) {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var ready: Button
    private lateinit var cancel: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = view.findViewById(R.id.edit_registerFragment_email)
        password = view.findViewById(R.id.edit_registerFragment_password)
        ready = view.findViewById(R.id.button_Register)
        cancel = view.findViewById(R.id.button_Cancel_Register)
        setListeners()
    }

    private fun setListeners() {
        ready.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                requireContext().dataStore.savePreferencesValue(KEY_USERNAME, email.text.toString())
                requireContext().dataStore.savePreferencesValue(KEY_PASSWORD, password.text.toString())
                requireContext().dataStore.savePreferencesValue(KEY_LOGOUT, "false")
            }
            requireView().findNavController().navigate(
                RegisterDirections.actionRegisterToLogin()
            )
        }
        cancel.setOnClickListener {
            requireView().findNavController().navigate(
                RegisterDirections.actionRegisterToLogin()
            )
        }
    }
}