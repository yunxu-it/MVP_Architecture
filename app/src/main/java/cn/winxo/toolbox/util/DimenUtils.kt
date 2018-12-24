package cn.winxo.toolbox.util

import android.content.res.Resources

/**
 * @author lxlong
 * @date 12/24/2018
 * @desc
 */
object DimenUtils {
    fun px2dip(pxValue: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun dip2px(dipValue: Float): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return dipValue * scale + 0.5f
    }
}
