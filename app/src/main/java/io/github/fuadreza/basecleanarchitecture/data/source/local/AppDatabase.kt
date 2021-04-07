package io.github.fuadreza.basecleanarchitecture.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.fuadreza.basecleanarchitecture.data.response.NowPlayingDto
import io.github.fuadreza.basecleanarchitecture.data.source.local.dao.NowPlayingDao

@Database(entities = [NowPlayingDto.Result::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun nowPlayingDao(): NowPlayingDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "now_playing")
                .fallbackToDestructiveMigration()
                .build()
    }

}