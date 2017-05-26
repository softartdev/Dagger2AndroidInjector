package com.softartdev.android.dagger2simple.ui.bottom.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class HomeFragment extends Fragment implements HomeView, View.OnClickListener {
    TextView homeTextView;

    @Inject HomePresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeTextView = (TextView) view.findViewById(R.id.home_text_view);
        Button homeButton = (Button) view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCheck(String checked) {
        homeTextView.setText(checked);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                mPresenter.check();
                break;
        }
    }
}
