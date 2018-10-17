package cn.winxo.toolbox.util

/**
 * @author lxlong
 * @date 2018/3/26
 * @desc 此类是所有请求返回数据的包裹类，用来统一处理错误逻辑真正的返回数据在泛型T中
 */
class CommonResult<T> {

    private var status: String? = null
    var message: String? = null
    var data: T? = null

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String): CommonResult<T> {
        this.status = status
        return this
    }
}