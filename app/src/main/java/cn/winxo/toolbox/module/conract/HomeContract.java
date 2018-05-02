package cn.winxo.toolbox.module.conract;

import cn.winxo.toolbox.base.ibase.IPresenter;
import cn.winxo.toolbox.base.ibase.IView;
import cn.winxo.toolbox.data.entity.local.UserEntity;

public interface HomeContract {

  interface View extends IView {

  }

  interface Presenter extends IPresenter<View> {

    void loadUser();

    void insertUser(UserEntity userEntity);
  }
}