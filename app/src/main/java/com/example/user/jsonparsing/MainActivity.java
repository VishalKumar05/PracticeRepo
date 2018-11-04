package com.example.user.jsonparsing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.textclassifier.TextLinks;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "http://api.androiddeft.com/retrofit/json_object.json";
    RecyclerView recyclerView;
    CustomAdapter mAdapter;
    List<Employee> employeeInfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new CustomAdapter(getApplicationContext(),employeeInfo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(mAdapter);

        getData();
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("employee");

                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        Employee employee = new Employee(
                          object.getString("name"),
                          object.getString("designation"),
                          object.getString("dob"),
                          object.getString("email"),
                          object.getString("salary"),
                          object.getString("contact_number")
                        );

                        employeeInfo.add(employee);
                    }

                    mAdapter.notifyDataSetChanged();

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(stringRequest);
    }
}