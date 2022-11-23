package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.marti21430.recicops.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Register : Fragment(R.layout.fragment_register) {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var ready: Button
    private lateinit var cancel: Button
    private lateinit var auth: FirebaseAuth;

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
            auth = FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(
                        requireContext(),getString(R.string.register_success),Toast.LENGTH_LONG
                    ).show()
                    CoroutineScope(Dispatchers.IO).launch {
                        requireContext().dataStore.savePreferencesValue(KEY_USERNAME, email.text.toString())
                        requireContext().dataStore.savePreferencesValue(KEY_PASSWORD, password.text.toString())
                        requireContext().dataStore.savePreferencesValue(KEY_LOGOUT, "false")
                    }

                    requireView().findNavController().navigate(
                        RegisterDirections.actionRegisterToLogin()
                    )
                }else{
                    Toast.makeText(
                        requireContext(),getString(R.string.firebase_register_error),Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        cancel.setOnClickListener {
            requireView().findNavController().navigate(
                RegisterDirections.actionRegisterToLogin()
            )
        }
    }
}