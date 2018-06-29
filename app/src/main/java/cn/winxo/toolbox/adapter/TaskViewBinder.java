package cn.winxo.toolbox.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.data.entity.local.Task;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lxlong
 * @date 6/29/2018
 * @desc
 */
public class TaskViewBinder extends ItemViewBinder<Task, TaskViewBinder.ViewHolder> {

  @NonNull @Override protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
    View root = inflater.inflate(R.layout.item_task, parent, false);
    return new ViewHolder(root);
  }

  @Override protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Task task) {
    holder.mContent.setText(task.getContent());
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private TextView mContent;

    ViewHolder(View itemView) {
      super(itemView);
      mContent = itemView.findViewById(R.id.content);
    }
  }
}
