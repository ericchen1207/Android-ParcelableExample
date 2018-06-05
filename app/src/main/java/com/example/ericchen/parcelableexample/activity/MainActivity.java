package com.example.ericchen.parcelableexample.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ericchen.parcelableexample.R;
import com.example.ericchen.parcelableexample.parcelable.UserInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    private TextInputEditText etName, etAge;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (TextInputEditText) findViewById(R.id.et_name);
        etAge = (TextInputEditText) findViewById(R.id.et_age);
        btnSend = (Button) findViewById(R.id.btn_send);
        etAge.setOnEditorActionListener(this);
        btnSend.setOnClickListener(this);
    }


    public void sendUserInfo() {

        int nameLength = etName.getText().toString().trim().length();
        int ageLength = etAge.getText().toString().trim().length();

        if (nameLength == 0 || ageLength == 0) {
            Toast.makeText(this, "All fields should be filled", Toast.LENGTH_SHORT).show();
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(etName.getText().toString());
            userInfo.setAge(Integer.parseInt(etAge.getText().toString()));

            Intent intent = new Intent(this, ShowUserInfoActivity.class);
            intent.putExtra("userInfo", userInfo);
            startActivity(intent);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId) {
            case EditorInfo.IME_ACTION_DONE:
                sendUserInfo();
                break;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                sendUserInfo();
                break;
        }
    }
}
