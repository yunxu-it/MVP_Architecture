package cn.winxo.toolbox.data.dao

import androidx.room.Dao
import androidx.room.Query
import cn.winxo.toolbox.data.entity.local.Type
import io.reactivex.Flowable

@Dao
abstract class TypeDao {

    @get:Query("SELECT * from task_type ORDER BY `order` ASC")
    abstract val loadAllType: Flowable<List<Type>>
}