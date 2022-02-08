package com.example.somedatastorage
import androidx.room.*
import androidx.room.Room.databaseBuilder

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        @Volatile
        var instance:AppDatabase?=null
        get(){
            var instance=field
            return instance?: synchronized(this) { databaseBuilder(
                        MainActivity.context,
                        AppDatabase::class.java,
                        "app_database"
                    ).fallbackToDestructiveMigration().build()
                }.also { field=it }
        }



    }

}