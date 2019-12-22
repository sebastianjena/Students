package com.sj.students.net

import com.sj.students.model.StudentsModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface StudentsServiceInterface {
    suspend fun getStudentsData(): List<StudentsModel>
}

class StudentsService (
    private val url: String = "https://students.free.beeceptor.com/",
    private val jsonId: String = "123"
) : StudentsServiceInterface {

    override suspend fun getStudentsData(): List<StudentsModel> {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(url)
            .build()
        val studentsApi = retrofit.create(StudentsApi::class.java)

        return studentsApi.getStudentsList(jsonId)
    }
}