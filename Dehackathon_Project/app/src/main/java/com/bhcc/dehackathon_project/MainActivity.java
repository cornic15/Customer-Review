package com.bhcc.dehackathon_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_share, btn_save;
    RadioButton rb_question1, rb_question2, rb_question4, rb_question3;
    String cust_feedback;
    RadioGroup rg_1, rg_2, rg_3, rg_4;
    EditText tell_us_more;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_share = findViewById(R.id.shareBtn);
        btn_save = findViewById(R.id.btn_save);
        tell_us_more = findViewById(R.id.tml_tell_us_more);
        rg_1 = (RadioGroup) findViewById(R.id.radioGroup_1);
        rg_2 = (RadioGroup) findViewById(R.id.radioGroup_2);
        rg_3 = (RadioGroup) findViewById(R.id.radioGroup_3);
        rg_4 = (RadioGroup) findViewById(R.id.radioGroup_4);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

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
                    int selectedId = rg_1.getCheckedRadioButtonId();
                    int selectedId2 = rg_2.getCheckedRadioButtonId();
                    int selectedId3 = rg_3.getCheckedRadioButtonId();
                    int selectedId4 = rg_4.getCheckedRadioButtonId();
                    rb_question1 = (RadioButton) findViewById(selectedId);
                    rb_question2 = (RadioButton) findViewById(selectedId2);
                    rb_question3 = (RadioButton) findViewById(selectedId3);
                    rb_question4 = (RadioButton) findViewById(selectedId4);
                    cust_feedback = tell_us_more.getText().toString();
                    customerModel = new CustomerModel(-1, String.valueOf(ratingBar.getRating()), rb_question1.getText().toString(), rb_question2.getText().toString(),
                            rb_question3.getText().toString(), rb_question4.getText().toString(), cust_feedback);
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    customerModel = new CustomerModel(-1, "nan", "nan", "nan", "nan", "nan", "nan");
                    Toast.makeText(MainActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success: Data Saved", Toast.LENGTH_SHORT).show();

            }
        });
    }
}