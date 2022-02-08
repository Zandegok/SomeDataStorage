package com.example.somedatastorage

import android.database.Cursor
import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * from Note")
    suspend fun getAll():List<Note>

    @Query("SELECT * from Note WHERE id = :id")
    suspend fun getById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note):Long

    @Update
    suspend fun update(note: Note)

    @Query("DELETE FROM Note WHERE id = :id")
    suspend fun deleteById(id: Int)
}