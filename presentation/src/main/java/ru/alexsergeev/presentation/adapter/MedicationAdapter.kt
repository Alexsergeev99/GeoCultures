package ru.alexsergeev.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.alexsergeev.presentation.databinding.CardMedicationBinding
import ru.alexsergeev.presentation.models.MedicationUiModel

interface OnInteractionListener {
    fun onClick(medication: MedicationUiModel)
}

class MedicationAdapter(
    private val onInteractionListener: OnInteractionListener,
    diffCallback: DiffUtil.ItemCallback<MedicationUiModel> = MedicationUiModelDiffCallback()
) : ListAdapter<MedicationUiModel, MedicationViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val binding = CardMedicationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MedicationViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class MedicationViewHolder(
    private val binding: CardMedicationBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(medication: MedicationUiModel?) {
        if (medication != null) {
            binding.apply {
                medicationName.text = medication.name
                medicationInfo.text = medication.info
                binding.medicationImage.load(medication.image)
                root.setOnClickListener {
                    onInteractionListener.onClick(medication)
                }
            }
        } else {
            binding.medicationName.text = ""
            binding.medicationInfo.text = ""
        }
    }
}

class MedicationUiModelDiffCallback : DiffUtil.ItemCallback<MedicationUiModel>() {
    override fun areItemsTheSame(oldItem: MedicationUiModel, newItem: MedicationUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MedicationUiModel,
        newItem: MedicationUiModel
    ): Boolean {
        return oldItem == newItem
    }
}