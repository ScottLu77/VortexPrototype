package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GrantTokenOutput type in your schema. */
public final class GrantTokenOutput {
  private final Credential credential;
  private final List<DeviceCompositeType> deviceList;
  public Credential getCredential() {
      return credential;
  }
  
  public List<DeviceCompositeType> getDeviceList() {
      return deviceList;
  }
  
  private GrantTokenOutput(Credential credential, List<DeviceCompositeType> deviceList) {
    this.credential = credential;
    this.deviceList = deviceList;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GrantTokenOutput grantTokenOutput = (GrantTokenOutput) obj;
      return ObjectsCompat.equals(getCredential(), grantTokenOutput.getCredential()) &&
              ObjectsCompat.equals(getDeviceList(), grantTokenOutput.getDeviceList());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getCredential())
      .append(getDeviceList())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(credential,
      deviceList);
  }
  public interface BuildStep {
    GrantTokenOutput build();
    BuildStep credential(Credential credential);
    BuildStep deviceList(List<DeviceCompositeType> deviceList);
  }
  

  public static class Builder implements BuildStep {
    private Credential credential;
    private List<DeviceCompositeType> deviceList;
    public Builder() {
      
    }
    
    private Builder(Credential credential, List<DeviceCompositeType> deviceList) {
      this.credential = credential;
      this.deviceList = deviceList;
    }
    
    @Override
     public GrantTokenOutput build() {
        
        return new GrantTokenOutput(
          credential,
          deviceList);
    }
    
    @Override
     public BuildStep credential(Credential credential) {
        this.credential = credential;
        return this;
    }
    
    @Override
     public BuildStep deviceList(List<DeviceCompositeType> deviceList) {
        this.deviceList = deviceList;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Credential credential, List<DeviceCompositeType> deviceList) {
      super(credential, deviceList);
      
    }
    
    @Override
     public CopyOfBuilder credential(Credential credential) {
      return (CopyOfBuilder) super.credential(credential);
    }
    
    @Override
     public CopyOfBuilder deviceList(List<DeviceCompositeType> deviceList) {
      return (CopyOfBuilder) super.deviceList(deviceList);
    }
  }
  
}
