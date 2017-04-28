package com.vogella.android.dagger2simple.ui.third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vogella.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ThirdActivity extends AppCompatActivity implements ThirdView {
    TextView textView;

    @Inject ThirdPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.third_text_view);

        presenter.check();
    }

    @Override
    public void onCheck(boolean presenterInjected) {
        textView.append(" " + presenterInjected);
    }
}
