package cn.winxo.toolbox.data.source.remote;

import cn.winxo.toolbox.api.retrofit.RetrofitRequest;
import cn.winxo.toolbox.data.entity.remote.Gank;
import cn.winxo.toolbox.data.source.interfaces.GankDataSource;
import cn.winxo.toolbox.util.RxUtils;
import io.reactivex.Observable;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class GankRemoteDataSource implements GankDataSource {

  private static GankRemoteDataSource INSTANCE;

  public static GankRemoteDataSource getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GankRemoteDataSource();
    }
    return INSTANCE;
  }

  // Prevent direct instantiation.
  private GankRemoteDataSource() {
  }

  @Override public Observable<List<Gank>> getGankData(int page) {
    return RetrofitRequest.getInstance().getGank().getMeiziData(page).map(gankBase -> {
      if (gankBase.isError()) {
        throw new RuntimeException("");
      } else {
        return gankBase.getResults();
      }
    }).compose(RxUtils.rxSchedulerHelper());
  }
}
