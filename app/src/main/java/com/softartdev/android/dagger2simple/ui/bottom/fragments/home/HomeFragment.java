package com.softartdev.android.dagger2simple.ui.bottom.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class HomeFragment extends Fragment implements HomeView, View.OnClickListener {
    TextView homeTextView;
    EditText firstEditText, secondEditText, thirdEditText;
    public static final String SAVED_STRINGS = "saves_strings";
    private String[] mData = new String[4];

    @Inject HomePresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public String[] getData() {
        return mData;
    }

    public void setData(String[] data) {
        mData = data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeTextView = (TextView) view.findViewById(R.id.home_text_view);
        Button homeButton = (Button) view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(this);
        firstEditText = (EditText) view.findViewById(R.id.home_first_edit_text);
        secondEditText = (EditText) view.findViewById(R.id.home_second_edit_text);
        thirdEditText = (EditText) view.findViewById(R.id.home_third_edit_text);

        if (savedInstanceState != null) {
            mData = savedInstanceState.getStringArray(SAVED_STRINGS);
            if (mData != null) {
                homeTextView.setText(mData[0]);
                firstEditText.setText(mData[1]);
                secondEditText.setText(mData[2]);
                thirdEditText.setText(mData[3]);
            }
        }

        return view;
    }

    @Override
    public void onCheck(String checked, String firstData, String secondData, String thirdData) {
        homeTextView.setText(checked);
        firstEditText.setText(firstData);
        secondEditText.setText(secondData);
        thirdEditText.setText(thirdData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                mPresenter.check();
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mData[0] = homeTextView.getText().toString();
        mData[1] = firstEditText.getText().toString();
        mData[2] = secondEditText.getText().toString();
        mData[3] = thirdEditText.getText().toString();
        outState.putStringArray(SAVED_STRINGS, mData);
    }
}
