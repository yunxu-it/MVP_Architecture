package cn.winxo.toolbox.data.entity.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = { UserEntity.class }, version = 1) public abstract class AppDatabase
    extends RoomDatabase {

  private static AppDatabase sInstance;

  public static AppDatabase getInstance(Context context) {
    if (sInstance == null) {
      sInstance =
          Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user.db")
              .build();
    }
    return sInstance;
  }

  public static void onDestroy() {
    sInstance = null;
  }

  public abstract UserDao userDao();
}