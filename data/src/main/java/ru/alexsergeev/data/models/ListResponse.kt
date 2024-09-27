package ru.alexsergeev.data.models

data class ListResponse(
    val id: Int,
    val image: String,
    val categories: Categories,
    val name: String,
    val description: String,
    val documentation: String,
    val fields: List<Field>
)

data class Categories(
    val id: Int = 0,
    val icon: String,
    val image: String,
    val name: String
)

data class Field(
    val type: String,
    val name: String,
    val value: String,
    val image: String,
    val flags: Flags,
    val show: Int,
    val group: Int
)

data class Flags(
    val html: Int = 0,
    val no_value: Int = 0,
    val no_name: Int = 0,
    val no_image: Int = 0,
    val no_wrap: Int = 0,
    val no_wrap_name: Int = 0
)