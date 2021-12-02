package com.example.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noteAdapter = NoteCreate(mutableListOf())

        rvNotes.adapter = noteAdapter
        rvNotes.layoutManager = LinearLayoutManager(this)

        btnAddNote.setOnClickListener {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            val formatted = current.format(formatter)

            val noteName = etNoteName.text.toString()
            val noteComment = etComment.text.toString()
            val noteDate = formatted.toString()

            if (noteName.isNotEmpty() || noteComment.isNotEmpty()) {
                val note = Note(noteName, noteComment, noteDate)
                noteAdapter.addNote(note)
                etNoteName.text.clear()
                etComment.text.clear()
            }
        }
        supportActionBar?.title = "My Notes"

        swTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.toolbar_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return true
//    }
}