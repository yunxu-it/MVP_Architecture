package cn.winxo.toolbox.data.source.interfaces

import cn.winxo.toolbox.data.entity.local.Task
import cn.winxo.toolbox.data.entity.local.Type
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.Date

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
interface TaskDataSource {
    fun listAllTask(): Flowable<List<Task>>

    fun addTask(content: String, date: Date): Flowable<Task>

    fun removeTask(id: Long): Observable<Boolean>

    fun listAllType(): Flowable<List<Type>>

}
