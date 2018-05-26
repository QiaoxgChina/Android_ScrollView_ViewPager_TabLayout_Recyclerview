package com.qiaoxg.scrollviewdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MasterInfoActivity extends AppCompatActivity {

    private static final String TAG = "MasterInfoActivity";

    TabLayout masterInfoTabLayout;
    ChildViewPager mViewPager;
    View mTitleView;
    TextView titleUsername;
    TabLayout titleTabLayout;
    LinearLayout hiddenTabLayout;

    private void initViewLayout(){
        masterInfoTabLayout = findViewById(R.id.masterInfo_tabLayout);
        mViewPager = findViewById(R.id.masterInfo_viewPager);
        mTitleView = findViewById(R.id.titleBar_view);
        titleUsername = findViewById(R.id.titleBar_username);
        titleTabLayout = findViewById(R.id.masterInfo_title_tabLayout);
        hiddenTabLayout = findViewById(R.id.hidden_tabLayout);
    }

    private String[] TAB_TITLES = new String[]{"动态", "店铺"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_infor);
        ButterKnife.bind(this);
        initData();
        initViewLayout();
        initView();
    }

    private MasterInfoAdapter mInfoAdapter;
    private MasterInfoShopAdapter mShopAdapter;
    private float mAlpha = 0.0f;

    private void initView() {

        List<View> mViewList = new ArrayList<>();

        for (int i = 0; i < TAB_TITLES.length; i++) {
            View view = getLayoutInflater().inflate(R.layout.view_master_viewpager, null);
            RecyclerView rv = view.findViewById(R.id.master_recyclerView);
            if (i == 0) {
                mInfoAdapter = new MasterInfoAdapter(this);
                mInfoAdapter.setData(firstDataList);
                rv.setAdapter(mInfoAdapter);
            } else {
                mShopAdapter = new MasterInfoShopAdapter(this);
                mShopAdapter.setData(secondDataList);
                rv.setAdapter(mShopAdapter);
            }

            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setNestedScrollingEnabled(false);
            rv.setHasFixedSize(true);

            mViewList.add(view);
        }

        scrollView = findViewById(R.id.masterInfo_scrollView);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                mAlpha = (float) (i1 - 200) / 250;
                setTitleBarAlpha();
            }
        });
        masterInfoTabLayout.setupWithViewPager(mViewPager);
        titleTabLayout.setupWithViewPager(mViewPager);

        BaseViewVpAdapter mViewPagerAdapter = new BaseViewVpAdapter(mViewList);
        mViewPager.setAdapter(mViewPagerAdapter);

        for (int i = 0; i < masterInfoTabLayout.getTabCount(); i++) {
            masterInfoTabLayout.getTabAt(i).setText(TAB_TITLES[i]);
        }
        for (int i = 0; i < titleTabLayout.getTabCount(); i++) {
            titleTabLayout.getTabAt(i).setText(TAB_TITLES[i]);
        }
        setTab();

        MyPageChangeListenser changeListener = new MyPageChangeListenser();
        mViewPager.addOnPageChangeListener(changeListener);
        changeListener.onPageSelected(0);
    }

    private NestedScrollView scrollView;

    /**
     * 装填tab数据
     */
    private void setTab() {
//        LinearLayout linearLayout = (LinearLayout) masterInfoTabLayout.getChildAt(0);
//        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this, R.drawable.shape_shu_xian));
//        linearLayout.setDividerPadding(1);
//
//
//        LinearLayout linearLayout1 = (LinearLayout) titleTabLayout.getChildAt(0);
//        linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        linearLayout1.setDividerDrawable(ContextCompat.getDrawable(this, R.drawable.shape_shu_xian));
//        linearLayout1.setDividerPadding(1);

    }

    public class MyPageChangeListenser implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mViewPager.resetHeight(position);
            initViewPager(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private List<MasterBean> firstDataList = new ArrayList<>();
    private List<MasterBean> secondDataList = new ArrayList<>();

    private void initData() {
        for (int i = 0; i < 15; i++) {
            MasterBean bean = new MasterBean();
            bean.setCount("1280");
            bean.setIconUrl("http://img1.imgtn.bdimg.com/it/u=574475081,3422538218&fm=27&gp=0.jpg");
            bean.setId(i + "");
            bean.setUserName(appendString("明星店主", i % 5));
            firstDataList.add(bean);
        }

        for (int i = 0; i < 15; i++) {
            MasterBean bean = new MasterBean();
            bean.setCount("1280");
            bean.setIconUrl("http://img1.imgtn.bdimg.com/it/u=574475081,3422538218&fm=27&gp=0.jpg");
            bean.setId(i + "");
            bean.setUserName(appendString("新晋店主", i % 5));
            secondDataList.add(bean);
        }
    }

    private String appendString(String str, int times) {
        if (times < 1) return str;
        for (int a = 0; a < times; a++) {
            str = str + str;
        }
        return str;
    }

    private void initViewPager(int position) {
    }

    @OnClick(R.id.masterInfo_back)
    public void onViewClicked() {
        finish();
    }

    private void setTitleBarAlpha() {
        if (mTitleView == null) {
            return;
        }
        mTitleView.setAlpha(mAlpha);
        titleUsername.setAlpha(mAlpha);
        if (mAlpha >= 1.05) {
            hiddenTabLayout.setVisibility(View.VISIBLE);
//            masterInfoTabLayout.setVisibility(View.GONE);
        } else {
            hiddenTabLayout.setVisibility(View.GONE);
//            masterInfoTabLayout.setVisibility(View.VISIBLE);
        }
    }
}
