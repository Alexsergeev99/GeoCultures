package ru.alexsergeev.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import coil.load
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.databinding.FragmentMainScreenBinding
import ru.alexsergeev.presentation.databinding.FragmentMedicationCardBinding
import ru.alexsergeev.presentation.viewmodel.MedicationViewModel

class MedicationCardFragment : Fragment() {

    private val viewModel: MedicationViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMedicationCardBinding.inflate(inflater, container, false)

        binding.singleMedication.medicationName.text = viewModel.medications.value[0].name
        binding.singleMedication.medicationInfo.text = viewModel.medications.value[0].info
        binding.singleMedication.medicationImage.load(viewModel.medications.value[0].image)

//        val toolbar: Toolbar = binding.toolbar
//        (activity as AppCompatActivity).setSupportActionBar(toolbar)
//        (activity as AppCompatActivity).supportActionBar?.title = "Список"
        return binding.root
    }
}