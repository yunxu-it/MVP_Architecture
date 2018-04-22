package cn.winxo.mvp.module.presenter;

import android.content.Context;
import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.data.entity.remote.Gank;
import cn.winxo.mvp.data.source.GankRepository;
import cn.winxo.mvp.data.source.remote.GankRemoteDataSource;
import cn.winxo.mvp.module.conract.GankContact;
import io.reactivex.functions.Consumer;
import java.util.List;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class GankPresenter extends BasePresenter<GankContact.View>
    implements GankContact.Presenter {

  private final Context context;
  private final GankRepository mGankRepository;

  public GankPresenter(Context context) {
    this.context = context;
    mGankRepository = GankRepository.getInstance(GankRemoteDataSource.getInstance());
  }

  @Override public void getGanks(int page) {
    addSubscription(mGankRepository.getGankData(page).subscribe(new Consumer<List<Gank>>() {
      @Override public void accept(List<Gank> ganks) throws Exception {

      }
    }, new Consumer<Throwable>() {
      @Override public void accept(Throwable throwable) throws Exception {

      }
    }));
  }
}
