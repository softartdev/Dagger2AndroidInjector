package com.softartdev.android.dagger2simple.ui.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;
import com.softartdev.android.dagger2simple.ui.bottom.BottomActivity;
import com.softartdev.android.dagger2simple.ui.scroll.ScrollingActivity;
import com.softartdev.android.dagger2simple.ui.second.SecondActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends Activity implements View.OnClickListener {

    @Inject NetworkApi networkApi;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean injected = networkApi != null;
        TextView userAvailable = (TextView) findViewById(R.id.target);
        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected));

        Button secondButton = (Button) findViewById(R.id.main_button);
        secondButton.setOnClickListener(this);

        Button scrollButton = (Button) findViewById(R.id.scroll_button);
        scrollButton.setOnClickListener(this);

        Button bottomButton = (Button) findViewById(R.id.bottom_button);
        bottomButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.scroll_button:
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
            case R.id.bottom_button:
                startActivity(new Intent(this, BottomActivity.class));
                break;
        }
    }
}
