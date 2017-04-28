package com.vogella.android.dagger2simple.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vogella.android.dagger2simple.R;
import com.vogella.android.dagger2simple.ui.second.SecondActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends Activity implements View.OnClickListener {

    @Inject NetworkApi networkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean injected =  networkApi == null ? false : true;
        TextView userAvailable = (TextView) findViewById(R.id.target);
        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected));

        Button button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button:
                startActivity(new Intent(this, SecondActivity.class));
                break;
        }
    }
}
