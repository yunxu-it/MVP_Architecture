package cn.winxo.mvp.module.example;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.mvp.interfaces.IModel;
import cn.winxo.mvp.mvp.interfaces.IPresenter;
import cn.winxo.mvp.mvp.interfaces.IView;
import cn.winxo.mvp.model.entity.Example;

/**
 * @author dell
 * @date 2016/8/10 16:15
 */
public interface ExampleContract {

    interface View extends IView {
        void showExample(List<Example> exampleList);
    }

    interface Model extends IModel {
        void loadExampleList(Context context, IListener<List<Example>> listener);

        void loadExampleSingle(Context context, IListener<Example> listener);
    }

    interface Presenter extends IPresenter<View> {
        void getExample();
    }
}
