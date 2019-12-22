package com.sj.students.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sj.students.model.StudentsModel
import com.sj.students.net.StudentsService
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val service = StudentsService()
    private val studentsList = liveData(Dispatchers.IO) {
        val receivedList = service.getStudentsData()
        emit(receivedList)
    }

    fun getStudents() : LiveData<List<StudentsModel>> = studentsList
}