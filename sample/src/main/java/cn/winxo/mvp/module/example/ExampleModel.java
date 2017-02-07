package cn.winxo.mvp.module.example;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.winxo.mvp.model.entity.Example;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class ExampleModel implements ExampleContract.Model {
    @Override
    public void loadExampleList(Context context, IListener<List<Example>> listener) {
        listener.onSuccess(new ArrayList<Example>());
    }

    @Override
    public void loadExampleSingle(Context context, IListener<Example> listener) {
        listener.onError("s");
    }
}
