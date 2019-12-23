package com.sj.students.model

import android.util.Log
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import java.util.*

class MoshiAdapter {
    companion object {
        val NAMES = JsonReader.Options.of("name", "year_of_birth", "student")
    }
    @FromJson
    fun parse(reader: JsonReader): List<StudentsModel> {
        val result = mutableListOf<StudentsModel>()

        reader.beginArray()
        while (reader.hasNext()) {
            var name = ""
            var yearOfBirth = 0
            var student = false
            var maturity = false

            reader.beginObject()
            while (reader.hasNext()) {
                when (reader.selectName(NAMES)) {
                    0 -> name = reader.nextString()
                    1 -> yearOfBirth = reader.nextInt()
                    2 -> student = reader.nextBoolean()
                    else -> {
                        reader.skipName()
                        reader.skipValue()
                    }
                }
            }
            reader.endObject()
            val year = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth
            if(year >= 18) maturity = true
            val studentElement = StudentsModel(name, yearOfBirth, student, maturity)
            Log.w("TestCheck", studentElement.toString())
            result.add(studentElement)
        }
        reader.endArray()

        return result.distinct()
    }
}