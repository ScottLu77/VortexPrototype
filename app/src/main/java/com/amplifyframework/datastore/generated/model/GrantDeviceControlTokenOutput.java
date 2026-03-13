package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GrantDeviceControlTokenOutput type in your schema. */
public final class GrantDeviceControlTokenOutput {
  private final String clientId;
  private final Credential mqttCred;
  public String getClientId() {
      return clientId;
  }
  
  public Credential getMqttCred() {
      return mqttCred;
  }
  
  private GrantDeviceControlTokenOutput(String clientId, Credential mqttCred) {
    this.clientId = clientId;
    this.mqttCred = mqttCred;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GrantDeviceControlTokenOutput grantDeviceControlTokenOutput = (GrantDeviceControlTokenOutput) obj;
      return ObjectsCompat.equals(getClientId(), grantDeviceControlTokenOutput.getClientId()) &&
              ObjectsCompat.equals(getMqttCred(), grantDeviceControlTokenOutput.getMqttCred());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getClientId())
      .append(getMqttCred())
      .toString()
      .hashCode();
  }
  
  public static ClientIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(clientId,
      mqttCred);
  }
  public interface ClientIdStep {
    MqttCredStep clientId(String clientId);
  }
  

  public interface MqttCredStep {
    BuildStep mqttCred(Credential mqttCred);
  }
  

  public interface BuildStep {
    GrantDeviceControlTokenOutput build();
  }
  

  public static class Builder implements ClientIdStep, MqttCredStep, BuildStep {
    private String clientId;
    private Credential mqttCred;
    public Builder() {
      
    }
    
    private Builder(String clientId, Credential mqttCred) {
      this.clientId = clientId;
      this.mqttCred = mqttCred;
    }
    
    @Override
     public GrantDeviceControlTokenOutput build() {
        
        return new GrantDeviceControlTokenOutput(
          clientId,
          mqttCred);
    }
    
    @Override
     public MqttCredStep clientId(String clientId) {
        Objects.requireNonNull(clientId);
        this.clientId = clientId;
        return this;
    }
    
    @Override
     public BuildStep mqttCred(Credential mqttCred) {
        Objects.requireNonNull(mqttCred);
        this.mqttCred = mqttCred;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String clientId, Credential mqttCred) {
      super(clientId, mqttCred);
      Objects.requireNonNull(clientId);
      Objects.requireNonNull(mqttCred);
    }
    
    @Override
     public CopyOfBuilder clientId(String clientId) {
      return (CopyOfBuilder) super.clientId(clientId);
    }
    
    @Override
     public CopyOfBuilder mqttCred(Credential mqttCred) {
      return (CopyOfBuilder) super.mqttCred(mqttCred);
    }
  }
  
}
