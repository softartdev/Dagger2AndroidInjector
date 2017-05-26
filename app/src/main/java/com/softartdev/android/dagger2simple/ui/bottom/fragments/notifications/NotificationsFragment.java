package com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications;

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

public class NotificationsFragment extends Fragment implements NotificationsView, View.OnClickListener {
    TextView notificationsTextView;

    @Inject NotificationsPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        notificationsTextView = (TextView) view.findViewById(R.id.notifications_text_view);
        Button notificationsButton = (Button) view.findViewById(R.id.notifications_button);
        notificationsButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCheck(String checked) {
        notificationsTextView.setText(checked);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notifications_button:
                mPresenter.check();
                break;
        }
    }
}
