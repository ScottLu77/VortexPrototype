package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the AccessControlWebhookEvent type in your schema. */
public final class AccessControlWebhookEvent {
  private final String id;
  private final String integrationId;
  private final String eventId;
  private final AccessControlEventType eventType;
  private final String providerEventType;
  private final String actorId;
  private final String actorName;
  private final String actorEmail;
  private final AccessControlObjectType objectType;
  private final String objectId;
  private final String objectName;
  private final String createdTime;
  private final Long createdTimestamp;
  private final Long offset;
  private final List<AccessControlBindingDevice> bindingDevices;
  public String getId() {
      return id;
  }
  
  public String getIntegrationId() {
      return integrationId;
  }
  
  public String getEventId() {
      return eventId;
  }
  
  public AccessControlEventType getEventType() {
      return eventType;
  }
  
  public String getProviderEventType() {
      return providerEventType;
  }
  
  public String getActorId() {
      return actorId;
  }
  
  public String getActorName() {
      return actorName;
  }
  
  public String getActorEmail() {
      return actorEmail;
  }
  
  public AccessControlObjectType getObjectType() {
      return objectType;
  }
  
  public String getObjectId() {
      return objectId;
  }
  
  public String getObjectName() {
      return objectName;
  }
  
  public String getCreatedTime() {
      return createdTime;
  }
  
  public Long getCreatedTimestamp() {
      return createdTimestamp;
  }
  
  public Long getOffset() {
      return offset;
  }
  
  public List<AccessControlBindingDevice> getBindingDevices() {
      return bindingDevices;
  }
  
  private AccessControlWebhookEvent(String id, String integrationId, String eventId, AccessControlEventType eventType, String providerEventType, String actorId, String actorName, String actorEmail, AccessControlObjectType objectType, String objectId, String objectName, String createdTime, Long createdTimestamp, Long offset, List<AccessControlBindingDevice> bindingDevices) {
    this.id = id;
    this.integrationId = integrationId;
    this.eventId = eventId;
    this.eventType = eventType;
    this.providerEventType = providerEventType;
    this.actorId = actorId;
    this.actorName = actorName;
    this.actorEmail = actorEmail;
    this.objectType = objectType;
    this.objectId = objectId;
    this.objectName = objectName;
    this.createdTime = createdTime;
    this.createdTimestamp = createdTimestamp;
    this.offset = offset;
    this.bindingDevices = bindingDevices;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AccessControlWebhookEvent accessControlWebhookEvent = (AccessControlWebhookEvent) obj;
      return ObjectsCompat.equals(getId(), accessControlWebhookEvent.getId()) &&
              ObjectsCompat.equals(getIntegrationId(), accessControlWebhookEvent.getIntegrationId()) &&
              ObjectsCompat.equals(getEventId(), accessControlWebhookEvent.getEventId()) &&
              ObjectsCompat.equals(getEventType(), accessControlWebhookEvent.getEventType()) &&
              ObjectsCompat.equals(getProviderEventType(), accessControlWebhookEvent.getProviderEventType()) &&
              ObjectsCompat.equals(getActorId(), accessControlWebhookEvent.getActorId()) &&
              ObjectsCompat.equals(getActorName(), accessControlWebhookEvent.getActorName()) &&
              ObjectsCompat.equals(getActorEmail(), accessControlWebhookEvent.getActorEmail()) &&
              ObjectsCompat.equals(getObjectType(), accessControlWebhookEvent.getObjectType()) &&
              ObjectsCompat.equals(getObjectId(), accessControlWebhookEvent.getObjectId()) &&
              ObjectsCompat.equals(getObjectName(), accessControlWebhookEvent.getObjectName()) &&
              ObjectsCompat.equals(getCreatedTime(), accessControlWebhookEvent.getCreatedTime()) &&
              ObjectsCompat.equals(getCreatedTimestamp(), accessControlWebhookEvent.getCreatedTimestamp()) &&
              ObjectsCompat.equals(getOffset(), accessControlWebhookEvent.getOffset()) &&
              ObjectsCompat.equals(getBindingDevices(), accessControlWebhookEvent.getBindingDevices());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getIntegrationId())
      .append(getEventId())
      .append(getEventType())
      .append(getProviderEventType())
      .append(getActorId())
      .append(getActorName())
      .append(getActorEmail())
      .append(getObjectType())
      .append(getObjectId())
      .append(getObjectName())
      .append(getCreatedTime())
      .append(getCreatedTimestamp())
      .append(getOffset())
      .append(getBindingDevices())
      .toString()
      .hashCode();
  }
  
  public static IdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      integrationId,
      eventId,
      eventType,
      providerEventType,
      actorId,
      actorName,
      actorEmail,
      objectType,
      objectId,
      objectName,
      createdTime,
      createdTimestamp,
      offset,
      bindingDevices);
  }
  public interface IdStep {
    IntegrationIdStep id(String id);
  }
  

  public interface IntegrationIdStep {
    BindingDevicesStep integrationId(String integrationId);
  }
  

  public interface BindingDevicesStep {
    BuildStep bindingDevices(List<AccessControlBindingDevice> bindingDevices);
  }
  

  public interface BuildStep {
    AccessControlWebhookEvent build();
    BuildStep eventId(String eventId);
    BuildStep eventType(AccessControlEventType eventType);
    BuildStep providerEventType(String providerEventType);
    BuildStep actorId(String actorId);
    BuildStep actorName(String actorName);
    BuildStep actorEmail(String actorEmail);
    BuildStep objectType(AccessControlObjectType objectType);
    BuildStep objectId(String objectId);
    BuildStep objectName(String objectName);
    BuildStep createdTime(String createdTime);
    BuildStep createdTimestamp(Long createdTimestamp);
    BuildStep offset(Long offset);
  }
  

  public static class Builder implements IdStep, IntegrationIdStep, BindingDevicesStep, BuildStep {
    private String id;
    private String integrationId;
    private List<AccessControlBindingDevice> bindingDevices;
    private String eventId;
    private AccessControlEventType eventType;
    private String providerEventType;
    private String actorId;
    private String actorName;
    private String actorEmail;
    private AccessControlObjectType objectType;
    private String objectId;
    private String objectName;
    private String createdTime;
    private Long createdTimestamp;
    private Long offset;
    public Builder() {
      
    }
    
    private Builder(String id, String integrationId, String eventId, AccessControlEventType eventType, String providerEventType, String actorId, String actorName, String actorEmail, AccessControlObjectType objectType, String objectId, String objectName, String createdTime, Long createdTimestamp, Long offset, List<AccessControlBindingDevice> bindingDevices) {
      this.id = id;
      this.integrationId = integrationId;
      this.eventId = eventId;
      this.eventType = eventType;
      this.providerEventType = providerEventType;
      this.actorId = actorId;
      this.actorName = actorName;
      this.actorEmail = actorEmail;
      this.objectType = objectType;
      this.objectId = objectId;
      this.objectName = objectName;
      this.createdTime = createdTime;
      this.createdTimestamp = createdTimestamp;
      this.offset = offset;
      this.bindingDevices = bindingDevices;
    }
    
    @Override
     public AccessControlWebhookEvent build() {
        
        return new AccessControlWebhookEvent(
          id,
          integrationId,
          eventId,
          eventType,
          providerEventType,
          actorId,
          actorName,
          actorEmail,
          objectType,
          objectId,
          objectName,
          createdTime,
          createdTimestamp,
          offset,
          bindingDevices);
    }
    
    @Override
     public IntegrationIdStep id(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }
    
    @Override
     public BindingDevicesStep integrationId(String integrationId) {
        Objects.requireNonNull(integrationId);
        this.integrationId = integrationId;
        return this;
    }
    
    @Override
     public BuildStep bindingDevices(List<AccessControlBindingDevice> bindingDevices) {
        Objects.requireNonNull(bindingDevices);
        this.bindingDevices = bindingDevices;
        return this;
    }
    
    @Override
     public BuildStep eventId(String eventId) {
        this.eventId = eventId;
        return this;
    }
    
    @Override
     public BuildStep eventType(AccessControlEventType eventType) {
        this.eventType = eventType;
        return this;
    }
    
    @Override
     public BuildStep providerEventType(String providerEventType) {
        this.providerEventType = providerEventType;
        return this;
    }
    
    @Override
     public BuildStep actorId(String actorId) {
        this.actorId = actorId;
        return this;
    }
    
    @Override
     public BuildStep actorName(String actorName) {
        this.actorName = actorName;
        return this;
    }
    
    @Override
     public BuildStep actorEmail(String actorEmail) {
        this.actorEmail = actorEmail;
        return this;
    }
    
    @Override
     public BuildStep objectType(AccessControlObjectType objectType) {
        this.objectType = objectType;
        return this;
    }
    
    @Override
     public BuildStep objectId(String objectId) {
        this.objectId = objectId;
        return this;
    }
    
    @Override
     public BuildStep objectName(String objectName) {
        this.objectName = objectName;
        return this;
    }
    
    @Override
     public BuildStep createdTime(String createdTime) {
        this.createdTime = createdTime;
        return this;
    }
    
    @Override
     public BuildStep createdTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }
    
    @Override
     public BuildStep offset(Long offset) {
        this.offset = offset;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String integrationId, String eventId, AccessControlEventType eventType, String providerEventType, String actorId, String actorName, String actorEmail, AccessControlObjectType objectType, String objectId, String objectName, String createdTime, Long createdTimestamp, Long offset, List<AccessControlBindingDevice> bindingDevices) {
      super(id, integrationId, eventId, eventType, providerEventType, actorId, actorName, actorEmail, objectType, objectId, objectName, createdTime, createdTimestamp, offset, bindingDevices);
      Objects.requireNonNull(id);
      Objects.requireNonNull(integrationId);
      Objects.requireNonNull(bindingDevices);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
    
    @Override
     public CopyOfBuilder integrationId(String integrationId) {
      return (CopyOfBuilder) super.integrationId(integrationId);
    }
    
    @Override
     public CopyOfBuilder bindingDevices(List<AccessControlBindingDevice> bindingDevices) {
      return (CopyOfBuilder) super.bindingDevices(bindingDevices);
    }
    
    @Override
     public CopyOfBuilder eventId(String eventId) {
      return (CopyOfBuilder) super.eventId(eventId);
    }
    
    @Override
     public CopyOfBuilder eventType(AccessControlEventType eventType) {
      return (CopyOfBuilder) super.eventType(eventType);
    }
    
    @Override
     public CopyOfBuilder providerEventType(String providerEventType) {
      return (CopyOfBuilder) super.providerEventType(providerEventType);
    }
    
    @Override
     public CopyOfBuilder actorId(String actorId) {
      return (CopyOfBuilder) super.actorId(actorId);
    }
    
    @Override
     public CopyOfBuilder actorName(String actorName) {
      return (CopyOfBuilder) super.actorName(actorName);
    }
    
    @Override
     public CopyOfBuilder actorEmail(String actorEmail) {
      return (CopyOfBuilder) super.actorEmail(actorEmail);
    }
    
    @Override
     public CopyOfBuilder objectType(AccessControlObjectType objectType) {
      return (CopyOfBuilder) super.objectType(objectType);
    }
    
    @Override
     public CopyOfBuilder objectId(String objectId) {
      return (CopyOfBuilder) super.objectId(objectId);
    }
    
    @Override
     public CopyOfBuilder objectName(String objectName) {
      return (CopyOfBuilder) super.objectName(objectName);
    }
    
    @Override
     public CopyOfBuilder createdTime(String createdTime) {
      return (CopyOfBuilder) super.createdTime(createdTime);
    }
    
    @Override
     public CopyOfBuilder createdTimestamp(Long createdTimestamp) {
      return (CopyOfBuilder) super.createdTimestamp(createdTimestamp);
    }
    
    @Override
     public CopyOfBuilder offset(Long offset) {
      return (CopyOfBuilder) super.offset(offset);
    }
  }
  
}
