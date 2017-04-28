package com.vogella.android.dagger2simple.ui.second;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vogella.android.dagger2simple.R;
import com.vogella.android.dagger2simple.ui.third.ThirdActivity;

public class SecondActivity extends AppCompatActivity implements SecondView, View.OnClickListener {
    boolean mPresenterInjected;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.second_button);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.second_text_view);

        checkPresenter();
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
