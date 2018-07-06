package cn.winxo.toolbox.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao abstract class BaseDao<T> {

  @Insert(onConflict = OnConflictStrategy.REPLACE) public abstract long replace(T t);

  @Insert(onConflict = OnConflictStrategy.REPLACE) public abstract void insert(List<T> t);

  @Insert public abstract long insert(T t);

  @Update public abstract void update(T t);

  @Update public abstract void update(List<T> t);

  @Delete public abstract void deleteBatch(List<T> list);

  @Delete public abstract void delete(T t);
}