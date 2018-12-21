package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import android.util.Log;
import cn.winxo.toolbox.util.base.BasePresenter;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.data.source.TaskRepository;
import cn.winxo.toolbox.module.contract.HomeContract;
import java.util.Date;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

  private Context mContext;
  private TaskRepository mTaskRepository;

  public HomePresenter(Context context, TaskRepository taskRepository) {
    mContext = context;
    mTaskRepository = taskRepository;
  }

  @Override public void loadTask() {
    Log.e("HomePresenter", "loadTask:+ 获取新数据 ");
    addSubscription(mTaskRepository.listAllTask().subscribe(tasks -> mView.showData(tasks), throwable -> throwable.printStackTrace()));
  }

  @Override public void addTask(String content) {
    Date date = new Date();
    addSubscription(mTaskRepository.addTask(content, date).subscribe(task -> {
      mView.addTask(task);
    }, throwable -> throwable.printStackTrace()));
  }

  @Override public void removeTask(int position, Task task) {
    addSubscription(mTaskRepository.removeTask(task.getId()).subscribe(aBoolean -> mView.removeTask(position), throwable -> throwable.printStackTrace()));
  }
}

