package cn.winxo.toolbox.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import cn.winxo.toolbox.data.entity.local.Task;
import io.reactivex.Flowable;
import java.util.List;

@Dao public interface TaskDao extends BaseDao<Task> {
  @Query("SELECT * from task where id=:id") List<Task> find(long id);

  @Query("SELECT * from task ORDER BY modifiedTime DESC") Flowable<List<Task>> getAllTask();
}