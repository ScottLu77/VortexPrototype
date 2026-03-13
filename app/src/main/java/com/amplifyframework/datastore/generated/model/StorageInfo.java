package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the StorageInfo type in your schema. */
public final class StorageInfo {
  private final String name;
  private final String region;
  private final String url;
  public String getName() {
      return name;
  }
  
  public String getRegion() {
      return region;
  }
  
  public String getUrl() {
      return url;
  }
  
  private StorageInfo(String name, String region, String url) {
    this.name = name;
    this.region = region;
    this.url = url;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      StorageInfo storageInfo = (StorageInfo) obj;
      return ObjectsCompat.equals(getName(), storageInfo.getName()) &&
              ObjectsCompat.equals(getRegion(), storageInfo.getRegion()) &&
              ObjectsCompat.equals(getUrl(), storageInfo.getUrl());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getName())
      .append(getRegion())
      .append(getUrl())
      .toString()
      .hashCode();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(name,
      region,
      url);
  }
  public interface NameStep {
    RegionStep name(String name);
  }
  

  public interface RegionStep {
    UrlStep region(String region);
  }
  

  public interface UrlStep {
    BuildStep url(String url);
  }
  

  public interface BuildStep {
    StorageInfo build();
  }
  

  public static class Builder implements NameStep, RegionStep, UrlStep, BuildStep {
    private String name;
    private String region;
    private String url;
    public Builder() {
      
    }
    
    private Builder(String name, String region, String url) {
      this.name = name;
      this.region = region;
      this.url = url;
    }
    
    @Override
     public StorageInfo build() {
        
        return new StorageInfo(
          name,
          region,
          url);
    }
    
    @Override
     public RegionStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public UrlStep region(String region) {
        Objects.requireNonNull(region);
        this.region = region;
        return this;
    }
    
    @Override
     public BuildStep url(String url) {
        Objects.requireNonNull(url);
        this.url = url;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String name, String region, String url) {
      super(name, region, url);
      Objects.requireNonNull(name);
      Objects.requireNonNull(region);
      Objects.requireNonNull(url);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder region(String region) {
      return (CopyOfBuilder) super.region(region);
    }
    
    @Override
     public CopyOfBuilder url(String url) {
      return (CopyOfBuilder) super.url(url);
    }
  }
  
}
