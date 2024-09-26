package ru.alexsergeev.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.alexsergeev.presentation.adapter.MedicationAdapter
import ru.alexsergeev.presentation.adapter.onInteractionListener
import ru.alexsergeev.presentation.databinding.FragmentMainScreenBinding
import ru.alexsergeev.presentation.models.MedicationUiModel

class MainScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainScreenBinding.inflate(
            inflater,
            container,
            false
        )

        val adapter = MedicationAdapter(object : onInteractionListener {
            override fun onClick(medication: MedicationUiModel) {
                TODO("Not yet implemented")
            }
        }
        )
        return binding.root
    }
}