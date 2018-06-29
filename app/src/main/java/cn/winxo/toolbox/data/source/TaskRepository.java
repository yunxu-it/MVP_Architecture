package cn.winxo.toolbox.data.source;

import android.support.annotation.NonNull;
import cn.winxo.toolbox.data.dao.TaskDao;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.data.source.interfaces.TaskDataSource;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class TaskRepository implements TaskDataSource {
  private static TaskRepository INSTANCE = null;
  private TaskDao mTaskDao;

  private TaskRepository(@NonNull TaskDao taskDao) {
    mTaskDao = taskDao;
  }

  public static TaskRepository getInstance(TaskDao taskDao) {
    if (INSTANCE == null) {
      INSTANCE = new TaskRepository(taskDao);
    }
    return INSTANCE;
  }

  @Override public Flowable<List<Task>> listAllTask() {
    return mTaskDao.getAllTask().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Flowable<Task> addTask(String content, Date date) {
    return Flowable.create((FlowableOnSubscribe<Task>) e -> {
      Task task = new Task(content, date, date);
      long id = mTaskDao.insert(task);
      List<Task> tasks = mTaskDao.find(id);
      if (tasks.isEmpty()) {
        e.onError(new Throwable("数据创建失败"));
      } else {
        e.onNext(tasks.get(0));
      }
    }, BackpressureStrategy.DROP).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
}
