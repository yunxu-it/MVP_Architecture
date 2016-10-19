package cn.winxo.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: winxo
 * Date: 10/11/2016
 */
public abstract class BaseQuickListAdapter<T, H extends BaseAdapterHelper> extends BaseAdapter {

    protected final Context mContext;
    protected final int mLayoutResId;
    public List<T> mData;


    public BaseQuickListAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    public BaseQuickListAdapter(Context context, int layoutResId, List<T> data) {
        mContext = context;
        mLayoutResId = layoutResId;
        mData = data == null ? new ArrayList<T>() : new ArrayList<T>(data);

    }

    public void addNewData(List<T> data) {
        this.mData.clear();
        this.mData.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final H helper = getAdapterHelper(position, convertView, parent);
            T item = getItem(position);
            convert(helper, item);
            return helper.getView();
        }
        return convertView;
    }

    protected abstract void convert(H helper, T item);

    protected abstract H getAdapterHelper(int position, View convertView, ViewGroup parent);
}
