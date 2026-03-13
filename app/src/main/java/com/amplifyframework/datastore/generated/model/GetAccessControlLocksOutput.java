package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GetAccessControlLocksOutput type in your schema. */
public final class GetAccessControlLocksOutput {
  private final List<AccessControlLock> items;
  public List<AccessControlLock> getItems() {
      return items;
  }
  
  private GetAccessControlLocksOutput(List<AccessControlLock> items) {
    this.items = items;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GetAccessControlLocksOutput getAccessControlLocksOutput = (GetAccessControlLocksOutput) obj;
      return ObjectsCompat.equals(getItems(), getAccessControlLocksOutput.getItems());
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
    BuildStep items(List<AccessControlLock> items);
  }
  

  public interface BuildStep {
    GetAccessControlLocksOutput build();
  }
  

  public static class Builder implements ItemsStep, BuildStep {
    private List<AccessControlLock> items;
    public Builder() {
      
    }
    
    private Builder(List<AccessControlLock> items) {
      this.items = items;
    }
    
    @Override
     public GetAccessControlLocksOutput build() {
        
        return new GetAccessControlLocksOutput(
          items);
    }
    
    @Override
     public BuildStep items(List<AccessControlLock> items) {
        Objects.requireNonNull(items);
        this.items = items;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<AccessControlLock> items) {
      super(items);
      Objects.requireNonNull(items);
    }
    
    @Override
     public CopyOfBuilder items(List<AccessControlLock> items) {
      return (CopyOfBuilder) super.items(items);
    }
  }
  
}
