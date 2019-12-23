package com.sj.students.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sj.students.R
import com.sj.students.ext.subscribe
import com.sj.students.model.StudentsModel
import com.sj.students.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java)}
    private var linearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getStudents().subscribe(this, ::showStudents)

        recyclerView.layoutManager = linearLayoutManager
    }

    private fun showStudents(students: List<StudentsModel>) {
        recyclerView.adapter = RecyclerAdapter(students)
    }
}
