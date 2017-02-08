package cn.winxo.mvp.api.retrofit;

import cn.winxo.mvp.api.Apis;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class WinxoRetrofit {
    private static WinxoRetrofit instance;

    private WinxoRetrofit() {
    }

    public static WinxoRetrofit getInstance() {
        if (instance == null) {
            synchronized (WinxoRetrofit.class) {
                if (instance == null) {
                    instance = new WinxoRetrofit();
                }
            }
        }
        return instance;
    }

    private Retrofit getService() {
        return new Retrofit.Builder()
                .baseUrl(Apis.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public GankService getGank() {
        return getService().create(GankService.class);
    }



}
