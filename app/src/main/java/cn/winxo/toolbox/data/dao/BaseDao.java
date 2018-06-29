package cn.winxo.toolbox.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import cn.winxo.toolbox.data.entity.local.Task;
import io.reactivex.Flowable;
import java.util.List;

@Dao interface BaseDao<T> {

  @Insert(onConflict = OnConflictStrategy.REPLACE) long replace(T t);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insert(List<T> t);

  @Insert long insert(T t);

  @Update void update(T t);

  @Update void update(List<T> t);

  @Delete void deleteBatch(List<T> list);

  @Delete void delete(T t);

}