package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the CurrentAccessControlBinding type in your schema. */
public final class CurrentAccessControlBinding {
  private final List<AccessControlBinding> locks;
  private final String error;
  public List<AccessControlBinding> getLocks() {
      return locks;
  }
  
  public String getError() {
      return error;
  }
  
  private CurrentAccessControlBinding(List<AccessControlBinding> locks, String error) {
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
      CurrentAccessControlBinding currentAccessControlBinding = (CurrentAccessControlBinding) obj;
      return ObjectsCompat.equals(getLocks(), currentAccessControlBinding.getLocks()) &&
              ObjectsCompat.equals(getError(), currentAccessControlBinding.getError());
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
    CurrentAccessControlBinding build();
    BuildStep locks(List<AccessControlBinding> locks);
    BuildStep error(String error);
  }
  

  public static class Builder implements BuildStep {
    private List<AccessControlBinding> locks;
    private String error;
    public Builder() {
      
    }
    
    private Builder(List<AccessControlBinding> locks, String error) {
      this.locks = locks;
      this.error = error;
    }
    
    @Override
     public CurrentAccessControlBinding build() {
        
        return new CurrentAccessControlBinding(
          locks,
          error);
    }
    
    @Override
     public BuildStep locks(List<AccessControlBinding> locks) {
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
    private CopyOfBuilder(List<AccessControlBinding> locks, String error) {
      super(locks, error);
      
    }
    
    @Override
     public CopyOfBuilder locks(List<AccessControlBinding> locks) {
      return (CopyOfBuilder) super.locks(locks);
    }
    
    @Override
     public CopyOfBuilder error(String error) {
      return (CopyOfBuilder) super.error(error);
    }
  }
  
}
