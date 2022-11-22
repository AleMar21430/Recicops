package com.marti21430.recicops.ui.core.data

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.marti21430.recicops.R
import com.marti21430.recicops.data.local.entity.FireData
import com.marti21430.recicops.data.repository.place.PlaceRepository
import com.marti21430.recicops.databinding.FragmentMyTrashBinding
import com.marti21430.recicops.ui.core.KEY_USERNAME
import com.marti21430.recicops.ui.core.dataStore
import com.marti21430.recicops.ui.core.getPreferencesValue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class Data_Test :  Fragment(R.layout.fragment_my_trash) {

    private lateinit var binding: FragmentMyTrashBinding
    private lateinit var userId: String

    @Inject
    lateinit var placeRepository: PlaceRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            buttonCommitFirebase.setOnClickListener {

                val time = Calendar.getInstance().time.toString()
                var bolsas_plast = editTextBolsasPlast.text.toString().toIntOrNull()
                var botellas_plast = editTextBotellasPlast.text.toString().toIntOrNull()
                var botellas_vid = editTextBotellasVid.text.toString().toIntOrNull()
                var envases_plast = editTextEnvasesPlast.text.toString().toIntOrNull()
                var envases_duro = editTextEnvasesDuro.text.toString().toIntOrNull()
                var libras_basura = editTextLibrasBasura.text.toString().toFloatOrNull()
                var user = ""
                CoroutineScope(Dispatchers.IO).launch {
                    user = requireContext().dataStore.getPreferencesValue(KEY_USERNAME).toString()
                }

                if (bolsas_plast == null){ bolsas_plast = 0 }
                if (botellas_plast == null){ botellas_plast = 0 }
                if (botellas_vid == null){ botellas_vid = 0 }
                if (envases_duro == null){ envases_duro = 0 }
                if (envases_plast == null){ envases_plast = 0 }
                if (libras_basura == null){ libras_basura = 0.0f }

                lifecycleScope.launch(Dispatchers.IO) {
                    placeRepository.createPlace(
                        place = FireData(
                            id = bolsas_plast.toInt(),
                            user = user,
                            time = time,
                            bolsas_plast = bolsas_plast,
                            botellas_plast = botellas_plast,
                            botellas_vid =botellas_vid,
                            envases_plast = envases_plast,
                            envases_duro = envases_duro,
                            libras_basura = libras_basura
                        ),
                        owner = userId
                    )
                }
            }
        }
    }
}