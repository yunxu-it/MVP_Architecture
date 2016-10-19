package cn.winxo.library.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * User: winxo
 * Date: 2016/8/25
 */
public class RxBus {

    private final Subject<Object, Object> _bus;

    private static class RxBusHolder {
        public static final RxBus instance = new RxBus();
    }

    private RxBus() {
        _bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static synchronized RxBus getInstance() {
        return RxBusHolder.instance;
    }

    public void post(Object o) {
        _bus.onNext(o);
    }

    public <T> Observable<T> tObservable(Class<T> eventType) {
        return _bus.ofType(eventType);
    }


}
