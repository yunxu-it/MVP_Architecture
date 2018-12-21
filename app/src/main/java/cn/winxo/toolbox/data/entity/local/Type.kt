package cn.winxo.toolbox.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
@Entity(tableName = "task_type")
class Type(var order: Int, var background: String, var name: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
