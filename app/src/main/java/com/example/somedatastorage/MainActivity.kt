package com.example.somedatastorage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somedatastorage.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var context: Context
        val scope by lazy { CoroutineScope(SupervisorJob()) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        context = applicationContext
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            viewModel = MainVM()
            setContentView(root)
        }
        /*recyclerView.layoutManager= LinearLayoutManager(applicationContext)
        buttonAddNote.setOnClickListener {
            noteManager addNote Note().apply {
                with(editTextAddNoteName) {
                    name =
                        if (text.isEmpty()) hint.toString()
                        else text.toString()
                    text.clear()
                }
                body = editTextAddNoteBody.text.toString()
                editTextAddNoteBody.text.clear()
                date = try {
                    df.parse(editTextAddNoteDate.text.toString())
                } catch (_: ParseException) {
                    Date()
                }
                Log.d("MY_TAG", toString())
            }
            recyclerView.adapter = RvAdapterNote(noteManager)*/
    }
}