package com.harbourspace.pet_adoption.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.harbourspace.pet_adoption.model.DogModel
import com.harbourspace.pet_adoption.repository.DogDAO
import java.util.concurrent.Executors

@Database(entities = [DogModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dogDao(): DogDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(context, AppDatabase::class.java, "db").build()
                INSTANCE = db
                db
            }
        }
        val databaseWriteExecutor = Executors.newFixedThreadPool(2)
    }
}