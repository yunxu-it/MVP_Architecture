package cn.winxo.toolbox.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cn.winxo.toolbox.data.entity.local.Task
import cn.winxo.toolbox.util.Converters

@Database(entities = [Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private const val name = "winxo.db"
        private val lock = Any()

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, name)
                    .build().also { INSTANCE = it }
        }
    }
}
