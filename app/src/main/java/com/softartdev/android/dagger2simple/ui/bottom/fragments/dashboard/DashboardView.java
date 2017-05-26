package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import java.util.List;

public interface DashboardView {
    void onCheck(String checked, List<String> dataSet);

    void onItemCheck(String itemCheck);
}
