package cn.winxo.toolbox.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init(savedInstanceState);
    setContentView(setLayoutResourceID());
    initLate(savedInstanceState);
    initPresenter();
    initView();
    initData();
  }

  protected void init(Bundle savedInstanceState) {
  }

  protected abstract int setLayoutResourceID();

  protected void initLate(Bundle savedInstanceState) {
  }

  protected void initPresenter() {
  }

  protected abstract void initView();

  protected void initData() {
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }
}
