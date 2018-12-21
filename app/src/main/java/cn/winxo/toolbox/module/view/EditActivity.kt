package cn.winxo.toolbox.module.view

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import cn.winxo.toolbox.R
import cn.winxo.toolbox.data.Injection
import cn.winxo.toolbox.data.entity.Constant
import cn.winxo.toolbox.data.entity.local.Task
import cn.winxo.toolbox.module.contract.EditContract
import cn.winxo.toolbox.module.presenter.EditPresenter
import cn.winxo.toolbox.util.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_edit.add_task_input
import kotlinx.android.synthetic.main.activity_edit.page_content
import java.util.Timer
import kotlin.concurrent.timerTask

/**
 * @author lxlong
 * @date 10/17/2018
 * @desc
 */
class EditActivity : BaseMvpActivity<EditContract.Presenter>(), EditContract.View {
    override fun addSuccess(task: Task) {
        finish()
    }

    var START_X: Int = 0
    var START_Y: Int = 0

    override
    fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        START_X = intent.getIntExtra(Constant.ExtraKey.START_X, 0)
        START_Y = intent.getIntExtra(Constant.ExtraKey.START_Y, 0)
    }

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_edit
    }

    override fun initView() {
        page_content.post {
            val endRadius = Math.hypot(page_content.width.toDouble(), page_content.width.toDouble()).toInt()
            val anim = ViewAnimationUtils.createCircularReveal(page_content, START_X, START_Y, 0f, endRadius.toFloat())
            anim.duration = 1000
            anim.interpolator = AccelerateDecelerateInterpolator()
            anim.start()
        }

        Timer().schedule(timerTask {
            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.showSoftInput(add_task_input, 0)
        }, 500)
        add_task_input.setOnKeyListener { v, keyCode, event ->
            if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.action) {
                if (add_task_input.text.isEmpty()) {
                    finish()
                } else {
                    mPresenter.addTask(add_task_input.text.toString())
                }
                return@setOnKeyListener true
            } else {
                return@setOnKeyListener false
            }
        }
    }

    override fun onLoadPresenter(): EditPresenter {
        return EditPresenter(this, Injection.provideTaskRepository(this))
    }

}
