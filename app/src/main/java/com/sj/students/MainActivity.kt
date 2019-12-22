package com.sj.students

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sj.students.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        showStudents()
    }

    private fun showStudents() {
        list.text = "NAME\tSTUDENT?\tADULT?\tYEAR\n"
        var isAdult: String?

        viewModel.getStudents().observe(this, Observer {
            for (el in it.distinct()) {
                val year = Calendar.getInstance().get(Calendar.YEAR) - el.yearOfBirth
                if (year >= 18) isAdult = "yes" else isAdult = "no"

                list.append("${el.name}\t${el.student}\t${isAdult}\t${el.yearOfBirth}\n")
            }
        })
    }
}
