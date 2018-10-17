package cn.winxo.toolbox.module.contract

import cn.winxo.toolbox.base.ibase.IPresenter
import cn.winxo.toolbox.base.ibase.IView
import cn.winxo.toolbox.data.entity.local.Task

/**
 * @author lxlong
 * @date 10/17/2018
 * @desc
 */
interface EditContract {
    interface View : IView {
        fun addSuccess(task: Task)

    }

    interface Presenter : IPresenter<View> {
        fun addTask(content: String)
    }
}