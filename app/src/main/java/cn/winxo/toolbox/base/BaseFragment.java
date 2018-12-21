package cn.winxo.toolbox.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Author: Winxo
 * Date: 2016/8/26
 * Desc:
 */
public abstract class BaseFragment extends Fragment {

  protected View mContentView;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (mContentView == null) {
      mContentView = inflater.inflate(setLayoutResourceID(), container, false);
    }
    initPresenter();
    init(savedInstanceState);
    initView();
    initData();
    return mContentView;
  }

  protected abstract int setLayoutResourceID();

  protected void initPresenter() {

  }

  protected void init(Bundle savedInstanceState) {
  }

  protected abstract void initView();

  protected abstract void initData();

  @Override public void onDestroy() {
    super.onDestroy();
  }
}
