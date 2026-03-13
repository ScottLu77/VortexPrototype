package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Segment type in your schema. */
public final class Segment {
  private final String startAt;
  private final String endAt;
  public String getStartAt() {
      return startAt;
  }
  
  public String getEndAt() {
      return endAt;
  }
  
  private Segment(String startAt, String endAt) {
    this.startAt = startAt;
    this.endAt = endAt;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Segment segment = (Segment) obj;
      return ObjectsCompat.equals(getStartAt(), segment.getStartAt()) &&
              ObjectsCompat.equals(getEndAt(), segment.getEndAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getStartAt())
      .append(getEndAt())
      .toString()
      .hashCode();
  }
  
  public static StartAtStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(startAt,
      endAt);
  }
  public interface StartAtStep {
    EndAtStep startAt(String startAt);
  }
  

  public interface EndAtStep {
    BuildStep endAt(String endAt);
  }
  

  public interface BuildStep {
    Segment build();
  }
  

  public static class Builder implements StartAtStep, EndAtStep, BuildStep {
    private String startAt;
    private String endAt;
    public Builder() {
      
    }
    
    private Builder(String startAt, String endAt) {
      this.startAt = startAt;
      this.endAt = endAt;
    }
    
    @Override
     public Segment build() {
        
        return new Segment(
          startAt,
          endAt);
    }
    
    @Override
     public EndAtStep startAt(String startAt) {
        Objects.requireNonNull(startAt);
        this.startAt = startAt;
        return this;
    }
    
    @Override
     public BuildStep endAt(String endAt) {
        Objects.requireNonNull(endAt);
        this.endAt = endAt;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String startAt, String endAt) {
      super(startAt, endAt);
      Objects.requireNonNull(startAt);
      Objects.requireNonNull(endAt);
    }
    
    @Override
     public CopyOfBuilder startAt(String startAt) {
      return (CopyOfBuilder) super.startAt(startAt);
    }
    
    @Override
     public CopyOfBuilder endAt(String endAt) {
      return (CopyOfBuilder) super.endAt(endAt);
    }
  }
  
}
