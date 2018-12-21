package cn.winxo.toolbox.data.source;

import androidx.annotation.NonNull;
import cn.winxo.toolbox.data.dao.TaskDao;
import cn.winxo.toolbox.data.dao.TypeDao;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.data.entity.local.Type;
import cn.winxo.toolbox.data.source.interfaces.TaskDataSource;
import cn.winxo.toolbox.util.RxUtils;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class TaskRepository implements TaskDataSource {
  private static TaskRepository INSTANCE = null;
  private TaskDao mTaskDao;
  private TypeDao mTypeDao;

  private TaskRepository(@NonNull TaskDao taskDao, TypeDao typeDao) {
    mTaskDao = taskDao;
    mTypeDao = typeDao;
  }

  public static TaskRepository getInstance(TaskDao taskDao, TypeDao typeDao) {
    if (INSTANCE == null) {
      INSTANCE = new TaskRepository(taskDao, typeDao);
    }
    return INSTANCE;
  }

  @Override public Flowable<List<Task>> listAllTask() {
    return mTaskDao.getAllTask().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Flowable<Task> addTask(String content, Date date) {
    return Flowable.create((FlowableOnSubscribe<Task>) e -> {
      Task task = new Task(content, date, date);
      long id = mTaskDao.insertTask(task);
      List<Task> tasks = mTaskDao.find(id);
      if (tasks.isEmpty()) {
        e.onError(new Throwable("数据创建失败"));
      } else {
        e.onNext(tasks.get(0));
      }
    }, BackpressureStrategy.DROP).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<Boolean> removeTask(long id) {
    return Observable.create((ObservableOnSubscribe<Boolean>) e -> {
      mTaskDao.deleteTaskByID(id);
      e.onNext(true);
    }).compose(RxUtils.rxSchedulerHelper());
  }

  @NotNull @Override public Flowable<List<Type>> listAllType() {
    return mTypeDao.getLoadAllType().subscribeOn(Schedulers.io());
  }
}
