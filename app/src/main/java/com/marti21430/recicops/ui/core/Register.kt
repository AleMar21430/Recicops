package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.marti21430.recicops.R
import com.marti21430.recicops.data.repository.AuthRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class Register : Fragment(R.layout.fragment_register) {
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var ready: Button
    private lateinit var cancel: Button
    @Inject
    lateinit var authRepository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = view.findViewById(R.id.edit_registerFragment_username)
        email = view.findViewById(R.id.edit_registerFragment_email)
        password = view.findViewById(R.id.edit_registerFragment_password)
        ready = view.findViewById(R.id.button_Register)
        cancel = view.findViewById(R.id.button_Cancel_Register)
        setListeners()
    }

    private fun setListeners() {
        ready.setOnClickListener {
            lifecycleScope.launch {
                val userId = authRepository.signUpWithEmailPasswordName(email.text.toString(),password.text.toString())
                if (userId!=null){
                    Toast.makeText(
                        requireContext(),"Usuario registrado",Toast.LENGTH_LONG
                    ).show()
                }
                else{
                    Toast.makeText(
                        requireContext(),"Usuario no pudo ser registrado",Toast.LENGTH_LONG
                    ).show()
                }
                requireView().findNavController().popBackStack()
            }
        }
        cancel.setOnClickListener {
            requireView().findNavController().popBackStack()
        }
    }
}