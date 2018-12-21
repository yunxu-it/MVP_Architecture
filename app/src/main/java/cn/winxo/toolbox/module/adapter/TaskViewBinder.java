package cn.winxo.toolbox.module.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.data.entity.local.Task;
import cn.winxo.toolbox.util.interfaces.OnSwipeListener;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class TaskViewBinder extends ItemViewBinder<Task, TaskViewBinder.ViewHolder> {

  private OnSwipeListener<Task> mOnSwipeListener;

  @NonNull @Override protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
    View root = inflater.inflate(R.layout.item_task, parent, false);
    return new ViewHolder(root);
  }

  @Override protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Task task) {
    holder.mContent.setText(task.getContent());
    holder.mDelete.setOnClickListener(v -> {
      if (null != mOnSwipeListener) {
        mOnSwipeListener.onDelete(holder.getAdapterPosition(), task);
      }
    });
    holder.mEdit.setOnClickListener(v -> {
      if (null != mOnSwipeListener) {
        mOnSwipeListener.onEdit(holder.getAdapterPosition(), task);
      }
    });
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private TextView mContent;
    private ImageView mDelete;
    private ImageView mEdit;

    ViewHolder(View itemView) {
      super(itemView);
      mContent = itemView.findViewById(R.id.content);
      mDelete = itemView.findViewById(R.id.swipe_delete);
      mEdit = itemView.findViewById(R.id.swipe_edit);
    }
  }

  public void setOnSwipeListener(OnSwipeListener<Task> onSwipeListener) {
    mOnSwipeListener = onSwipeListener;
  }
}
