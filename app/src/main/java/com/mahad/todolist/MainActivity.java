package com.mahad.todolist;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskInputFragment.OnTaskSavedListener {

    private ArrayList<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;
    private RecyclerView recyclerView;  // Declare RecyclerView as a class variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTasks);
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Handle FAB click to show the TaskInputFragment
        FloatingActionButton fabAddTask = findViewById(R.id.fabAddTask);
        fabAddTask.setOnClickListener(v -> {
            // Hide the RecyclerView when adding a new task
            recyclerView.setVisibility(View.GONE);

            TaskInputFragment taskInputFragment = new TaskInputFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, taskInputFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    // Handle task saving from the fragment
    @Override
    public void onTaskSaved(String taskName, String taskDescription) {
        Task newTask = new Task(taskName, taskDescription);  // Create a new task object
        taskList.add(newTask);  // Add to the task list
        taskAdapter.notifyDataSetChanged();  // Notify adapter to update RecyclerView

        // Show the RecyclerView again after saving the task
        recyclerView.setVisibility(View.VISIBLE);
    }
}
