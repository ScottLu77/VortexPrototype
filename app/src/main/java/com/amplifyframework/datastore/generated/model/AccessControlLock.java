package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the AccessControlLock type in your schema. */
public final class AccessControlLock {
  private final String lockId;
  private final AccessControlObjectType lockType;
  private final String lockName;
  private final AccessControlLockStatus lockStatus;
  public String getLockId() {
      return lockId;
  }
  
  public AccessControlObjectType getLockType() {
      return lockType;
  }
  
  public String getLockName() {
      return lockName;
  }
  
  public AccessControlLockStatus getLockStatus() {
      return lockStatus;
  }
  
  private AccessControlLock(String lockId, AccessControlObjectType lockType, String lockName, AccessControlLockStatus lockStatus) {
    this.lockId = lockId;
    this.lockType = lockType;
    this.lockName = lockName;
    this.lockStatus = lockStatus;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AccessControlLock accessControlLock = (AccessControlLock) obj;
      return ObjectsCompat.equals(getLockId(), accessControlLock.getLockId()) &&
              ObjectsCompat.equals(getLockType(), accessControlLock.getLockType()) &&
              ObjectsCompat.equals(getLockName(), accessControlLock.getLockName()) &&
              ObjectsCompat.equals(getLockStatus(), accessControlLock.getLockStatus());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getLockId())
      .append(getLockType())
      .append(getLockName())
      .append(getLockStatus())
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
      lockStatus);
  }
  public interface LockIdStep {
    LockTypeStep lockId(String lockId);
  }
  

  public interface LockTypeStep {
    LockNameStep lockType(AccessControlObjectType lockType);
  }
  

  public interface LockNameStep {
    LockStatusStep lockName(String lockName);
  }
  

  public interface LockStatusStep {
    BuildStep lockStatus(AccessControlLockStatus lockStatus);
  }
  

  public interface BuildStep {
    AccessControlLock build();
  }
  

  public static class Builder implements LockIdStep, LockTypeStep, LockNameStep, LockStatusStep, BuildStep {
    private String lockId;
    private AccessControlObjectType lockType;
    private String lockName;
    private AccessControlLockStatus lockStatus;
    public Builder() {
      
    }
    
    private Builder(String lockId, AccessControlObjectType lockType, String lockName, AccessControlLockStatus lockStatus) {
      this.lockId = lockId;
      this.lockType = lockType;
      this.lockName = lockName;
      this.lockStatus = lockStatus;
    }
    
    @Override
     public AccessControlLock build() {
        
        return new AccessControlLock(
          lockId,
          lockType,
          lockName,
          lockStatus);
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
     public LockStatusStep lockName(String lockName) {
        Objects.requireNonNull(lockName);
        this.lockName = lockName;
        return this;
    }
    
    @Override
     public BuildStep lockStatus(AccessControlLockStatus lockStatus) {
        Objects.requireNonNull(lockStatus);
        this.lockStatus = lockStatus;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String lockId, AccessControlObjectType lockType, String lockName, AccessControlLockStatus lockStatus) {
      super(lockId, lockType, lockName, lockStatus);
      Objects.requireNonNull(lockId);
      Objects.requireNonNull(lockType);
      Objects.requireNonNull(lockName);
      Objects.requireNonNull(lockStatus);
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
     public CopyOfBuilder lockStatus(AccessControlLockStatus lockStatus) {
      return (CopyOfBuilder) super.lockStatus(lockStatus);
    }
  }
  
}
