package cn.winxo.mvp.contract;

import java.util.List;

import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.base.BaseView;
import cn.winxo.mvp.model.entity.Example;

/**
 * @author dell
 * @date 2016/8/10 16:15
 */
public interface ExampleContract {

    interface View extends BaseView {
        void showExample(List<Example> exampleList);

        void showError(String s);
    }

    interface Presenter extends BasePresenter {
        void getExample();
    }
}
