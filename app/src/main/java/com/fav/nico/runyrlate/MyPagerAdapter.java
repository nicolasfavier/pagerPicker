package com.fav.nico.runyrlate;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
    TextView view = new TextView(context);
    view.setText("Item " + position);
    view.setGravity(Gravity.CENTER);
    view.setBackground(context.getDrawable(R.drawable.background_border_purple));

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