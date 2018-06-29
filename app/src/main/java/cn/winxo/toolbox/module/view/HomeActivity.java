package cn.winxo.toolbox.module.view;

import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import cn.winxo.toolbox.AdvancedRecyclerView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.adapter.TaskViewBinder;
import cn.winxo.toolbox.base.BaseMvpActivity;
import cn.winxo.toolbox.data.Injection;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.interfaces.OnRecyclerTouchListener;
import cn.winxo.toolbox.module.conract.HomeContract;
import cn.winxo.toolbox.module.presenter.HomePresenter;
import com.afollestad.materialdialogs.MaterialDialog;
import java.util.List;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class HomeActivity extends BaseMvpActivity<HomeContract.Presenter> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {
  private MultiTypeAdapter mAdapter;
  private SwipeRefreshLayout mSwipeRefresh;

  @Override protected HomeContract.Presenter onLoadPresenter() {
    return new HomePresenter(this, Injection.provideTaskRepository(this));
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_home;
  }

  @Override public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && Build.VERSION.SDK_INT >= 19) {
      View decorView = getWindow().getDecorView();
      decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
  }

  @Override protected void initView() {
    //View decorView = getWindow().getDecorView();
    //int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
    //decorView.setSystemUiVisibility(option);
    //getWindow().setStatusBarColor(Color.TRANSPARENT);
    //ActionBar actionBar = getSupportActionBar();
    //if (actionBar != null) {
    //  actionBar.hide();
    //}

    mSwipeRefresh = findViewById(R.id.swipe_refresh);
    mSwipeRefresh.setOnRefreshListener(this);
    AdvancedRecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setOnRecyclerTouchListener(new OnRecyclerTouchListener() {
      @Override public void onRightSlide() {
        Log.e("HomeActivity", "onRightSlide: +右划");
      }
    });
    mAdapter = new MultiTypeAdapter();
    //mAdapter.setHasStableIds(true);
    mAdapter.register(Task.class, new TaskViewBinder());
    recyclerView.setAdapter(mAdapter);
  }

  @Override protected void initData() {
    mPresenter.loadTask();
  }

  @Override public void showData(List<Task> tasks) {
    mAdapter.setItems(tasks);
    mAdapter.notifyDataSetChanged();
  }

  @Override public void addTask(Task task) {
    ((List<Task>) mAdapter.getItems()).add(0, task);
    mAdapter.notifyItemInserted(0);
  }

  @Override public void onRefresh() {
    mSwipeRefresh.setRefreshing(false);
    new MaterialDialog.Builder(this).inputType(InputType.TYPE_CLASS_TEXT).input("我想...", "", (dialog, input) -> {
      mPresenter.addTask(input.toString());
    }).show();
  }
}
