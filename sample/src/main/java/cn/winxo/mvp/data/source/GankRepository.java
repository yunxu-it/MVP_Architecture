package cn.winxo.mvp.data.source;

import cn.winxo.mvp.data.entity.remote.Gank;
import cn.winxo.mvp.data.source.interfaces.GankDataSource;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class GankRepository implements GankDataSource {

  private static GankRepository INSTANCE = null;
  private GankDataSource mRemoteDataSource;

  private GankRepository(@NonNull GankDataSource remoteDataSource) {
    mRemoteDataSource = remoteDataSource;
  }

  public static GankRepository getInstance(GankDataSource remoteDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new GankRepository(remoteDataSource);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override public Observable<List<Gank>> getGankData(int page) {
    return mRemoteDataSource.getGankData(page);
  }
}
