package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the FailedItem type in your schema. */
public final class FailedItem {
  private final String mac;
  private final String derivant;
  private final String reason;
  public String getMac() {
      return mac;
  }
  
  public String getDerivant() {
      return derivant;
  }
  
  public String getReason() {
      return reason;
  }
  
  private FailedItem(String mac, String derivant, String reason) {
    this.mac = mac;
    this.derivant = derivant;
    this.reason = reason;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      FailedItem failedItem = (FailedItem) obj;
      return ObjectsCompat.equals(getMac(), failedItem.getMac()) &&
              ObjectsCompat.equals(getDerivant(), failedItem.getDerivant()) &&
              ObjectsCompat.equals(getReason(), failedItem.getReason());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getMac())
      .append(getDerivant())
      .append(getReason())
      .toString()
      .hashCode();
  }
  
  public static MacStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(mac,
      derivant,
      reason);
  }
  public interface MacStep {
    DerivantStep mac(String mac);
  }
  

  public interface DerivantStep {
    ReasonStep derivant(String derivant);
  }
  

  public interface ReasonStep {
    BuildStep reason(String reason);
  }
  

  public interface BuildStep {
    FailedItem build();
  }
  

  public static class Builder implements MacStep, DerivantStep, ReasonStep, BuildStep {
    private String mac;
    private String derivant;
    private String reason;
    public Builder() {
      
    }
    
    private Builder(String mac, String derivant, String reason) {
      this.mac = mac;
      this.derivant = derivant;
      this.reason = reason;
    }
    
    @Override
     public FailedItem build() {
        
        return new FailedItem(
          mac,
          derivant,
          reason);
    }
    
    @Override
     public DerivantStep mac(String mac) {
        Objects.requireNonNull(mac);
        this.mac = mac;
        return this;
    }
    
    @Override
     public ReasonStep derivant(String derivant) {
        Objects.requireNonNull(derivant);
        this.derivant = derivant;
        return this;
    }
    
    @Override
     public BuildStep reason(String reason) {
        Objects.requireNonNull(reason);
        this.reason = reason;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String mac, String derivant, String reason) {
      super(mac, derivant, reason);
      Objects.requireNonNull(mac);
      Objects.requireNonNull(derivant);
      Objects.requireNonNull(reason);
    }
    
    @Override
     public CopyOfBuilder mac(String mac) {
      return (CopyOfBuilder) super.mac(mac);
    }
    
    @Override
     public CopyOfBuilder derivant(String derivant) {
      return (CopyOfBuilder) super.derivant(derivant);
    }
    
    @Override
     public CopyOfBuilder reason(String reason) {
      return (CopyOfBuilder) super.reason(reason);
    }
  }
  
}
