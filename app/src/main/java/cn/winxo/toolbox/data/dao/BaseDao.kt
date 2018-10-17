package cn.winxo.toolbox.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

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