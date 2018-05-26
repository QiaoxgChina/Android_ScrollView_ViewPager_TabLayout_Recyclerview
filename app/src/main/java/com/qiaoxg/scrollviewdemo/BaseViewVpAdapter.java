package com.qiaoxg.scrollviewdemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Qiaoxg on 2018/5/18.
 */

public class BaseViewVpAdapter extends PagerAdapter {

    private List<View> mResultViewList;

    public BaseViewVpAdapter(List<View> viewList) {
        this.mResultViewList = viewList;
    }

    @Override
    public int getCount() {
        return mResultViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView(mResultViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mResultViewList.get(position));
        return mResultViewList.get(position);
    }
}
