package com.sj.students.net

import com.sj.students.model.StudentsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentsApi {

    @GET("v2/{id}")
    suspend fun getStudentsList(@Path(value = "id") jsonId: String): List<StudentsModel>
}