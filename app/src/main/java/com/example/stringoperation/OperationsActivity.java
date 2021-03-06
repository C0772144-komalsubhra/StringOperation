package com.example.stringoperation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OperationsActivity extends Activity {
    private EditText edtName;
    private Button btnUppercase;
    private Button btnLowercase;
    private Button btnmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        btnUppercase = findViewById(R.id.btnUppercase);
        btnLowercase = findViewById(R.id.btnLowercase);
        btnmain = findViewById(R.id.btnMain);

        edtName = findViewById(R.id.edtName);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Name");
            edtName.setText(value);
        }

        btnUppercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalString = edtName.getText().toString().trim().toUpperCase();
                if(finalString.isEmpty())
                {
                    edtName.setError("Enter Country Name");
                }
                else
                {
                    Intent mIntent = new Intent();
                    mIntent.putExtra("finalString", finalString);
                    setResult(RESULT_OK, mIntent);
                    finish();
                }
            }
        });
        btnLowercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalString = edtName.getText().toString().trim().toLowerCase();
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", "LOWERCASE: " + finalString);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });

        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalString = edtName.getText().toString().length();
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", "FIRST NAME: " +  finalString);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });
    }

}

