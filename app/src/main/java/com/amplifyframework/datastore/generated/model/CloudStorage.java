package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the CloudStorage type in your schema. */
public final class CloudStorage {
  private final Location location;
  private final Storages storages;
  public Location getLocation() {
      return location;
  }
  
  public Storages getStorages() {
      return storages;
  }
  
  private CloudStorage(Location location, Storages storages) {
    this.location = location;
    this.storages = storages;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      CloudStorage cloudStorage = (CloudStorage) obj;
      return ObjectsCompat.equals(getLocation(), cloudStorage.getLocation()) &&
              ObjectsCompat.equals(getStorages(), cloudStorage.getStorages());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getLocation())
      .append(getStorages())
      .toString()
      .hashCode();
  }
  
  public static LocationStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(location,
      storages);
  }
  public interface LocationStep {
    StoragesStep location(Location location);
  }
  

  public interface StoragesStep {
    BuildStep storages(Storages storages);
  }
  

  public interface BuildStep {
    CloudStorage build();
  }
  

  public static class Builder implements LocationStep, StoragesStep, BuildStep {
    private Location location;
    private Storages storages;
    public Builder() {
      
    }
    
    private Builder(Location location, Storages storages) {
      this.location = location;
      this.storages = storages;
    }
    
    @Override
     public CloudStorage build() {
        
        return new CloudStorage(
          location,
          storages);
    }
    
    @Override
     public StoragesStep location(Location location) {
        Objects.requireNonNull(location);
        this.location = location;
        return this;
    }
    
    @Override
     public BuildStep storages(Storages storages) {
        Objects.requireNonNull(storages);
        this.storages = storages;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Location location, Storages storages) {
      super(location, storages);
      Objects.requireNonNull(location);
      Objects.requireNonNull(storages);
    }
    
    @Override
     public CopyOfBuilder location(Location location) {
      return (CopyOfBuilder) super.location(location);
    }
    
    @Override
     public CopyOfBuilder storages(Storages storages) {
      return (CopyOfBuilder) super.storages(storages);
    }
  }
  
}
