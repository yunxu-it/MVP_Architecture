package cn.winxo.toolbox.module.view

import android.content.Intent
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.winxo.toolbox.R
import cn.winxo.toolbox.adapter.TaskViewBinder
import cn.winxo.toolbox.base.BaseMvpActivity
import cn.winxo.toolbox.data.Injection
import cn.winxo.toolbox.data.entity.Constant
import cn.winxo.toolbox.data.entity.local.Task
import cn.winxo.toolbox.interfaces.OnSwipeListener
import cn.winxo.toolbox.module.contract.HomeContract
import cn.winxo.toolbox.module.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_home.recycler_view
import kotlinx.android.synthetic.main.activity_home.swipe_refresh
import me.drakeet.multitype.MultiTypeAdapter

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
class HomeActivity : BaseMvpActivity<HomeContract.Presenter>(), HomeContract.View, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var mAdapter: MultiTypeAdapter

    override fun onLoadPresenter(): HomeContract.Presenter {
        return HomePresenter(this, Injection.provideTaskRepository(this))
    }

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_home
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    override fun initView() {
        swipe_refresh.setOnRefreshListener(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        mAdapter = MultiTypeAdapter()
        val binder = TaskViewBinder()
        binder.setOnSwipeListener(object : OnSwipeListener<Task> {
            override fun onDelete(position: Int, task: Task) {
                mPresenter.removeTask(position, task)
            }

            override fun onEdit(position: Int, task: Task) {

            }
        })
        mAdapter.register(Task::class.java, binder)
        recycler_view.adapter = mAdapter
    }

    override fun initData() {
        mPresenter.loadTask()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadTask()
    }

    override fun addTask(task: Task) {
        val items = mAdapter.items as MutableList<Task>
        items.add(0, task)
        mAdapter.notifyItemInserted(0)
    }

    override fun removeTask(position: Int) {
        val items = mAdapter.items as MutableList<Task>
        items.removeAt(position)
        mAdapter.notifyItemRangeRemoved(position, items.size)
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = false
        val intent = Intent()
        intent.setClass(this, EditActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        intent.putExtra(Constant.ExtraKey.START_X, 0)
        intent.putExtra(Constant.ExtraKey.START_Y, 0)
        startActivity(intent)
    }

    override fun showData(tasks: List<Task>) {
        mAdapter.items = tasks
        mAdapter.notifyDataSetChanged()
    }
}
