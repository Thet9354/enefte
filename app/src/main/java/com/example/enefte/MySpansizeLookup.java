package com.example.enefte;

import androidx.recyclerview.widget.GridLayoutManager;

public class MySpansizeLookup extends GridLayoutManager.SpanSizeLookup{

    int spanPos;
    int spanCount1;
    int spanCount2;

    public MySpansizeLookup(int spanPos, int spanCount1, int spanCount2) {
        this.spanPos = spanPos;
        this.spanCount1 = spanCount1;
        this.spanCount2 = spanCount2;
    }

    @Override
    public int getSpanSize(int position) {
        return position % spanPos==0?spanCount2:spanCount1;
    }
}
