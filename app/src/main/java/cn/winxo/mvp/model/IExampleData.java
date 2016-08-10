package cn.winxo.mvp.model;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.model.entity.Example;

/**
 * @author dell
 * @date 2016/8/10 16:23
 */
public interface IExampleData {

    interface IExampleListCallback {
        void onSuccess(List<Example> examples);

        void onError();
    }

    interface IExampleSingleCallback {
        void onSuccess(Example example);

        void onError();
    }

    void loadExampleList(Context context, IExampleListCallback callback);

    void loadExampleSingle(Context context, IExampleSingleCallback callback);


}
