package cn.winxo.mvp.model.remote;

import android.content.Context;

import java.util.ArrayList;

import cn.winxo.mvp.model.IExampleData;
import cn.winxo.mvp.model.entity.Example;

/**
 * @author dell
 * @date 2016/8/10 16:32
 */
public class ExampleRemoteDataImpl implements IExampleData {


    @Override
    public void loadExampleList(Context context, IExampleListCallback callback) {
        callback.onSuccess(new ArrayList<Example>());
    }

    @Override
    public void loadExampleSingle(Context context, IExampleSingleCallback callback) {
        callback.onError();
    }
}
