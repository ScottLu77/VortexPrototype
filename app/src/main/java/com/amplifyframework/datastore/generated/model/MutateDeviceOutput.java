package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the MutateDeviceOutput type in your schema. */
public final class MutateDeviceOutput {
  private final Boolean res;
  private final List<FailedItem> failedItems;
  public Boolean getRes() {
      return res;
  }
  
  public List<FailedItem> getFailedItems() {
      return failedItems;
  }
  
  private MutateDeviceOutput(Boolean res, List<FailedItem> failedItems) {
    this.res = res;
    this.failedItems = failedItems;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      MutateDeviceOutput mutateDeviceOutput = (MutateDeviceOutput) obj;
      return ObjectsCompat.equals(getRes(), mutateDeviceOutput.getRes()) &&
              ObjectsCompat.equals(getFailedItems(), mutateDeviceOutput.getFailedItems());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getRes())
      .append(getFailedItems())
      .toString()
      .hashCode();
  }
  
  public static ResStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(res,
      failedItems);
  }
  public interface ResStep {
    BuildStep res(Boolean res);
  }
  

  public interface BuildStep {
    MutateDeviceOutput build();
    BuildStep failedItems(List<FailedItem> failedItems);
  }
  

  public static class Builder implements ResStep, BuildStep {
    private Boolean res;
    private List<FailedItem> failedItems;
    public Builder() {
      
    }
    
    private Builder(Boolean res, List<FailedItem> failedItems) {
      this.res = res;
      this.failedItems = failedItems;
    }
    
    @Override
     public MutateDeviceOutput build() {
        
        return new MutateDeviceOutput(
          res,
          failedItems);
    }
    
    @Override
     public BuildStep res(Boolean res) {
        Objects.requireNonNull(res);
        this.res = res;
        return this;
    }
    
    @Override
     public BuildStep failedItems(List<FailedItem> failedItems) {
        this.failedItems = failedItems;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Boolean res, List<FailedItem> failedItems) {
      super(res, failedItems);
      Objects.requireNonNull(res);
    }
    
    @Override
     public CopyOfBuilder res(Boolean res) {
      return (CopyOfBuilder) super.res(res);
    }
    
    @Override
     public CopyOfBuilder failedItems(List<FailedItem> failedItems) {
      return (CopyOfBuilder) super.failedItems(failedItems);
    }
  }
  
}
