package com.example.a16022635.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TasksArrayAdapter extends ArrayAdapter<Task> {
    Context context;
    ArrayList<Task> tasks;
    int resource;
    TextView tvID, tvName, tvDesc;

    public TasksArrayAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tvID = rowView.findViewById(R.id.tvID);
        tvName = rowView.findViewById(R.id.tvName);
        tvDesc = rowView.findViewById(R.id.tvDesc);

        Task task = tasks.get(position);

        tvID.setText(task.getId() + ". ");
        tvName.setText(task.getName() + "");
        tvDesc.setText(task.getDescription() + "");

        return rowView;
    }
}
