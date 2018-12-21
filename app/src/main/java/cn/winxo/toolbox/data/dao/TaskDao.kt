package cn.winxo.toolbox.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import cn.winxo.toolbox.data.entity.local.Task
import io.reactivex.Flowable

@Dao
abstract class TaskDao {

    @get:Query("SELECT * from task ORDER BY modifiedTime DESC")
    abstract val allTask: Flowable<List<Task>>

    @Query("SELECT * from task where id=:id")
    abstract fun find(id: Long): List<Task>

    @Delete
    abstract fun deleteBatch(tasks: List<Task>)

    @Transaction
    open fun deleteTaskByID(id: Long) {
        val tasks = find(id)
        deleteBatch(tasks)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTask(task: Task): Long
}