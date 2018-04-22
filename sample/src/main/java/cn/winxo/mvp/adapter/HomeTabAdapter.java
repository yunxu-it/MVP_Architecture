package cn.winxo.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import cn.winxo.mvp.module.view.HomeFragment;
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
    for (int i = 0; i < 2; i++) {
      mFragments.add(HomeFragment.newInstance(i));
    }
  }

  @Override public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override public int getCount() {
    return mFragments.size();
  }
}
