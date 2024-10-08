package com.mahad.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> taskList;


    public TaskAdapter(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each task
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // Get the current task
        Task task = taskList.get(position);

        // Set the task name and description in the respective TextViews
        holder.textViewTaskName.setText(task.getTaskName());
        holder.textViewTaskDescription.setText(task.getTaskDescription());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    // ViewHolder class for managing item views
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTaskName;
        TextView textViewTaskDescription;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTaskName = itemView.findViewById(R.id.textViewTaskName);
            textViewTaskDescription = itemView.findViewById(R.id.textViewTaskDescription);
        }
    }
}
