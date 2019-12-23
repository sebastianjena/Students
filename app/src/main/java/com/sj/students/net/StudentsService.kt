package com.sj.students.net

import com.sj.students.model.MoshiAdapter
import com.sj.students.model.StudentsModel
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface StudentsServiceInterface {
    suspend fun getStudentsData(): List<StudentsModel>
}

class StudentsService (
    private val url: String = "http://www.mocky.io/",
    private val jsonId: String = "5db2e026350000a91af5527c"
) : StudentsServiceInterface {

    override suspend fun getStudentsData(): List<StudentsModel> {
        val moshi = Moshi.Builder()
            .add(MoshiAdapter())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(url)
            .build()
        val studentsApi = retrofit.create(StudentsApi::class.java)

        return studentsApi.getStudentsList(jsonId)
    }
}