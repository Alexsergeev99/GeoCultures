package ru.alexsergeev.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.presentation.models.MedicationUiModel

internal class MedicationViewModel : ViewModel() {

    private val _medications = MutableStateFlow<List<MedicationUiModel>>(emptyList())
    val medications: StateFlow<List<MedicationUiModel>> get() = _medications

    private val isLoadingMutable = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = isLoadingMutable

    init {
        viewModelScope.launch {
            getMedicationList()
        }
    }

    private fun getMedicationList() {
        _medications.update {
            listOf(
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
                MedicationUiModel(
                    id = 1,
                    image = "https://s3-alpha-sig.figma.com/img/166a/c875/6e770de1bdefd40578bfeef161871237?Expires=1728259200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ITcZQyVnXyrHr0KmP-rYeYx8tkGYQiZjhbpqb0~yM8ZMYsPEhG0QSXe2yECaP8xCaqiZ-ySAgQFWl5KZUjet4W4wNs-Mi-7cPk1mPdc3fI3CpUNoVfX5nHNeCvNQ9jw9t-Z53L2OsG1jtkK9mx~Mo6HLRxjURSeIOl67363fnea13TsBdMy9eU1WLsNTPThBQhgvrPW9WBSJsAYH-ZRjYgF8NdbQR8ZalbVBp40VIvCh7Py9asuuIQKa2dv1x0Q8MxggTT9ZN3KpY3qxfO9g6BMMiDR6Aam2GA5JP-9xPAhCRA8mzCwHE8NKpYtZmKrChG~ILnNcTKSMhcuYP8~Vow__",
                    "Вредители зерновых культур",
                    "Состав вредителей зерновых культур обширен и разнообразен. Более 130 видов ..."
                ),
            )
        }
    }
}