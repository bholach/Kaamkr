package com.kaamkr.kaamkr.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kaamkr.kaamkr.HomeActivity;
import com.kaamkr.kaamkr.R;

public class LoginRegisterAdapter extends PagerAdapter {

    private Context mContext;
    private int layouts_ids[]={R.layout.login_form,R.layout.register_form};
    private String layout_names[]={"Login","Register"};

    public LoginRegisterAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(layouts_ids[position], container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return layout_names[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
