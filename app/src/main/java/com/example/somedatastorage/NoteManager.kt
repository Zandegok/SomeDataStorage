package com.example.somedatastorage

class NoteManager(private var notes:ArrayList<Note>) {
constructor():this(arrayListOf())
infix fun addNote(note:Note)=notes.add(note)
infix fun deleteNote(index:Int)=notes.removeAt(index)
infix fun getNote(index:Int):Note = notes.get(index)
val count:Int get()= notes.size
    override fun toString():String="[${notes.joinToString { it.toString() }}]"
}