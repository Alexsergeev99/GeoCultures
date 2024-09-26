package ru.alexsergeev.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.databinding.CardMedicationBinding
import ru.alexsergeev.presentation.models.MedicationUiModel

interface onInteractionListener {
    fun onClick(medication: MedicationUiModel)
}

class MedicationAdapter(private val onInteractionListener: onInteractionListener) :
    PagingDataAdapter<MedicationUiModel, RecyclerView.ViewHolder>(MedicationDifCallBack) {

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is MedicationUiModel -> R.layout.card_medication
            else -> error("error")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.card_medication -> {
                val binding =
                    CardMedicationBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                MedicationViewHolder(binding, onInteractionListener)
            }

            else -> error("error")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is MedicationUiModel -> (holder as? MedicationViewHolder)?.bind(item)
            else -> error("error")
        }
    }
}

class MedicationViewHolder(
    private val binding: CardMedicationBinding,
    private val onInteractionListener: onInteractionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(medication: MedicationUiModel) {
        binding.apply {
            medicationName.text = medication.name
            medicationInfo.text = medication.info
        }
    }
}

object MedicationDifCallBack : DiffUtil.ItemCallback<MedicationUiModel>() {
    override fun areItemsTheSame(oldItem: MedicationUiModel, newItem: MedicationUiModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MedicationUiModel, newItem: MedicationUiModel) =
        oldItem == newItem

}