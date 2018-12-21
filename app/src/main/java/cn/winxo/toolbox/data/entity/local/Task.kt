package cn.winxo.toolbox.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
@Entity(tableName = "task")
class Task(var content: String?, var createTime: Date?, var modifiedTime: Date?) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var finished: Boolean? = false
}
