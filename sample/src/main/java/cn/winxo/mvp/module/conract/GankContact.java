package cn.winxo.mvp.module.conract;

import cn.winxo.mvp.base.ibase.IPresenter;
import cn.winxo.mvp.base.ibase.IView;
import cn.winxo.mvp.data.entity.remote.Gank;
import java.util.List;

/**
 * @author dell
 * @date 2016/8/10 16:15
 */
public interface GankContact {

  interface View extends IView {
    void showExample(List<Gank> exampleList);
  }

  interface Presenter extends IPresenter<View> {
    void getGanks(int page);
  }
}
