package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Timeline type in your schema. */
public final class Timeline {
  private final String thingName;
  private final String date;
  private final List<Segment> segments;
  private final String id;
  public String getThingName() {
      return thingName;
  }
  
  public String getDate() {
      return date;
  }
  
  public List<Segment> getSegments() {
      return segments;
  }
  
  public String getId() {
      return id;
  }
  
  private Timeline(String thingName, String date, List<Segment> segments, String id) {
    this.thingName = thingName;
    this.date = date;
    this.segments = segments;
    this.id = id;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Timeline timeline = (Timeline) obj;
      return ObjectsCompat.equals(getThingName(), timeline.getThingName()) &&
              ObjectsCompat.equals(getDate(), timeline.getDate()) &&
              ObjectsCompat.equals(getSegments(), timeline.getSegments()) &&
              ObjectsCompat.equals(getId(), timeline.getId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getThingName())
      .append(getDate())
      .append(getSegments())
      .append(getId())
      .toString()
      .hashCode();
  }
  
  public static ThingNameStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(thingName,
      date,
      segments,
      id);
  }
  public interface ThingNameStep {
    DateStep thingName(String thingName);
  }
  

  public interface DateStep {
    BuildStep date(String date);
  }
  

  public interface BuildStep {
    Timeline build();
    BuildStep segments(List<Segment> segments);
    BuildStep id(String id);
  }
  

  public static class Builder implements ThingNameStep, DateStep, BuildStep {
    private String thingName;
    private String date;
    private List<Segment> segments;
    private String id;
    public Builder() {
      
    }
    
    private Builder(String thingName, String date, List<Segment> segments, String id) {
      this.thingName = thingName;
      this.date = date;
      this.segments = segments;
      this.id = id;
    }
    
    @Override
     public Timeline build() {
        
        return new Timeline(
          thingName,
          date,
          segments,
          id);
    }
    
    @Override
     public DateStep thingName(String thingName) {
        Objects.requireNonNull(thingName);
        this.thingName = thingName;
        return this;
    }
    
    @Override
     public BuildStep date(String date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep segments(List<Segment> segments) {
        this.segments = segments;
        return this;
    }
    
    @Override
     public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String thingName, String date, List<Segment> segments, String id) {
      super(thingName, date, segments, id);
      Objects.requireNonNull(thingName);
      Objects.requireNonNull(date);
    }
    
    @Override
     public CopyOfBuilder thingName(String thingName) {
      return (CopyOfBuilder) super.thingName(thingName);
    }
    
    @Override
     public CopyOfBuilder date(String date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder segments(List<Segment> segments) {
      return (CopyOfBuilder) super.segments(segments);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
  }
  
}
