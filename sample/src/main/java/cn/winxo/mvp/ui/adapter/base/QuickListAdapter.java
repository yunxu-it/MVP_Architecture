package cn.winxo.mvp.ui.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class QuickListAdapter<T> extends BaseQuickListAdapter<T, BaseAdapterHelper> {

    /**
     * Create a QuickListAdapter.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public QuickListAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    /**
     * Same as QuickListAdapter#QuickListAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public QuickListAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    protected BaseAdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent) {
        return BaseAdapterHelper.get(mContext, convertView, parent, mLayoutResId, position);
    }

}