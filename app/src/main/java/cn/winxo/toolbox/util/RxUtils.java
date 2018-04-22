package cn.winxo.toolbox.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lxlong
 * @date 21/04/2018
 * @desc
 */
public class RxUtils {

  public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
    return observable -> observable.subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T> ObservableTransformer<T, T> rxIO2IOHelper() {    //compose简化线程
    return observable -> observable.subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(Schedulers.io());
  }
}
