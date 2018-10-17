package cn.winxo.toolbox.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import cn.winxo.toolbox.data.entity.local.Task
import io.reactivex.Flowable

@Dao
abstract class TaskDao : BaseDao<Task>() {

    @get:Query("SELECT * from task ORDER BY modifiedTime DESC")
    abstract val allTask: Flowable<List<Task>>

    @Query("SELECT * from task where id=:id")
    abstract fun find(id: Long): List<Task>

    @Transaction
    open fun deleteTaskByID(id: Long) {
        val tasks = find(id)
        deleteBatch(tasks)
    }
}