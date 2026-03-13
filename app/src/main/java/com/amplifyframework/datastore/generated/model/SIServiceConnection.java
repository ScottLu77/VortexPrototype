package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the SIServiceConnection type in your schema. */
public final class SIServiceConnection {
  private final List<SIService> items;
  public List<SIService> getItems() {
      return items;
  }
  
  private SIServiceConnection(List<SIService> items) {
    this.items = items;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SIServiceConnection siServiceConnection = (SIServiceConnection) obj;
      return ObjectsCompat.equals(getItems(), siServiceConnection.getItems());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getItems())
      .toString()
      .hashCode();
  }
  
  public static ItemsStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(items);
  }
  public interface ItemsStep {
    BuildStep items(List<SIService> items);
  }
  

  public interface BuildStep {
    SIServiceConnection build();
  }
  

  public static class Builder implements ItemsStep, BuildStep {
    private List<SIService> items;
    public Builder() {
      
    }
    
    private Builder(List<SIService> items) {
      this.items = items;
    }
    
    @Override
     public SIServiceConnection build() {
        
        return new SIServiceConnection(
          items);
    }
    
    @Override
     public BuildStep items(List<SIService> items) {
        Objects.requireNonNull(items);
        this.items = items;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<SIService> items) {
      super(items);
      Objects.requireNonNull(items);
    }
    
    @Override
     public CopyOfBuilder items(List<SIService> items) {
      return (CopyOfBuilder) super.items(items);
    }
  }
  
}
