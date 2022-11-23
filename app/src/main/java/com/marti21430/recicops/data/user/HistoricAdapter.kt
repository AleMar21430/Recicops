package com.marti21430.recicops.data.user
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.marti21430.recicops.R
import com.marti21430.recicops.classes.Historic

class HistoricAdapter (
    private val trash:MutableList<Historic>,private val listener:ListenerPlace
    ):RecyclerView.Adapter<HistoricAdapter.ViewHolder>(){
    interface ListenerPlace{
        fun clickedOnPlace(result:Historic,position:Int)
    }
    class ViewHolder(
        private val view:View,
        private val listenerPlace:ListenerPlace
    ):
        RecyclerView.ViewHolder(view){
            private val date=view.findViewById<TextView>(R.id.date_txt_recyclerF)
            private val plastic = view.findViewById<TextView>(R.id.textView_envases_plast)
            private val duroport = view.findViewById<TextView>(R.id.textView_envases_duro)
            private val bags = view.findViewById<TextView>(R.id.textView8)
            private val pbottles = view.findViewById<TextView>(R.id.textView_botellas_plast)
            private val pcrystal = view.findViewById<TextView>(R.id.textView_botellas_vid)
            private val weight = view.findViewById<TextView>(R.id.textView_libras_basura)
            private val layout:ConstraintLayout = view.findViewById(R.id.constraintLayout3)
        fun loadAll(historic: Historic){
                date.text = historic.date.toString()
                plastic.text = historic.plastic_envase.toString()
                duroport.text = historic.duroport.toString()
                bags.text = historic.plasticBags.toString()
                pbottles.text = historic.plastic_bottles.toString()
                pcrystal.text = historic.cristal.toString()
                weight.text = historic.trash_weight.toString()

            }
            fun oncClicked(historic:Historic){
                layout.setOnClickListener{
                    listenerPlace.clickedOnPlace(historic,this.adapterPosition)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_history_recycler, parent, false)
            return HistoricAdapter.ViewHolder(view = view, listenerPlace = listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadAll(trash[position])
    }

    override fun getItemCount(): Int = trash.size

}