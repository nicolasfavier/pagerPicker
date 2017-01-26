package com.fav.nico.runyrlate;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
  private static final float MIN_SCALE_X = 0.5f;
  private static final float MAX_SCALE_X = 1f;

  //betwwen -1 and 1, -1 for top, 0 middle, 1 bottom
  private static final float END_Y_OFFSET = -0.4f;
  private static final float START_Y_OFFSET = 1f;
  private static final float NB_AFFECT = 3f;
  private static final float MAX_ANGLE = 90f;
  Interpolator interpolator = new DecelerateInterpolator();
  private View viewPager;

  public ZoomOutPageTransformer(View viewPager) {
    this.viewPager = viewPager;
  }

  public void transformPage(View view, float position) {
    int pageWidth = view.getWidth();
    int pageHeight = view.getHeight();

    float scaleFactor;
    float verticalFactor;
    float margeFactor = 0;

    if (position < NB_AFFECT && position > -NB_AFFECT) {
      scaleFactor = (MIN_SCALE_X - MAX_SCALE_X) * interpolator.getInterpolation(Math.abs(position) / NB_AFFECT) + MAX_SCALE_X;
      verticalFactor = (START_Y_OFFSET - END_Y_OFFSET) * interpolator.getInterpolation(Math.abs(position) / NB_AFFECT) + END_Y_OFFSET;
    } else {
      scaleFactor = MIN_SCALE_X;
      verticalFactor = START_Y_OFFSET;
    }
    int sign = position > 0 ? 1 : -1;
    view.setRotationY(MAX_ANGLE * getAngleFactor(position) * sign);

    // Scale the page down (between MIN_SCALE_X and 1)
    view.setScaleX(scaleFactor);
    view.setScaleY(scaleFactor);

    for (int i = 1; i < Math.abs(position); i++) {
      margeFactor += getAngleFactor(Math.abs(position) - i);
    }

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
}

