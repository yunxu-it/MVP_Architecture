package cn.winxo.toolbox.base.ibase

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
interface IPresenter<T : IView> {

    fun attachView(view: T)

    fun detachView()

    /**
     * RxJava取消注册，以避免内存泄露
     */
    fun onUnSubscribe()
}