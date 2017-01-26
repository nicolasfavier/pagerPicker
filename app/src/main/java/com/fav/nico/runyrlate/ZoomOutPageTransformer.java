package com.fav.nico.runyrlate;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
  private static final float MIN_SCALE_X = 0.5f;
  private static final float MAX_SCALE_X = 1f;

  //betwwen -1 and 1, -1 for top, 0 middle, 1 bottom
  private static final float END_Y_OFFSET = 0f;
  private static final float START_Y_OFFSET = 0.3f;
  private static final float NB_AFFECT = 4f;
  private static final float MAX_ANGLE = 90f;
  Interpolator interpolator = new DecelerateInterpolator();
  int pageWidth = 263;
  int pageHeight = 1050;
  private View viewPager;

  public ZoomOutPageTransformer(View viewPager) {
    this.viewPager = viewPager;
  }

  public void transformPage(View view, float position) {
    float angleFactor;
    float scaleFactor;
    float verticalFactor;
    float margeFactor;

    margeFactor = Math.abs(position) / NB_AFFECT;
    if (position < NB_AFFECT && position > -NB_AFFECT) {

      scaleFactor = (MIN_SCALE_X - MAX_SCALE_X) * interpolator.getInterpolation(Math.abs(position) / NB_AFFECT) + MAX_SCALE_X;
      verticalFactor = (START_Y_OFFSET - END_Y_OFFSET) * interpolator.getInterpolation(Math.abs(position) / NB_AFFECT) + END_Y_OFFSET;

      //float vertMargin = pageHeight * (1 - scaleFactor) / 2;
      //float horzMargin = pageWidth * (1 - scaleFactor) / 2;
      //if (position < 0) {
      //  view.setTranslationX(horzMargin - vertMargin / 2);
      //} else {
      //  view.setTranslationX(-horzMargin + vertMargin / 2);
      //}

    } else {
      angleFactor = 0;
      scaleFactor = MIN_SCALE_X;
      verticalFactor = START_Y_OFFSET;
      margeFactor = 0;
    }
    int sign = position > 0 ? 1 : -1;
    view.setRotationY(MAX_ANGLE * getAngleFactor(position) * sign);

    // Scale the page down (between MIN_SCALE_X and 1)
    view.setScaleX(scaleFactor);
    view.setScaleY(scaleFactor);

    // 4 because the max angle is 90deg and there is only half that need to be compensate
    //ViewCompat.setTranslationX(view, -(pageWidth / 4 * margeFactor) * sign);

    margeFactor = 0;
    for (int i = 1; i < Math.abs(position); i++) {
      margeFactor +=  getAngleFactor(Math.abs(position) - i);
    }
    TextView view1 = (TextView) view;
    view1.setText(margeFactor + "\n p:" + position);
    ViewCompat.setTranslationX(view, -margeFactor * pageWidth / 2 * sign);

    // percentage of the blanc left by the scale resize
    ViewCompat.setTranslationY(view, (pageHeight - scaleFactor * pageHeight) / 2 * verticalFactor);
  }

  private float getAngleFactor(float position) {
    if (Math.abs(position) > NB_AFFECT) {
      return 0;
    }
    float angleFactor;
    angleFactor = interpolator.getInterpolation(Math.abs(position) / NB_AFFECT);
    if (Math.abs(position) > NB_AFFECT / 2) {
      angleFactor = interpolator.getInterpolation(1 - (Math.abs(position) / NB_AFFECT));
    }
    return angleFactor;
  }

  public void transformPageOld(View view, float position) {

    pageWidth = view.getWidth();
    if (position < 0.5 && position > -0.5) {
      view.setTranslationZ(10);
    } else if (position < 1 && position > -1) {
      view.setTranslationZ(5);
    } else {
      view.setTranslationZ(0);
    }

    if (position < NB_AFFECT && position > -NB_AFFECT) { // [-1,1]
      float scaleFactor = (MIN_SCALE_X - MAX_SCALE_X) * interpolator.getInterpolation(Math.abs(position) / NB_AFFECT) + MAX_SCALE_X;

      //float vertMargin = pageHeight * (1 - scaleFactor) / 2;
      //float horzMargin = pageWidth * (1 - scaleFactor) / 2;
      //if (position < 0) {
      //  view.setTranslationX(horzMargin - vertMargin / 2);
      //} else {
      //  view.setTranslationX(-horzMargin + vertMargin / 2);
      //}

      // Scale the page down (between MIN_SCALE_X and 1)
      view.setScaleX(scaleFactor);
      view.setScaleY(scaleFactor);

      //if (position > 0) {
      //  ViewCompat.setTranslationY(view, (pageWidth - pageWidth * scaleFactor));
      //  ViewCompat.setTranslationX(view, -(pageWidth - pageWidth * scaleFactor));
      //} else if (position < 0) {
      //  ViewCompat.setTranslationY(view, (pageWidth - pageWidth * scaleFactor));
      //  ViewCompat.setTranslationX(view, (pageWidth - pageWidth * scaleFactor));
      //}

      float sign = position > 0 ? 1 : -1;

      //ViewCompat.setTranslationX(view, decelerateInterpolator.getInterpolation(Math.abs(position) / NB_AFFECT) * pageWidth / 2 * sign);
      ViewCompat.setTranslationY(view, (pageWidth - pageWidth * scaleFactor));

      view.setRotationY((80 - scaleFactor * 80) * sign);

      //view.getLayoutParams().width = (int) Math.floor(pageWidth * scaleFactor);
      //view.getLayoutParams().height = (int) Math.floor(pageHeight * scaleFactor);
      //view.refreshDrawableState();
      //viewPager.requestLayout();

      // Fade the page relative to its size.
      //view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE_X) / (1 - MIN_SCALE_X) * (1 - MIN_ALPHA));
    } else {
      view.setScaleX(MIN_SCALE_X);
      view.setScaleY(MIN_SCALE_X);

      //view.getLayoutParams().width = (int) Math.floor(pageWidth * MIN_SCALE_X);
      //view.getLayoutParams().height = (int) Math.floor(pageHeight * MIN_SCALE_X);
      //view.refreshDrawableState();
      //viewPager.requestLayout();
    }
  }
}

