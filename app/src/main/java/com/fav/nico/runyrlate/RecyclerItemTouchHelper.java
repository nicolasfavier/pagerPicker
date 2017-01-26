package com.fav.nico.runyrlate;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {
  private ItineraryAdapter itineraryAdapter;

  public RecyclerItemTouchHelper(ItineraryAdapter adapter) {
    super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
    itineraryAdapter = adapter;
  }

  @Override public boolean onMove(final RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
    itineraryAdapter.onMove(recyclerView, viewHolder.getAdapterPosition(), target.getAdapterPosition());
    return true;
  }

  @Override public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
  }
}