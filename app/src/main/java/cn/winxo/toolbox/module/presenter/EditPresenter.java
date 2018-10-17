package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import cn.winxo.toolbox.base.BasePresenter;
import cn.winxo.toolbox.data.source.TaskRepository;
import cn.winxo.toolbox.module.contract.EditContract;
import java.util.Date;

/**
 * @author lxlong
 * @date 10/17/2018
 * @desc
 */
public class EditPresenter extends BasePresenter<EditContract.View> implements EditContract.Presenter {

  private Context mContext;
  private TaskRepository mTaskRepository;

  public EditPresenter(Context context, TaskRepository taskRepository) {
    mContext = context;
    mTaskRepository = taskRepository;
  }


  @Override public void addTask(String content) {
    Date date = new Date();
    addSubscription(mTaskRepository.addTask(content, date).subscribe(task -> {
      mView.addSuccess(task);
    }, throwable -> throwable.printStackTrace()));
  }
}