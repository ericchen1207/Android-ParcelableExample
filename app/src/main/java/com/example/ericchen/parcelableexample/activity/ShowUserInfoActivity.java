package com.example.ericchen.parcelableexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ericchen.parcelableexample.R;
import com.example.ericchen.parcelableexample.parcelable.UserInfo;

public class ShowUserInfoActivity extends AppCompatActivity {

    private String TAG = ShowUserInfoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_info);

        Intent i = getIntent();
        UserInfo userInfo = (UserInfo) i.getParcelableExtra("userInfo");
        if (userInfo != null) {
            ((TextView) findViewById(R.id.tv_user_name)).setText(userInfo.getName());
            ((TextView) findViewById(R.id.tv_user_age)).setText(String.valueOf(userInfo.getAge()));
        }
    }
}
