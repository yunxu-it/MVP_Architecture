package cn.winxo.toolbox.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun replace(t: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(t: List<T>)

    @Insert
    abstract fun insert(t: T): Long

    @Update
    abstract fun update(t: T)

    @Update
    abstract fun update(t: List<T>)

    @Delete
    abstract fun deleteBatch(list: List<T>)

    @Delete
    abstract fun delete(t: T)
}