package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the AccessControlBindingDevice type in your schema. */
public final class AccessControlBindingDevice {
  private final String thingName;
  private final String derivant;
  public String getThingName() {
      return thingName;
  }
  
  public String getDerivant() {
      return derivant;
  }
  
  private AccessControlBindingDevice(String thingName, String derivant) {
    this.thingName = thingName;
    this.derivant = derivant;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AccessControlBindingDevice accessControlBindingDevice = (AccessControlBindingDevice) obj;
      return ObjectsCompat.equals(getThingName(), accessControlBindingDevice.getThingName()) &&
              ObjectsCompat.equals(getDerivant(), accessControlBindingDevice.getDerivant());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getThingName())
      .append(getDerivant())
      .toString()
      .hashCode();
  }
  
  public static ThingNameStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(thingName,
      derivant);
  }
  public interface ThingNameStep {
    DerivantStep thingName(String thingName);
  }
  

  public interface DerivantStep {
    BuildStep derivant(String derivant);
  }
  

  public interface BuildStep {
    AccessControlBindingDevice build();
  }
  

  public static class Builder implements ThingNameStep, DerivantStep, BuildStep {
    private String thingName;
    private String derivant;
    public Builder() {
      
    }
    
    private Builder(String thingName, String derivant) {
      this.thingName = thingName;
      this.derivant = derivant;
    }
    
    @Override
     public AccessControlBindingDevice build() {
        
        return new AccessControlBindingDevice(
          thingName,
          derivant);
    }
    
    @Override
     public DerivantStep thingName(String thingName) {
        Objects.requireNonNull(thingName);
        this.thingName = thingName;
        return this;
    }
    
    @Override
     public BuildStep derivant(String derivant) {
        Objects.requireNonNull(derivant);
        this.derivant = derivant;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String thingName, String derivant) {
      super(thingName, derivant);
      Objects.requireNonNull(thingName);
      Objects.requireNonNull(derivant);
    }
    
    @Override
     public CopyOfBuilder thingName(String thingName) {
      return (CopyOfBuilder) super.thingName(thingName);
    }
    
    @Override
     public CopyOfBuilder derivant(String derivant) {
      return (CopyOfBuilder) super.derivant(derivant);
    }
  }
  
}
