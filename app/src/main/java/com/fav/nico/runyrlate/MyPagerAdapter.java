package com.fav.nico.runyrlate;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nico on 07/01/17.
 */

public class MyPagerAdapter extends PagerAdapter {
  private Context context;

  public MyPagerAdapter(Context context) {
    this.context = context;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {

    String drawableName = "img" + (position % 12 + 1);
    int resID = container.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

    ImageView view = new ImageView(context);
    view.setImageResource(resID);
    container.addView(view);
    return view;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override public int getCount() {
    return 15;
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return (view == object);
  }
}