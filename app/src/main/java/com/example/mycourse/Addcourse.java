package com.example.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addcourse extends AppCompatActivity {
    EditText c1,c2,c3,c4,c5;
    Button button;
    String ct,cd,cdu,cv,cda;
    String ct2,cd2,cdu2,cv2,cda2;
    Add add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);

        c1=(EditText)findViewById(R.id.coursetitle);
        c2=(EditText)findViewById(R.id.coursedescription);
        c3=(EditText)findViewById(R.id.courseduration);
        c4=(EditText)findViewById(R.id.coursevenue);
        c5=(EditText)findViewById(R.id.coursedate);
        add=new Add();

        button=(Button)findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }
}
