package com.marti21430.recicops.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.marti21430.recicops.R
import com.marti21430.recicops.data.repository.AuthRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var authRepository: AuthRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//    Another way to do navigation
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace(R.id.fragmentContainer_mainActivity, fragment)
//        }
//    }
}