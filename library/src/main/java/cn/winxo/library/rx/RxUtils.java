package cn.winxo.library.rx;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * User: yunxu
 * Date: 2017/5/8
 * Time: 23:49
 * Email: yunxu.it@outlook.com
 * Desc:
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
