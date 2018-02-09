package cn.winxo.mvp.di;

import android.content.Context;
import cn.winxo.mvp.api.Apis;
import cn.winxo.mvp.api.retrofit.GankService;
import cn.winxo.mvp.module.main.MainPresenter;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
@Module public class AppModule {

  private final Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Provides public Context provideContext() {
    return context;
  }

  @Provides public Retrofit provideRetrofit() {
    return new Retrofit.Builder().baseUrl(Apis.BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Provides public GankService provideGankService(Retrofit retrofit) {
    return retrofit.create(GankService.class);
  }

  @Provides public MainPresenter provideMainPresenter(Retrofit retrofit) {
    return new MainPresenter(context);
  }
}
