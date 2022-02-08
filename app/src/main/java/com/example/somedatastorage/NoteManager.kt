package com.example.somedatastorage

import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NoteManager() {
    private val notes by lazy {
        val deferred = MainActivity.scope.async { noteDao.getAll() }
        while (deferred.isActive);
        if (deferred.isCancelled) return@lazy arrayListOf<Note>()
        arrayListOf(*deferred.getCompleted().toTypedArray())
    }
    val scope by lazy { MainActivity.scope }
    val noteDao = AppDatabase.instance!!.noteDao
    infix fun addNote(note: Note): Boolean {
        val deferred = MainActivity.scope.async { noteDao.insert(note) }
        while (deferred.isActive);
        if (!deferred.isCancelled) note.id = deferred.getCompleted().toInt()
        return notes.add(note)
    }

    infix fun deleteNote(index: Int): Note {
        val id = notes[index].id
        MainActivity.scope.launch {
            noteDao.deleteById(id)
        }
        return notes.removeAt(index)
    }

    infix fun getNote(index: Int): Note = notes.get(index)

    fun updateNote(index: Int, func: (Note)->Unit) {
        func( notes[index])
        MainActivity.scope.launch {
            noteDao.update(notes[index])
        }
    }

    val count: Int get() = notes.size
    override fun toString(): String = "[${notes.joinToString { it.toString() }}]"
}