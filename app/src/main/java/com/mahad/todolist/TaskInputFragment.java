package com.mahad.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskInputFragment extends Fragment {

    private EditText editTextTaskName;
    private EditText editTextTaskDescription;
    private OnTaskSavedListener taskSavedListener;

    public TaskInputFragment() {
    }

    // Define an interface for the activity to implement
    public interface OnTaskSavedListener {
        void onTaskSaved(String taskName, String taskDescription);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTaskSavedListener) {
            taskSavedListener = (OnTaskSavedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnTaskSavedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_input, container, false);

        // Initialize views
        editTextTaskName = view.findViewById(R.id.editTextTaskName);
        editTextTaskDescription = view.findViewById(R.id.editTextTaskDescription);
        Button buttonSave = view.findViewById(R.id.buttonSave);

        // Handle save button click
        buttonSave.setOnClickListener(v -> {
            String taskName = editTextTaskName.getText().toString().trim();
            String taskDescription = editTextTaskDescription.getText().toString().trim();

            // Notify the activity that the task is saved
            if (taskSavedListener != null) {
                taskSavedListener.onTaskSaved(taskName, taskDescription);
            }

            // Close the fragment after saving
            getParentFragmentManager().popBackStack();
        });

        return view;
    }

}
