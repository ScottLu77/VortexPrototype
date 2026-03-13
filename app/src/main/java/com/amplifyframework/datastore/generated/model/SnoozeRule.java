package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the SnoozeRule type in your schema. */
public final class SnoozeRule {
  private final String id;
  private final DeviceCompositeType device;
  private final String messageTypeID;
  private final String eventType;
  private final String ruleName;
  private final SnoozeFor snoozeFor;
  private final String snoozeUntil;
  private final String editorEmail;
  public String getId() {
      return id;
  }
  
  public DeviceCompositeType getDevice() {
      return device;
  }
  
  public String getMessageTypeId() {
      return messageTypeID;
  }
  
  public String getEventType() {
      return eventType;
  }
  
  public String getRuleName() {
      return ruleName;
  }
  
  public SnoozeFor getSnoozeFor() {
      return snoozeFor;
  }
  
  public String getSnoozeUntil() {
      return snoozeUntil;
  }
  
  public String getEditorEmail() {
      return editorEmail;
  }
  
  private SnoozeRule(String id, DeviceCompositeType device, String messageTypeID, String eventType, String ruleName, SnoozeFor snoozeFor, String snoozeUntil, String editorEmail) {
    this.id = id;
    this.device = device;
    this.messageTypeID = messageTypeID;
    this.eventType = eventType;
    this.ruleName = ruleName;
    this.snoozeFor = snoozeFor;
    this.snoozeUntil = snoozeUntil;
    this.editorEmail = editorEmail;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SnoozeRule snoozeRule = (SnoozeRule) obj;
      return ObjectsCompat.equals(getId(), snoozeRule.getId()) &&
              ObjectsCompat.equals(getDevice(), snoozeRule.getDevice()) &&
              ObjectsCompat.equals(getMessageTypeId(), snoozeRule.getMessageTypeId()) &&
              ObjectsCompat.equals(getEventType(), snoozeRule.getEventType()) &&
              ObjectsCompat.equals(getRuleName(), snoozeRule.getRuleName()) &&
              ObjectsCompat.equals(getSnoozeFor(), snoozeRule.getSnoozeFor()) &&
              ObjectsCompat.equals(getSnoozeUntil(), snoozeRule.getSnoozeUntil()) &&
              ObjectsCompat.equals(getEditorEmail(), snoozeRule.getEditorEmail());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDevice())
      .append(getMessageTypeId())
      .append(getEventType())
      .append(getRuleName())
      .append(getSnoozeFor())
      .append(getSnoozeUntil())
      .append(getEditorEmail())
      .toString()
      .hashCode();
  }
  
  public static IdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      device,
      messageTypeID,
      eventType,
      ruleName,
      snoozeFor,
      snoozeUntil,
      editorEmail);
  }
  public interface IdStep {
    DeviceStep id(String id);
  }
  

  public interface DeviceStep {
    MessageTypeIdStep device(DeviceCompositeType device);
  }
  

  public interface MessageTypeIdStep {
    EventTypeStep messageTypeId(String messageTypeId);
  }
  

  public interface EventTypeStep {
    SnoozeForStep eventType(String eventType);
  }
  

  public interface SnoozeForStep {
    SnoozeUntilStep snoozeFor(SnoozeFor snoozeFor);
  }
  

  public interface SnoozeUntilStep {
    BuildStep snoozeUntil(String snoozeUntil);
  }
  

  public interface BuildStep {
    SnoozeRule build();
    BuildStep ruleName(String ruleName);
    BuildStep editorEmail(String editorEmail);
  }
  

  public static class Builder implements IdStep, DeviceStep, MessageTypeIdStep, EventTypeStep, SnoozeForStep, SnoozeUntilStep, BuildStep {
    private String id;
    private DeviceCompositeType device;
    private String messageTypeID;
    private String eventType;
    private SnoozeFor snoozeFor;
    private String snoozeUntil;
    private String ruleName;
    private String editorEmail;
    public Builder() {
      
    }
    
    private Builder(String id, DeviceCompositeType device, String messageTypeID, String eventType, String ruleName, SnoozeFor snoozeFor, String snoozeUntil, String editorEmail) {
      this.id = id;
      this.device = device;
      this.messageTypeID = messageTypeID;
      this.eventType = eventType;
      this.ruleName = ruleName;
      this.snoozeFor = snoozeFor;
      this.snoozeUntil = snoozeUntil;
      this.editorEmail = editorEmail;
    }
    
    @Override
     public SnoozeRule build() {
        
        return new SnoozeRule(
          id,
          device,
          messageTypeID,
          eventType,
          ruleName,
          snoozeFor,
          snoozeUntil,
          editorEmail);
    }
    
    @Override
     public DeviceStep id(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }
    
    @Override
     public MessageTypeIdStep device(DeviceCompositeType device) {
        Objects.requireNonNull(device);
        this.device = device;
        return this;
    }
    
    @Override
     public EventTypeStep messageTypeId(String messageTypeId) {
        Objects.requireNonNull(messageTypeId);
        this.messageTypeID = messageTypeId;
        return this;
    }
    
    @Override
     public SnoozeForStep eventType(String eventType) {
        Objects.requireNonNull(eventType);
        this.eventType = eventType;
        return this;
    }
    
    @Override
     public SnoozeUntilStep snoozeFor(SnoozeFor snoozeFor) {
        Objects.requireNonNull(snoozeFor);
        this.snoozeFor = snoozeFor;
        return this;
    }
    
    @Override
     public BuildStep snoozeUntil(String snoozeUntil) {
        Objects.requireNonNull(snoozeUntil);
        this.snoozeUntil = snoozeUntil;
        return this;
    }
    
    @Override
     public BuildStep ruleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }
    
    @Override
     public BuildStep editorEmail(String editorEmail) {
        this.editorEmail = editorEmail;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, DeviceCompositeType device, String messageTypeId, String eventType, String ruleName, SnoozeFor snoozeFor, String snoozeUntil, String editorEmail) {
      super(id, device, messageTypeID, eventType, ruleName, snoozeFor, snoozeUntil, editorEmail);
      Objects.requireNonNull(id);
      Objects.requireNonNull(device);
      Objects.requireNonNull(messageTypeID);
      Objects.requireNonNull(eventType);
      Objects.requireNonNull(snoozeFor);
      Objects.requireNonNull(snoozeUntil);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
    
    @Override
     public CopyOfBuilder device(DeviceCompositeType device) {
      return (CopyOfBuilder) super.device(device);
    }
    
    @Override
     public CopyOfBuilder messageTypeId(String messageTypeId) {
      return (CopyOfBuilder) super.messageTypeId(messageTypeId);
    }
    
    @Override
     public CopyOfBuilder eventType(String eventType) {
      return (CopyOfBuilder) super.eventType(eventType);
    }
    
    @Override
     public CopyOfBuilder snoozeFor(SnoozeFor snoozeFor) {
      return (CopyOfBuilder) super.snoozeFor(snoozeFor);
    }
    
    @Override
     public CopyOfBuilder snoozeUntil(String snoozeUntil) {
      return (CopyOfBuilder) super.snoozeUntil(snoozeUntil);
    }
    
    @Override
     public CopyOfBuilder ruleName(String ruleName) {
      return (CopyOfBuilder) super.ruleName(ruleName);
    }
    
    @Override
     public CopyOfBuilder editorEmail(String editorEmail) {
      return (CopyOfBuilder) super.editorEmail(editorEmail);
    }
  }
  
}
