package cn.winxo.toolbox.data.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.util.Converters;

@Database(entities = { Task.class }, version = 1) @TypeConverters(Converters.class) public abstract class AppDatabase extends RoomDatabase {

  private static volatile AppDatabase instance;
  private static final String name = "winxo.db";

  public static AppDatabase getInstance(Context context) {
    if (instance == null) {
      synchronized (AppDatabase.class) {
        if (instance == null) {
          instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, name).build();
        }
      }
    }
    return instance;
  }

  public abstract TaskDao taskDao();
}