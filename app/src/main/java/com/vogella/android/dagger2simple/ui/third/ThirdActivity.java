package com.vogella.android.dagger2simple.ui.third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vogella.android.dagger2simple.R;

public class ThirdActivity extends AppCompatActivity {
    boolean presenterInjected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView textView = (TextView) findViewById(R.id.third_text_view);
        textView.append(" " + presenterInjected);
    }
}
