package cn.winxo.mvp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import java.util.List;

import cn.winxo.library.base.BaseMainActivity;
import cn.winxo.library.utils.ViewUtils;
import cn.winxo.mvp.R;
import cn.winxo.mvp.ui.fragment.IndexFragment;

public class MainActivity extends BaseMainActivity {


    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;
    private Toolbar mToolbar;
    private AppBarLayout mAppbar;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        mCurrentFragment = mFragmentManager.findFragmentById(R.id.frame_content);
        if (mCurrentFragment == null) {
            mCurrentFragment = ViewUtils.createFragment(IndexFragment.class);
            mFragmentManager.beginTransaction().add(R.id.frame_content, mCurrentFragment).commit();
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (null != savedInstanceState) {
            List<Fragment> fragments = mFragmentManager.getFragments();
            for (int i = 0; i < fragments.size(); i++) {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.show(mCurrentFragment).commitAllowingStateLoss();
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        mToolbar = $(R.id.toolbar);
        mAppbar = $(R.id.appbar);
    }

    @Override
    protected void setUpData() {
        super.setUpData();
        mToolbar.setTitle("mvp架构");
    }
}
