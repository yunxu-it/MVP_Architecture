package cn.winxo.toolbox.module.conract;

import cn.winxo.toolbox.base.ibase.IPresenter;
import cn.winxo.toolbox.base.ibase.IView;
import cn.winxo.toolbox.data.entity.local.Task;
import java.util.List;

public interface HomeContract {

  interface View extends IView {

    void showData(List<Task> tasks);

    void addTask(Task task);
  }

  interface Presenter extends IPresenter<View> {

    void loadTask();

    void addTask(String content);
  }
}