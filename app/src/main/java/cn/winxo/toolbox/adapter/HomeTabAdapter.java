package cn.winxo.toolbox.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import cn.winxo.toolbox.module.view.HomeFragment;
import cn.winxo.toolbox.module.view.MineFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxlong
 * @date 23/04/2018
 * @desc
 */
public class HomeTabAdapter extends FragmentStatePagerAdapter {
  private List<Fragment> mFragments = new ArrayList<>();

  public HomeTabAdapter(FragmentManager fm) {
    super(fm);
    mFragments.add(HomeFragment.newInstance());
    mFragments.add(MineFragment.newInstance());
  }

  @Override public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override public int getCount() {
    return mFragments.size();
  }
}
