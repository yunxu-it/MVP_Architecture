package cn.winxo.toolbox.module.view;

import android.os.Bundle;
import android.widget.TextView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.base.BaseFragment;

public class MineFragment extends BaseFragment {

  private TextView mText;

  public static MineFragment newInstance() {
    return new MineFragment();
  }

  @Override protected void init(Bundle savedInstanceState) {
    super.init(savedInstanceState);
  }

  @Override protected void initView() {
    mText = (TextView) mContentView.findViewById(R.id.text);
    mText.setText("mine");
  }

  @Override protected void initData() {

  }

  @Override protected int setLayoutResourceID() {
    return R.layout.fragment_mine;
  }
}
  
