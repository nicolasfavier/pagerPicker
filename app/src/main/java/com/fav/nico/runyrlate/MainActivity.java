package com.fav.nico.runyrlate;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.fav.nico.runyrlate.model.Itinerary;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  //@BindView(R.id.itinerary) RecyclerView itineraryRV;
  //@BindView(R.id.itinerary) RecyclerView itineraryRV;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //ButterKnife.bind(this);

    List<Itinerary> itineraries = new ArrayList<>();
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));
    itineraries.add(new Itinerary("5min", "RER B"));
    itineraries.add(new Itinerary("11min", "RER B"));
    itineraries.add(new Itinerary("12min", "187"));
    itineraries.add(new Itinerary("13min", "RER B"));

    //ItineraryAdapter itineraryAdapter = new ItineraryAdapter(this);
    //ItemTouchHelper.Callback callback = new RecyclerItemTouchHelper(itineraryAdapter);
    //ItemTouchHelper helper = new ItemTouchHelper(callback);
    //helper.attachToRecyclerView(itineraryRV);
    //itineraryRV.setAdapter(itineraryAdapter);
    //LinearLayoutManager linearLayoutManagerSubCategories = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    //itineraryRV.setLayoutManager(linearLayoutManagerSubCategories);
    //itineraryAdapter.setItineraries(itineraries);

    PagerContainer mContainer = (PagerContainer) findViewById(R.id.pager_container);

    ViewPager pager = mContainer.getViewPager();
    PagerAdapter adapter = new MyPagerAdapter(this);
    pager.setAdapter(adapter);
    //Necessary or the pager will only have one extra page to show
    // make this at least however many pages you cathisn see
    pager.setOffscreenPageLimit(adapter.getCount());
    //A little space between pages
    pager.setPageTransformer(true, new ZoomOutPageTransformer(pager));

    //If hardware acceleration is enabled, you should also remove
    // clipping on the pager for its children.
    pager.setClipChildren(false);
  }
}
