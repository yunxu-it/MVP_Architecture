package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import cn.winxo.toolbox.base.BasePresenter;
import cn.winxo.toolbox.data.Injection;
import cn.winxo.toolbox.data.entity.remote.Gank;
import cn.winxo.toolbox.data.source.GankRepository;
import cn.winxo.toolbox.module.conract.GankContact;
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
    mGankRepository = Injection.provideGankRepository(context);
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
