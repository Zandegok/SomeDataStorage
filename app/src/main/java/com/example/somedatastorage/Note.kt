package com.example.somedatastorage

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

@Entity
@TypeConverters(DateConverter::class)
data class Note(
    var title: String = "",
    var body: String = "",
    var date: Date = Date()
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}