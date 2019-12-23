package com.sj.students.model

import com.squareup.moshi.Json

data class StudentsModel(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "year_of_birth") val yearOfBirth: Int,
    @field:Json(name = "student") val student: Boolean,
    val maturity: Boolean
)