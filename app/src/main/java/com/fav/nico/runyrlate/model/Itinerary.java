package com.fav.nico.runyrlate.model;

public class Itinerary {
  private String time;
  private String line;

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public Itinerary(String time, String line) {
    this.time = time;
    this.line = line;
  }
}
