package ru.alexsergeev.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.adapter.MedicationAdapter
import ru.alexsergeev.presentation.adapter.OnInteractionListener
import ru.alexsergeev.presentation.databinding.FragmentMainScreenBinding
import ru.alexsergeev.presentation.models.MedicationUiModel
import ru.alexsergeev.presentation.viewmodel.MedicationViewModel

class MainScreenFragment : Fragment() {

    private val viewModel: MedicationViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        val adapter = MedicationAdapter(
            object : OnInteractionListener {
                override fun onClick(medication: MedicationUiModel) {
                    val bundle = Bundle().apply {
                        putInt("idArg", medication.id)
                    }
                    findNavController().navigate(
                        R.id.action_mainScreenFragment_to_medicationCardFragment,
                        bundle
                    )
                }
            }
        )
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(context, 2)

        val toolbarTitle = binding.toolbar.findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = "Список"

        val searchButton = binding.toolbar.findViewById<ImageButton>(R.id.button_search)
        searchButton.setOnClickListener {
            binding.searchField.visibility = if (binding.searchField.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        binding.searchField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.setSearchText(text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.medications.collectLatest { list ->
                adapter.submitList(list)
            }
        }

        return binding.root
    }

}