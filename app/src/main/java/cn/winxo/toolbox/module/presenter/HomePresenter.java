package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import android.util.Log;
import cn.winxo.toolbox.base.BasePresenter;
import cn.winxo.toolbox.data.entity.local.UserEntity;
import cn.winxo.toolbox.data.source.UserRepository;
import cn.winxo.toolbox.module.conract.HomeContract;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

  private Context mContext;
  private UserRepository mUserRepository;

  public HomePresenter(Context context, UserRepository userRepository) {
    mContext = context;
    mUserRepository = userRepository;
  }

  @Override public void loadUser() {
    addSubscription(mUserRepository.getUser()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userEntities -> Log.e("HomePresenter", "accept: " + userEntities.size()), Throwable::printStackTrace));
  }

  @Override public void insertUser(UserEntity userEntity) {
    addSubscription(Flowable.create((FlowableOnSubscribe<Boolean>) e -> {
      mUserRepository.insertUser(userEntity);
      e.onNext(true);
    }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(aBoolean -> {

    }, throwable -> {

    }));
  }
}
