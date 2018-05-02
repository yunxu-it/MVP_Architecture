package cn.winxo.toolbox.module.view;

import android.os.Bundle;
import android.widget.TextView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.base.BaseMvpFragment;
import cn.winxo.toolbox.data.Injection;
import cn.winxo.toolbox.module.conract.HomeContract;
import cn.winxo.toolbox.module.presenter.HomePresenter;

public class MineFragment extends BaseMvpFragment<HomeContract.Presenter> implements HomeContract.View {

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

  @Override protected HomeContract.Presenter onLoadPresenter() {
    return new HomePresenter(getActivity(), Injection.provideUserRepository(getActivity()));
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.fragment_mine;
  }
}
  
