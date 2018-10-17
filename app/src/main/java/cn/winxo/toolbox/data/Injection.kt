package cn.winxo.toolbox.data

import android.content.Context
import cn.winxo.toolbox.data.dao.AppDatabase
import cn.winxo.toolbox.data.dao.TaskDao
import cn.winxo.toolbox.data.source.TaskRepository
import io.reactivex.annotations.NonNull

object Injection {

    fun provideTaskRepository(@NonNull context: Context): TaskRepository {
        val taskDao = AppDatabase.getInstance(context)!!.taskDao()
        return TaskRepository.getInstance(taskDao)
    }
}