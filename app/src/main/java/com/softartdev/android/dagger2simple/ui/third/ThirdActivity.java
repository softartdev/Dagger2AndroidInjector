package com.softartdev.android.dagger2simple.ui.third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ThirdActivity extends AppCompatActivity implements ThirdView, View.OnClickListener {
    TextView textView;

    @Inject ThirdPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.third_text_view);
        Button button = (Button) findViewById(R.id.third_button);
        button.setOnClickListener(this);

        presenter.check();
    }

    @Override
    public void onCheck(boolean presenterInjected) {
        textView.append(" " + presenterInjected);
    }

    @Override
    public void onCheckContext(String checked) {
        textView.setText(checked);
    }

    @Override
    public void onClick(View v) {
        presenter.checkContext();
    }
}
