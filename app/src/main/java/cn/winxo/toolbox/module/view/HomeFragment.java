package cn.winxo.toolbox.module.view;

import android.os.Bundle;
import android.widget.TextView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.base.BaseMvpFragment;
import cn.winxo.toolbox.module.conract.HomeContract;
import cn.winxo.toolbox.module.presenter.HomePresenter;

public class HomeFragment extends BaseMvpFragment<HomeContract.Presenter>
    implements HomeContract.View {

  public static final String ARGS_PAGE = "args_page";
  private int mTabId;
  private TextView mText;

  public static HomeFragment newInstance(int tabId) {
    Bundle args = new Bundle();
    args.putInt(ARGS_PAGE, tabId);
    HomeFragment fragment = new HomeFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected void init(Bundle savedInstanceState) {
    super.init(savedInstanceState);
    if (getArguments() != null) {
      mTabId = getArguments().getInt(ARGS_PAGE);
    }
  }

  @Override protected void initView() {
    mText = mContentView.findViewById(R.id.text);
    mText.setText(mTabId + "");
  }

  @Override protected void initData() {

  }

  @Override protected HomeContract.Presenter onLoadPresenter() {
    return new HomePresenter(getActivity());
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.fragment_index;
  }
}
  
