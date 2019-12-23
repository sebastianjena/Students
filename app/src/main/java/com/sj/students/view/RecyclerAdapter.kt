package com.sj.students.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sj.students.R
import com.sj.students.ext.inflate
import com.sj.students.model.StudentsModel
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private val students: List<StudentsModel>) : RecyclerView.Adapter<RecyclerAdapter.StudentsHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return StudentsHolder(inflatedView)
    }

    override fun getItemCount() = students.size

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.bindStudent(students[position])
    }

    class StudentsHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var student: StudentsModel? = null

        fun bindStudent(student: StudentsModel) {
            this.student = student

            view.studentName.text = student.name
            view.studentYear.text = student.yearOfBirth.toString()
            view.studentStatus.text = student.student.toString()
            view.studentMaturity.text = student.maturity.toString()

        }
    }
}