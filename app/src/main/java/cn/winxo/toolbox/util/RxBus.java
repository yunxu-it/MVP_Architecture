package cn.winxo.toolbox.util;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 基于{@link Relay}的event bus
 */
public class RxBus {
  private static volatile RxBus defaultInstance;

  private Relay<Object> bus;

  // PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
  private RxBus() {
    bus = PublishRelay.create().toSerialized();
  }

  // 单例RxBus
  public static RxBus getDefault() {
    if (defaultInstance == null) {
      synchronized (RxBus.class) {
        if (defaultInstance == null) {
          defaultInstance = new RxBus();
        }
      }
    }
    return defaultInstance;
  }

  // 发送一个新的事件
  public void post(Object o) {
    bus.accept(o);
  }

  // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
  public <T> Observable<T> toObservable(Class<T> eventType) {
    return bus.ofType(eventType);
  }

  public boolean hasObservers() {
    return bus.hasObservers();
  }

  public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext) {
    return toObservable(eventType).observeOn(scheduler).subscribe(onNext);
  }

  public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError, Action onComplete, Consumer onSubscribe) {
    return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError, onComplete, onSubscribe);
  }

  public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError, Action onComplete) {
    return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError, onComplete);
  }

  public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError) {
    return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError);
  }

  public <T> Disposable register(Class<T> eventType, Consumer<T> onNext) {
    return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext);
  }

  public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError, Action onComplete, Consumer onSubscribe) {
    return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError, onComplete, onSubscribe);
  }

  public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError, Action onComplete) {
    return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError, onComplete);
  }

  public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError) {
    return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError);
  }

  public void unregister(Disposable disposable) {
    if (disposable != null && !disposable.isDisposed()) {
      disposable.dispose();
    }
  }
}