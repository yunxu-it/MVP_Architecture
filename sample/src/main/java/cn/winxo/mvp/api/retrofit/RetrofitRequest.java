package cn.winxo.mvp.api.retrofit;

import cn.winxo.mvp.api.Apis;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
  private static RetrofitRequest instance;

  private RetrofitRequest() {
  }

  public static RetrofitRequest getInstance() {
    if (instance == null) {
      synchronized (RetrofitRequest.class) {
        if (instance == null) {
          instance = new RetrofitRequest();
        }
      }
    }
    return instance;
  }

  private Retrofit getService() {
    return new Retrofit.Builder().baseUrl(Apis.BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  public GankService getGank() {
    return getService().create(GankService.class);
  }
}
