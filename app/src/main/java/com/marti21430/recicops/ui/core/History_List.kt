package com.marti21430.recicops.ui.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marti21430.recicops.R
import com.marti21430.recicops.data.dao.Database
import com.marti21430.recicops.data.model.User
import com.marti21430.recicops.data.user.UserAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class History_List : Fragment(R.layout.fragment_history_list) {
    private lateinit var bottombar: BottomNavigationView
    private lateinit var deletedata: Button

    private lateinit var fecha: TextView
    private lateinit var botellas_plast: TextView
    private lateinit var botellas_vid: TextView
    private lateinit var bolsas_plast: TextView
    private lateinit var envases_plast: TextView
    private lateinit var envases_duro: TextView
    private lateinit var libras_basura: TextView

    private lateinit var database: Database
    private lateinit var userAdapter: UserAdapter
    private val userList: MutableList<User> = mutableListOf()
    private lateinit var recyclerUsers: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deletedata = view.findViewById(R.id.button_deleteRecycler_Items)

        bottombar = view.findViewById(R.id.bottomNavigation_mainActivity)
        bottombar.selectedItemId = R.id.menu_item_myprogress

        fecha = view.findViewById(R.id.textView_Fecha)
        botellas_plast = view.findViewById(R.id.textView_botellas_plast)
        botellas_vid = view.findViewById(R.id.textView_botellas_vid)
        bolsas_plast = view.findViewById(R.id.textView8)
        envases_plast = view.findViewById(R.id.textView_envases_plast)
        envases_duro = view.findViewById(R.id.textView_envases_duro)
        libras_basura = view.findViewById(R.id.textView_libras_basura)
        recyclerUsers = view.findViewById(R.id.history_recycler)

        database = Room.databaseBuilder(
            requireContext(),
            Database::class.java,
            "dbname"
        ).build()

        getUsers()
        setBottomBar()
        setListeners()
    }

    private fun setListeners() {
        deletedata.setOnClickListener {
            showDeleteDialog()
        }

    }

    private fun setBottomBar(){
        bottombar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_profile ->{
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToMyProfile3()
                    )
                }
                R.id.menu_item_my_trash -> {
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToMyTrash()
                    )
                }
                R.id.menu_item_location -> {
                    requireView().findNavController().navigate(
                        History_ListDirections.actionProgressToExchangeCenters()
                    )
                }
            }
            true
        }
    }

    private fun getUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            var users = database.userDao().getUsers()
            var Currentuser = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            for(user in users){
                if(user.L_user == Currentuser) {
                    userList.add(user)
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                setupRecycler()
            }
        }
    }

    private fun showDeleteDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle(getString(R.string.warning))
            setMessage(getString(R.string.warningmsg))
            setPositiveButton(getString(R.string.eliminate)
            ) { _, _ ->
                deleteAllUsers()
                userList.clear()
                userAdapter.notifyDataSetChanged()
            }
            setNegativeButton(getString(R.string.cancel)) { _, _ -> }
            show()
        }
    }

    private fun deleteAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            var users = database.userDao().getUsers()
            var Currentuser = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
            for(user in users){
                if(user.L_user == Currentuser) {
                    database.userDao().delete(user)
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(
                    requireContext(),
                    buildString {
                        append(getString(R.string.eliminado))
                        append(users)
                        append(getString(R.string.usuarios))
                    },
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setupRecycler() {
        userAdapter = UserAdapter(userList)
        recyclerUsers.apply {
            visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = userAdapter
        }
    }
}