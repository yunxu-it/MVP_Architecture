package cn.winxo.toolbox.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.winxo.toolbox.interfaces.OnRecyclerTouchListener;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class AdvancedRecyclerView extends RecyclerView {
  int sX, sY, eX, eY = 0;
  private OnRecyclerTouchListener mOnRecyclerTouchListener;

  public AdvancedRecyclerView(Context context) {
    super(context);
  }

  public AdvancedRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public AdvancedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override public boolean onTouchEvent(MotionEvent e) {
    switch (e.getAction()) {
      case MotionEvent.ACTION_DOWN:
        sX = (int) e.getX();//获得当前点击的X坐标
        sY = (int) e.getY();//获得当前点击的Y坐标
        break;
      case MotionEvent.ACTION_MOVE:
        break;
      case MotionEvent.ACTION_UP:
        int xrange = Math.abs((int) e.getX() - sX);//获得当前点击的X坐标
        int yrange = Math.abs((int) e.getY() - sY);//获得当前点击的Y坐标
        if (xrange > 100 && yrange < 20) {
          mOnRecyclerTouchListener.onRightSlide();
        }
        break;
      default:
        return super.onTouchEvent(e);
    }
    return true;
  }

  public void setOnRecyclerTouchListener(OnRecyclerTouchListener onRecyclerTouchListener) {
    mOnRecyclerTouchListener = onRecyclerTouchListener;
  }
}
