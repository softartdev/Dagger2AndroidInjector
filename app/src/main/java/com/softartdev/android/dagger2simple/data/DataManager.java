package com.softartdev.android.dagger2simple.data;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private Context mContext;
    private List<String> mDataSet = new ArrayList<>();
    private int checks = 1;

    public DataManager(Context context) {
        mContext = context;
    }

    public List<String> getDataSet() {
        return mDataSet;
    }

    public List<String> getIncreaseDataSet() {
        String checked = mContext.getString(R.string.check_context);
        mDataSet.clear();
        for (int i = 0; i < checks; i++) {
            mDataSet.add(checked + ": " + checks + " - " + i);
        }
        checks = checks * 2;
        return mDataSet;
    }
}
