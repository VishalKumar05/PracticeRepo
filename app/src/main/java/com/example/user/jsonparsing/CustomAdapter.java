package com.example.user.jsonparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    private List<Employee> employeeInfo;

    public CustomAdapter(Context context, List<Employee> employeeInfo)
    {
        this.context = context;
        this.employeeInfo = employeeInfo;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView designation;
        private TextView dob;
        private TextView email;
        private TextView salary;
        private TextView mob;

        public MyViewHolder(View view)
        {
            super(view);
            name = (TextView)view.findViewById(R.id.name);
            designation = (TextView)view.findViewById(R.id.designation);
            dob = (TextView)view.findViewById(R.id.dob);
            email = (TextView)view.findViewById(R.id.email);
            salary = (TextView)view.findViewById(R.id.salary);
            mob = (TextView)view.findViewById(R.id.mobileno);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Employee employee = employeeInfo.get(i);
        myViewHolder.name.setText(employee.getName());
        myViewHolder.designation.setText(employee.getDesignation());
        myViewHolder.dob.setText(employee.getDob());
        myViewHolder.email.setText(employee.getEmail());
        myViewHolder.salary.setText(employee.getSalary());
        myViewHolder.mob.setText(employee.getMobNo());
    }

    @Override
    public int getItemCount() {
        return employeeInfo.size();
    }
}
