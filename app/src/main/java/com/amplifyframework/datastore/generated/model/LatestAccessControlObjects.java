package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the LatestAccessControlObjects type in your schema. */
public final class LatestAccessControlObjects {
  private final List<AccessControlLock> locks;
  private final String error;
  public List<AccessControlLock> getLocks() {
      return locks;
  }
  
  public String getError() {
      return error;
  }
  
  private LatestAccessControlObjects(List<AccessControlLock> locks, String error) {
    this.locks = locks;
    this.error = error;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      LatestAccessControlObjects latestAccessControlObjects = (LatestAccessControlObjects) obj;
      return ObjectsCompat.equals(getLocks(), latestAccessControlObjects.getLocks()) &&
              ObjectsCompat.equals(getError(), latestAccessControlObjects.getError());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getLocks())
      .append(getError())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(locks,
      error);
  }
  public interface BuildStep {
    LatestAccessControlObjects build();
    BuildStep locks(List<AccessControlLock> locks);
    BuildStep error(String error);
  }
  

  public static class Builder implements BuildStep {
    private List<AccessControlLock> locks;
    private String error;
    public Builder() {
      
    }
    
    private Builder(List<AccessControlLock> locks, String error) {
      this.locks = locks;
      this.error = error;
    }
    
    @Override
     public LatestAccessControlObjects build() {
        
        return new LatestAccessControlObjects(
          locks,
          error);
    }
    
    @Override
     public BuildStep locks(List<AccessControlLock> locks) {
        this.locks = locks;
        return this;
    }
    
    @Override
     public BuildStep error(String error) {
        this.error = error;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<AccessControlLock> locks, String error) {
      super(locks, error);
      
    }
    
    @Override
     public CopyOfBuilder locks(List<AccessControlLock> locks) {
      return (CopyOfBuilder) super.locks(locks);
    }
    
    @Override
     public CopyOfBuilder error(String error) {
      return (CopyOfBuilder) super.error(error);
    }
  }
  
}
