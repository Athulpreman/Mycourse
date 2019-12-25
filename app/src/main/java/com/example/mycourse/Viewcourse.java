package com.example.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Viewcourse extends AppCompatActivity {
    String api="https://dummyapilist.herokuapp.com/getcourses";
    String t,d,d1,v,d2;
    RecyclerView recyclerView;
    List<Add>myList;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcourse);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        myList=new ArrayList<>();
        int numOfColoumn=1;
        recyclerView.setLayoutManager(new GridLayoutManager(this,numOfColoumn));
        callapi();

    }

    private void callapi() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        t=jsonObject.getString("courseTitle");
                        d=jsonObject.getString("courseDescription");
                        d1=jsonObject.getString("courseDuration");
                        v=jsonObject.getString("courseVenue");
                        d2=jsonObject.getString("courseDate");
                        Add add=new Add(t,d,d1,v,d2);
                        myList.add(add);

                    }
                    adapter=new CustomAdapter(myList,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue ob1= Volley.newRequestQueue(getApplicationContext());
        ob1.add(stringRequest);
    }
}
