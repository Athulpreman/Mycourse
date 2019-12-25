package com.example.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Addcourse extends AppCompatActivity {
    EditText c1,c2,c3,c4,c5;
    Button button;
    String ct,cd,cdu,cv,cda;
    String ct2,cd2,cdu2,cv2,cda2;
    Add add;
    String api="https://dummyapilist.herokuapp.com/addcourse";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);

        c1=(EditText)findViewById(R.id.coursetitle);
        c2=(EditText)findViewById(R.id.coursedescription);
        c3=(EditText)findViewById(R.id.courseduration);
        c4=(EditText)findViewById(R.id.coursevenue);
        c5=(EditText)findViewById(R.id.coursedate);
        progressBar=(ProgressBar)findViewById(R.id.pb);
        add=new Add();

        button=(Button)findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                ct=c1.getText().toString();
                cd=c2.getText().toString();
                cdu=c3.getText().toString();
                cv=c4.getText().toString();
                cda=c5.getText().toString();

                add.setCt1(ct);
                add.setCd1(cd);
                add.setCdu1(cdu);
                add.setCv1(cv);
                add.setCda1(cda);

                ct2=add.getCt1();
                cd2=add.getCd1();
                cdu2=add.getCdu1();
                cv2=add.getCv1();
                cda2=add.getCda1();

                Toast.makeText(getApplicationContext(),ct2+" "+cd2+" "+cdu2+" "+cv2+" "+cda2,Toast.LENGTH_LONG).show();
                callApi();
            }
        });
    }

    private void callApi() {
        final StringRequest ob=new StringRequest(Request.Method.POST, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);
                c1.setText("");
                c2.setText("");
                c3.setText("");
                c4.setText("");
                c5.setText("");
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),String.valueOf(error),Toast.LENGTH_SHORT).show();

            }
        })
     {
         @Override
         protected Map<String, String> getParams() throws AuthFailureError {
             HashMap<String,String>param=new HashMap<>();
             param.put("courseTitle",ct);
             param.put("courseDescription",cd);
             param.put("courseDuration",cdu);
             param.put("courseVenue",cv);
             param.put("courseDate",cda);
             return param;
         }
     };
        RequestQueue ob1= Volley.newRequestQueue(getApplicationContext());
        ob1.add(ob);
    }
}
