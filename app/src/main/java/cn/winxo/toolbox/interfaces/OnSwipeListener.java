package cn.winxo.toolbox.interfaces;

public interface OnSwipeListener<T> {
  void onDelete(int position, T t);

  void onEdit(int position, T t);
}