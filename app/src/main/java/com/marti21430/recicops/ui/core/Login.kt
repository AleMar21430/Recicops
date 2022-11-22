package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.marti21430.recicops.R
import com.marti21430.recicops.data.repository.AuthRepository
import javax.inject.Inject
class Login : Fragment(R.layout.fragment_login) {
    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var email:EditText
    private lateinit var password:EditText
    @Inject
    lateinit var authRepository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = view.findViewById(R.id.button_Login)
        register = view.findViewById(R.id.button_Register)
        email = view.findViewById(R.id.edit_loginFragment_email)
        password = view.findViewById(R.id.edit_loginFragment_password)
        setListeners()
    }

    private fun setListeners() {
        login.setOnClickListener {
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
}