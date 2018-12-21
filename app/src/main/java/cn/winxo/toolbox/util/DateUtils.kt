package cn.winxo.toolbox.util

/**
 * @author lxlong
 * @date 12/21/2018
 * @desc
 */
object DateUtils {
    fun getChineseMonth(month: Int) = when (month) {
        1 -> "一月"
        2 -> "二月"
        3 -> "三月"
        4 -> "四月"
        5 -> "五月"
        6 -> "六月"
        7 -> "七月"
        8 -> "八月"
        9 -> "九月"
        10 -> "十月"
        11 -> "十一月"
        12 -> "十二月"
        else -> "未知"
    }

    fun getTimeFormat(hour: Int, minute: Int): String {
        val hourStr = if (hour < 10) "0$hour" else hour.toString()
        val minuteStr = if (minute < 10) "0$minute" else minute.toString()
        return "$hourStr:$minuteStr"
    }
}