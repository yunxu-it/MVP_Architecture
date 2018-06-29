package cn.winxo.toolbox.data.source.interfaces;

import cn.winxo.toolbox.data.entity.local.Task;
import io.reactivex.Flowable;
import java.util.Date;
import java.util.List;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public interface TaskDataSource {
  Flowable<List<Task>> listAllTask();

  Flowable<Task> addTask(String content, Date date);
}
