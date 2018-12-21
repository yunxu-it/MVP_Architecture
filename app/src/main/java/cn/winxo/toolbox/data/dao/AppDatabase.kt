package cn.winxo.toolbox.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cn.winxo.toolbox.data.entity.local.Task
import cn.winxo.toolbox.data.entity.local.Type
import cn.winxo.toolbox.util.Converters

@Database(entities = [Task::class, Type::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun typeDao(): TypeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private const val name = "winxo.db"

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, name)
                    .build().also { INSTANCE = it }
        }
    }
}
