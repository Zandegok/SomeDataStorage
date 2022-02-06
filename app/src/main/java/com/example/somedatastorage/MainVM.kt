package com.example.somedatastorage

import android.util.Log
import androidx.databinding.ObservableField
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class MainVM {
    private val noteManager= NoteManager()
    private val df = SimpleDateFormat(MainActivity.context.getString(R.string.dateFormat))
    val fieldTitle = ObservableField("")
    val fieldBody = ObservableField("")
    val fieldDate = ObservableField(df.format(Date()))
    val adapter = ObservableField(RvAdapterNote(noteManager))

    var title get() =fieldTitle.get().toString(); set(value) =fieldTitle.set(value)
    var body get() = fieldBody.get().toString() ;set(value)=fieldBody.set(value)
    var date
        get() = try{df.parse(fieldDate.get().toString())?:Date()}catch (_:Exception){Date()}
        set(value) =fieldDate.set(df.format(value))

    fun addNote() {
        noteManager addNote Note().apply {
            title = this@MainVM.title.ifEmpty { "Заметка" }
            this@MainVM.title=""
            body = this@MainVM.body
            this@MainVM.body=""
            date = this@MainVM.date
        }
        adapter.set( RvAdapterNote(noteManager))
    }

}

