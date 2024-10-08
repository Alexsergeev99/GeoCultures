package ru.alexsergeev.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.databinding.FragmentMedicationCardBinding
import ru.alexsergeev.presentation.viewmodel.MedicationViewModel

class MedicationCardFragment : Fragment() {
    private val viewModel: MedicationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMedicationCardBinding.inflate(inflater, container, false)

        val medicationId = arguments?.getInt("idArg")

        medicationId?.let {
            val medication = viewModel.getMedication(it)

            binding.singleMedication.medicationName.text = medication.name
            binding.singleMedication.medicationInfo.text = medication.info
            binding.singleMedication.medicationImage.load(medication.image)

            val toolbarTitle = binding.toolbar.findViewById<TextView>(R.id.toolbar_title)
            toolbarTitle.text = medication.name
        }

        val backButton = binding.toolbar.findViewById<ImageButton>(R.id.button_back)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        val searchButton = binding.toolbar.findViewById<ImageButton>(R.id.button_search)
        searchButton.isVisible = false

        return binding.root
    }
}
