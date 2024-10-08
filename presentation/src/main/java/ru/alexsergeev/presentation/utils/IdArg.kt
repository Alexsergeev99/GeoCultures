package ru.alexsergeev.presentation.utils

import android.os.Bundle
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object IntArg: ReadWriteProperty<Bundle, Int?> {
    override fun getValue(thisRef: Bundle, property: KProperty<*>): Int? = thisRef.getInt(property.name)


    override fun setValue(thisRef: Bundle, property: KProperty<*>, value: Int?) {
        if (value != null) {
            thisRef.putInt(property.name, value)
        }
    }
}