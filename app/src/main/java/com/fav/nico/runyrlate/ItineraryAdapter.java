package com.fav.nico.runyrlate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.fav.nico.runyrlate.model.Itinerary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItineraryAdapter extends RecyclerView.Adapter<ItineraryAdapter.ItineraryViewHolder> {

  private List<Itinerary> itineraries;
  private Context context;
  private int lastPosition = -1;

  public ItineraryAdapter(Context context) {
    this.itineraries = new ArrayList<>();
    this.context = context;
  }

  @Override
  public void onViewDetachedFromWindow(ItineraryViewHolder holder) {
    super.onViewDetachedFromWindow(holder);
    holder.itemView.clearAnimation();
  }

  @Override public ItineraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_itinary, parent, false);
    return new ItineraryViewHolder(view);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public void onBindViewHolder(final ItineraryViewHolder holder, int position) {
    final Itinerary itinerary = itineraries.get(position);
    holder.line.setText(itinerary.getLine());
    holder.time.setText(itinerary.getTime());
    Animation animation = AnimationUtils.loadAnimation(context,
        (position > lastPosition) ? R.anim.up_from_bottom
            : R.anim.down_from_top);
    holder.itemView.startAnimation(animation);
    lastPosition = position;
  }

  @Override public int getItemCount() {
    return itineraries.size();
  }

  public void setItineraries(Collection<Itinerary> itineraries) {
    this.itineraries.clear();
    this.itineraries.addAll(itineraries);
    notifyDataSetChanged();
  }

  public void onMove(RecyclerView recyclerView, int firstPos, int secondPos) {
        /*Do your stuff what you want
          Notify your adapter about change in positions using notifyItemMoved method
          Shift element e.g. insertion sort*/
  }

  public class ItineraryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.time) TextView time;
    @BindView(R.id.line) TextView line;

    public ItineraryViewHolder(final View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
