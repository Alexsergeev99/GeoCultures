package ru.alexsergeev.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainScreenBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}