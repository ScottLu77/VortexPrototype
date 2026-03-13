package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Storages type in your schema. */
public final class Storages {
  private final StorageInfo device;
  private final StorageInfo faeLog;
  private final StorageInfo feedback;
  public StorageInfo getDevice() {
      return device;
  }
  
  public StorageInfo getFaeLog() {
      return faeLog;
  }
  
  public StorageInfo getFeedback() {
      return feedback;
  }
  
  private Storages(StorageInfo device, StorageInfo faeLog, StorageInfo feedback) {
    this.device = device;
    this.faeLog = faeLog;
    this.feedback = feedback;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Storages storages = (Storages) obj;
      return ObjectsCompat.equals(getDevice(), storages.getDevice()) &&
              ObjectsCompat.equals(getFaeLog(), storages.getFaeLog()) &&
              ObjectsCompat.equals(getFeedback(), storages.getFeedback());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getDevice())
      .append(getFaeLog())
      .append(getFeedback())
      .toString()
      .hashCode();
  }
  
  public static DeviceStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(device,
      faeLog,
      feedback);
  }
  public interface DeviceStep {
    FaeLogStep device(StorageInfo device);
  }
  

  public interface FaeLogStep {
    FeedbackStep faeLog(StorageInfo faeLog);
  }
  

  public interface FeedbackStep {
    BuildStep feedback(StorageInfo feedback);
  }
  

  public interface BuildStep {
    Storages build();
  }
  

  public static class Builder implements DeviceStep, FaeLogStep, FeedbackStep, BuildStep {
    private StorageInfo device;
    private StorageInfo faeLog;
    private StorageInfo feedback;
    public Builder() {
      
    }
    
    private Builder(StorageInfo device, StorageInfo faeLog, StorageInfo feedback) {
      this.device = device;
      this.faeLog = faeLog;
      this.feedback = feedback;
    }
    
    @Override
     public Storages build() {
        
        return new Storages(
          device,
          faeLog,
          feedback);
    }
    
    @Override
     public FaeLogStep device(StorageInfo device) {
        Objects.requireNonNull(device);
        this.device = device;
        return this;
    }
    
    @Override
     public FeedbackStep faeLog(StorageInfo faeLog) {
        Objects.requireNonNull(faeLog);
        this.faeLog = faeLog;
        return this;
    }
    
    @Override
     public BuildStep feedback(StorageInfo feedback) {
        Objects.requireNonNull(feedback);
        this.feedback = feedback;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(StorageInfo device, StorageInfo faeLog, StorageInfo feedback) {
      super(device, faeLog, feedback);
      Objects.requireNonNull(device);
      Objects.requireNonNull(faeLog);
      Objects.requireNonNull(feedback);
    }
    
    @Override
     public CopyOfBuilder device(StorageInfo device) {
      return (CopyOfBuilder) super.device(device);
    }
    
    @Override
     public CopyOfBuilder faeLog(StorageInfo faeLog) {
      return (CopyOfBuilder) super.faeLog(faeLog);
    }
    
    @Override
     public CopyOfBuilder feedback(StorageInfo feedback) {
      return (CopyOfBuilder) super.feedback(feedback);
    }
  }
  
}
