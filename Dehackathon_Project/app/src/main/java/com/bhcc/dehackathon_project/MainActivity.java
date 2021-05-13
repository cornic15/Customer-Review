package com.bhcc.dehackathon_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_share, btn_save;
    RadioButton rb_age_range, cust_serv;
    String cust_feedback;
    RadioGroup rg_age, rg_service;
    EditText tell_us_more;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_share = findViewById(R.id.shareBtn);
        btn_save = findViewById(R.id.btn_save);
        tell_us_more = findViewById(R.id.tml_tell_us_more);
        rg_age = (RadioGroup) findViewById(R.id.radioGroup_age);
        rg_service = (RadioGroup) findViewById(R.id.radioGroup_service);

        btn_share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String subject = "Experience";
                String body = tell_us_more.getText().toString();
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                shareIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(shareIntent,"Share using"));
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerModel customerModel;

                try{
                    int selectedId = rg_age.getCheckedRadioButtonId();
                    int selectedId2 = rg_service.getCheckedRadioButtonId();
                    rb_age_range = (RadioButton) findViewById(selectedId);
                    cust_serv = (RadioButton) findViewById(selectedId2);
                    cust_feedback = tell_us_more.getText().toString();
                    customerModel = new CustomerModel(-1, rb_age_range.getText().toString(), cust_serv.getText().toString(), cust_feedback);
//                    Toast.makeText(MainActivity.this, cust_feedback, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    customerModel = new CustomerModel(-1, "error", "error", "error");
                    Toast.makeText(MainActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success: " + success, Toast.LENGTH_SHORT).show();

            }
        });
    }
}