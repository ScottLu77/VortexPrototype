package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the AccessControlBinding type in your schema. */
public final class AccessControlBinding {
  private final String lockId;
  private final AccessControlObjectType lockType;
  private final String lockName;
  private final List<AccessControlBindingDevice> devices;
  public String getLockId() {
      return lockId;
  }
  
  public AccessControlObjectType getLockType() {
      return lockType;
  }
  
  public String getLockName() {
      return lockName;
  }
  
  public List<AccessControlBindingDevice> getDevices() {
      return devices;
  }
  
  private AccessControlBinding(String lockId, AccessControlObjectType lockType, String lockName, List<AccessControlBindingDevice> devices) {
    this.lockId = lockId;
    this.lockType = lockType;
    this.lockName = lockName;
    this.devices = devices;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AccessControlBinding accessControlBinding = (AccessControlBinding) obj;
      return ObjectsCompat.equals(getLockId(), accessControlBinding.getLockId()) &&
              ObjectsCompat.equals(getLockType(), accessControlBinding.getLockType()) &&
              ObjectsCompat.equals(getLockName(), accessControlBinding.getLockName()) &&
              ObjectsCompat.equals(getDevices(), accessControlBinding.getDevices());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getLockId())
      .append(getLockType())
      .append(getLockName())
      .append(getDevices())
      .toString()
      .hashCode();
  }
  
  public static LockIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(lockId,
      lockType,
      lockName,
      devices);
  }
  public interface LockIdStep {
    LockTypeStep lockId(String lockId);
  }
  

  public interface LockTypeStep {
    LockNameStep lockType(AccessControlObjectType lockType);
  }
  

  public interface LockNameStep {
    DevicesStep lockName(String lockName);
  }
  

  public interface DevicesStep {
    BuildStep devices(List<AccessControlBindingDevice> devices);
  }
  

  public interface BuildStep {
    AccessControlBinding build();
  }
  

  public static class Builder implements LockIdStep, LockTypeStep, LockNameStep, DevicesStep, BuildStep {
    private String lockId;
    private AccessControlObjectType lockType;
    private String lockName;
    private List<AccessControlBindingDevice> devices;
    public Builder() {
      
    }
    
    private Builder(String lockId, AccessControlObjectType lockType, String lockName, List<AccessControlBindingDevice> devices) {
      this.lockId = lockId;
      this.lockType = lockType;
      this.lockName = lockName;
      this.devices = devices;
    }
    
    @Override
     public AccessControlBinding build() {
        
        return new AccessControlBinding(
          lockId,
          lockType,
          lockName,
          devices);
    }
    
    @Override
     public LockTypeStep lockId(String lockId) {
        Objects.requireNonNull(lockId);
        this.lockId = lockId;
        return this;
    }
    
    @Override
     public LockNameStep lockType(AccessControlObjectType lockType) {
        Objects.requireNonNull(lockType);
        this.lockType = lockType;
        return this;
    }
    
    @Override
     public DevicesStep lockName(String lockName) {
        Objects.requireNonNull(lockName);
        this.lockName = lockName;
        return this;
    }
    
    @Override
     public BuildStep devices(List<AccessControlBindingDevice> devices) {
        Objects.requireNonNull(devices);
        this.devices = devices;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String lockId, AccessControlObjectType lockType, String lockName, List<AccessControlBindingDevice> devices) {
      super(lockId, lockType, lockName, devices);
      Objects.requireNonNull(lockId);
      Objects.requireNonNull(lockType);
      Objects.requireNonNull(lockName);
      Objects.requireNonNull(devices);
    }
    
    @Override
     public CopyOfBuilder lockId(String lockId) {
      return (CopyOfBuilder) super.lockId(lockId);
    }
    
    @Override
     public CopyOfBuilder lockType(AccessControlObjectType lockType) {
      return (CopyOfBuilder) super.lockType(lockType);
    }
    
    @Override
     public CopyOfBuilder lockName(String lockName) {
      return (CopyOfBuilder) super.lockName(lockName);
    }
    
    @Override
     public CopyOfBuilder devices(List<AccessControlBindingDevice> devices) {
      return (CopyOfBuilder) super.devices(devices);
    }
  }
  
}
