package cn.winxo.toolbox.module.contract

import cn.winxo.toolbox.base.ibase.IPresenter
import cn.winxo.toolbox.base.ibase.IView
import cn.winxo.toolbox.data.entity.local.Task

interface HomeContract {

    interface View : IView {

        fun showData(tasks: List<Task>)

        fun addTask(task: Task)

        fun removeTask(position: Int)
    }

    interface Presenter : IPresenter<View> {

        fun loadTask()

        fun addTask(content: String)

        fun removeTask(position: Int, task: Task)
    }
}