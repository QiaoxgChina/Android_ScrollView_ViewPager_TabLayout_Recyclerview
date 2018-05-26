package com.qiaoxg.scrollviewdemo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Qiaoxg on 2018/5/10.
 */

public class MasterInfoAdapter extends BaseRecyclerViewAdapter {

    private Context mContext;

    public MasterInfoAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
            mImg = arg0.findViewById(R.id.item_image);
            mUsernameTv = arg0.findViewById(R.id.username_tv);
            rootView = arg0.findViewById(R.id.item_rootView);
            mPeopleTv = arg0.findViewById(R.id.item_people);
            mIconIv = arg0.findViewById(R.id.username_icon);
            mLoveBtn = arg0.findViewById(R.id.item_love);
        }

        View rootView;
        ImageView mImg;
        TextView mPeopleTv;
        TextView mUsernameTv;
        ImageView mIconIv;
        View mLoveBtn;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_master_info, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            MasterBean bean = (MasterBean) getData().get(position);
            Glide.with(mContext)
                    .load(bean.getIconUrl())
                    .into(viewHolder.mImg);

            viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
//                    MasterInfoActivity.launch((Activity) mContext);
                }
            });

            viewHolder.mLoveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

}
