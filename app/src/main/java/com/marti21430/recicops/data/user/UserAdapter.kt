package com.marti21430.recicops.data.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marti21430.recicops.R
import com.marti21430.recicops.data.model.User

class UserAdapter(
    private val dataSet: MutableList<User>,
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val fecha: TextView = view.findViewById(R.id.textView_Fecha)
        private val botellas_plast: TextView = view.findViewById(R.id.textView_botellas_plast)
        private val botellas_vid: TextView = view.findViewById(R.id.textView_botellas_vid)
        private val bolsas_plast: TextView = view.findViewById(R.id.textView_bolsas_plast)
        private val envases_plast: TextView = view.findViewById(R.id.textView_envases_plast)
        private val envases_duro: TextView = view.findViewById(R.id.textView_envases_duro)
        private val libras_basura: TextView = view.findViewById(R.id.textView_libras_basura)
        private var username: TextView = view.findViewById(R.id.textView_User)

        fun setData(user: User) {
            user.apply {
                fecha.setText(L_time)
                botellas_plast.setText(L_botellas_plast)
                botellas_vid.setText(L_botellas_vid)
                bolsas_plast.setText(L_botellas_plast)
                envases_plast.setText(L_envases_plast)
                envases_duro.setText(L_envases_duro)
                libras_basura.setText(L_libras_basura)
                username.setText(L_user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }
    override fun getItemCount() = dataSet.size
}