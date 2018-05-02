package cn.winxo.toolbox.module.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.base.BaseMvpFragment;
import cn.winxo.toolbox.data.Injection;
import cn.winxo.toolbox.data.entity.local.UserEntity;
import cn.winxo.toolbox.module.conract.HomeContract;
import cn.winxo.toolbox.module.presenter.HomePresenter;

public class HomeFragment extends BaseMvpFragment<HomeContract.Presenter> implements HomeContract.View {

  private android.widget.TextView mText;

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override protected void init(Bundle savedInstanceState) {
    super.init(savedInstanceState);
  }

  @Override protected void initView() {

    mText = (TextView) mContentView.findViewById(R.id.text);
    mText.setText("home");
    mText.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("name");
        userEntity.setPassword("password");
        mPresenter.insertUser(userEntity);
        Log.e("HomeFragment", "onClick: 添加成功");
      }
    });
  }

  @Override protected void initData() {
    mPresenter.loadUser();
  }

  @Override protected HomeContract.Presenter onLoadPresenter() {
    return new HomePresenter(getActivity(), Injection.provideUserRepository(getActivity()));
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.fragment_index;
  }
}
  
