package com.softartdev.android.dagger2simple.ui.second;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;
import com.softartdev.android.dagger2simple.ui.third.ThirdActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class SecondActivity extends AppCompatActivity implements SecondView, View.OnClickListener {
    boolean mPresenterInjected;

    TextView textView;

    @Inject SecondPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.second_button);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.second_text_view);

        checkPresenter();

        presenter.check();
    }

    private void checkPresenter() {
        textView.append(" " + mPresenterInjected);
    }

    @Override
    public void onCheck(boolean presenterInjected) {
        mPresenterInjected = presenterInjected;
        checkPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.second_button:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
        }
    }
}
