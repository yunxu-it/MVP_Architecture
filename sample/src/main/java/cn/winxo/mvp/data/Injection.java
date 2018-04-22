package cn.winxo.mvp.data;

import android.content.Context;
import android.support.v4.util.Preconditions;
import cn.winxo.mvp.data.source.GankRepository;
import cn.winxo.mvp.data.source.remote.GankRemoteDataSource;
import io.reactivex.annotations.NonNull;

public class Injection {

  public static GankRepository provideGankRepository(@NonNull Context context) {
    Preconditions.checkNotNull(context);
    return GankRepository.getInstance(GankRemoteDataSource.getInstance());
  }
}