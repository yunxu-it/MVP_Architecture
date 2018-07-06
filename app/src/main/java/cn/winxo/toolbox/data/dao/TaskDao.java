package cn.winxo.toolbox.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import cn.winxo.toolbox.data.entity.local.Task;
import io.reactivex.Flowable;
import java.util.List;

@Dao public abstract class TaskDao extends BaseDao<Task> {
  @Query("SELECT * from task where id=:id") public abstract List<Task> find(long id);

  @Query("SELECT * from task ORDER BY modifiedTime DESC") public abstract Flowable<List<Task>> getAllTask();

  @Transaction public void deleteTaskByID(long id) {
    List<Task> tasks = find(id);
    deleteBatch(tasks);
  }
}