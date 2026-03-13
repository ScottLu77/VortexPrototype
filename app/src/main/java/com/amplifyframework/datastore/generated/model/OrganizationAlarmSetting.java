package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the OrganizationAlarmSetting type in your schema. */
public final class OrganizationAlarmSetting {
  private final String alarmID;
  private final String alarmName;
  private final List<String> events;
  private final List<String> actions;
  private final List<String> scheduleBitwise;
  private final String createdBy;
  private final String getSettingsURL;
  private final String putSettingsURL;
  private final Boolean enable;
  private final String pauseUntil;
  private final DeviceCity city;
  public String getAlarmId() {
      return alarmID;
  }
  
  public String getAlarmName() {
      return alarmName;
  }
  
  public List<String> getEvents() {
      return events;
  }
  
  public List<String> getActions() {
      return actions;
  }
  
  public List<String> getScheduleBitwise() {
      return scheduleBitwise;
  }
  
  public String getCreatedBy() {
      return createdBy;
  }
  
  public String getGetSettingsUrl() {
      return getSettingsURL;
  }
  
  public String getPutSettingsUrl() {
      return putSettingsURL;
  }
  
  public Boolean getEnable() {
      return enable;
  }
  
  public String getPauseUntil() {
      return pauseUntil;
  }
  
  public DeviceCity getCity() {
      return city;
  }
  
  private OrganizationAlarmSetting(String alarmID, String alarmName, List<String> events, List<String> actions, List<String> scheduleBitwise, String createdBy, String getSettingsURL, String putSettingsURL, Boolean enable, String pauseUntil, DeviceCity city) {
    this.alarmID = alarmID;
    this.alarmName = alarmName;
    this.events = events;
    this.actions = actions;
    this.scheduleBitwise = scheduleBitwise;
    this.createdBy = createdBy;
    this.getSettingsURL = getSettingsURL;
    this.putSettingsURL = putSettingsURL;
    this.enable = enable;
    this.pauseUntil = pauseUntil;
    this.city = city;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      OrganizationAlarmSetting organizationAlarmSetting = (OrganizationAlarmSetting) obj;
      return ObjectsCompat.equals(getAlarmId(), organizationAlarmSetting.getAlarmId()) &&
              ObjectsCompat.equals(getAlarmName(), organizationAlarmSetting.getAlarmName()) &&
              ObjectsCompat.equals(getEvents(), organizationAlarmSetting.getEvents()) &&
              ObjectsCompat.equals(getActions(), organizationAlarmSetting.getActions()) &&
              ObjectsCompat.equals(getScheduleBitwise(), organizationAlarmSetting.getScheduleBitwise()) &&
              ObjectsCompat.equals(getCreatedBy(), organizationAlarmSetting.getCreatedBy()) &&
              ObjectsCompat.equals(getGetSettingsUrl(), organizationAlarmSetting.getGetSettingsUrl()) &&
              ObjectsCompat.equals(getPutSettingsUrl(), organizationAlarmSetting.getPutSettingsUrl()) &&
              ObjectsCompat.equals(getEnable(), organizationAlarmSetting.getEnable()) &&
              ObjectsCompat.equals(getPauseUntil(), organizationAlarmSetting.getPauseUntil()) &&
              ObjectsCompat.equals(getCity(), organizationAlarmSetting.getCity());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getAlarmId())
      .append(getAlarmName())
      .append(getEvents())
      .append(getActions())
      .append(getScheduleBitwise())
      .append(getCreatedBy())
      .append(getGetSettingsUrl())
      .append(getPutSettingsUrl())
      .append(getEnable())
      .append(getPauseUntil())
      .append(getCity())
      .toString()
      .hashCode();
  }
  
  public static AlarmIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(alarmID,
      alarmName,
      events,
      actions,
      scheduleBitwise,
      createdBy,
      getSettingsURL,
      putSettingsURL,
      enable,
      pauseUntil,
      city);
  }
  public interface AlarmIdStep {
    AlarmNameStep alarmId(String alarmId);
  }
  

  public interface AlarmNameStep {
    EventsStep alarmName(String alarmName);
  }
  

  public interface EventsStep {
    ActionsStep events(List<String> events);
  }
  

  public interface ActionsStep {
    ScheduleBitwiseStep actions(List<String> actions);
  }
  

  public interface ScheduleBitwiseStep {
    CreatedByStep scheduleBitwise(List<String> scheduleBitwise);
  }
  

  public interface CreatedByStep {
    GetSettingsUrlStep createdBy(String createdBy);
  }
  

  public interface GetSettingsUrlStep {
    PutSettingsUrlStep getSettingsUrl(String getSettingsUrl);
  }
  

  public interface PutSettingsUrlStep {
    BuildStep putSettingsUrl(String putSettingsUrl);
  }
  

  public interface BuildStep {
    OrganizationAlarmSetting build();
    BuildStep enable(Boolean enable);
    BuildStep pauseUntil(String pauseUntil);
    BuildStep city(DeviceCity city);
  }
  

  public static class Builder implements AlarmIdStep, AlarmNameStep, EventsStep, ActionsStep, ScheduleBitwiseStep, CreatedByStep, GetSettingsUrlStep, PutSettingsUrlStep, BuildStep {
    private String alarmID;
    private String alarmName;
    private List<String> events;
    private List<String> actions;
    private List<String> scheduleBitwise;
    private String createdBy;
    private String getSettingsURL;
    private String putSettingsURL;
    private Boolean enable;
    private String pauseUntil;
    private DeviceCity city;
    public Builder() {
      
    }
    
    private Builder(String alarmID, String alarmName, List<String> events, List<String> actions, List<String> scheduleBitwise, String createdBy, String getSettingsURL, String putSettingsURL, Boolean enable, String pauseUntil, DeviceCity city) {
      this.alarmID = alarmID;
      this.alarmName = alarmName;
      this.events = events;
      this.actions = actions;
      this.scheduleBitwise = scheduleBitwise;
      this.createdBy = createdBy;
      this.getSettingsURL = getSettingsURL;
      this.putSettingsURL = putSettingsURL;
      this.enable = enable;
      this.pauseUntil = pauseUntil;
      this.city = city;
    }
    
    @Override
     public OrganizationAlarmSetting build() {
        
        return new OrganizationAlarmSetting(
          alarmID,
          alarmName,
          events,
          actions,
          scheduleBitwise,
          createdBy,
          getSettingsURL,
          putSettingsURL,
          enable,
          pauseUntil,
          city);
    }
    
    @Override
     public AlarmNameStep alarmId(String alarmId) {
        Objects.requireNonNull(alarmId);
        this.alarmID = alarmId;
        return this;
    }
    
    @Override
     public EventsStep alarmName(String alarmName) {
        Objects.requireNonNull(alarmName);
        this.alarmName = alarmName;
        return this;
    }
    
    @Override
     public ActionsStep events(List<String> events) {
        Objects.requireNonNull(events);
        this.events = events;
        return this;
    }
    
    @Override
     public ScheduleBitwiseStep actions(List<String> actions) {
        Objects.requireNonNull(actions);
        this.actions = actions;
        return this;
    }
    
    @Override
     public CreatedByStep scheduleBitwise(List<String> scheduleBitwise) {
        Objects.requireNonNull(scheduleBitwise);
        this.scheduleBitwise = scheduleBitwise;
        return this;
    }
    
    @Override
     public GetSettingsUrlStep createdBy(String createdBy) {
        Objects.requireNonNull(createdBy);
        this.createdBy = createdBy;
        return this;
    }
    
    @Override
     public PutSettingsUrlStep getSettingsUrl(String getSettingsUrl) {
        Objects.requireNonNull(getSettingsUrl);
        this.getSettingsURL = getSettingsUrl;
        return this;
    }
    
    @Override
     public BuildStep putSettingsUrl(String putSettingsUrl) {
        Objects.requireNonNull(putSettingsUrl);
        this.putSettingsURL = putSettingsUrl;
        return this;
    }
    
    @Override
     public BuildStep enable(Boolean enable) {
        this.enable = enable;
        return this;
    }
    
    @Override
     public BuildStep pauseUntil(String pauseUntil) {
        this.pauseUntil = pauseUntil;
        return this;
    }
    
    @Override
     public BuildStep city(DeviceCity city) {
        this.city = city;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String alarmId, String alarmName, List<String> events, List<String> actions, List<String> scheduleBitwise, String createdBy, String getSettingsUrl, String putSettingsUrl, Boolean enable, String pauseUntil, DeviceCity city) {
      super(alarmID, alarmName, events, actions, scheduleBitwise, createdBy, getSettingsURL, putSettingsURL, enable, pauseUntil, city);
      Objects.requireNonNull(alarmID);
      Objects.requireNonNull(alarmName);
      Objects.requireNonNull(events);
      Objects.requireNonNull(actions);
      Objects.requireNonNull(scheduleBitwise);
      Objects.requireNonNull(createdBy);
      Objects.requireNonNull(getSettingsURL);
      Objects.requireNonNull(putSettingsURL);
    }
    
    @Override
     public CopyOfBuilder alarmId(String alarmId) {
      return (CopyOfBuilder) super.alarmId(alarmId);
    }
    
    @Override
     public CopyOfBuilder alarmName(String alarmName) {
      return (CopyOfBuilder) super.alarmName(alarmName);
    }
    
    @Override
     public CopyOfBuilder events(List<String> events) {
      return (CopyOfBuilder) super.events(events);
    }
    
    @Override
     public CopyOfBuilder actions(List<String> actions) {
      return (CopyOfBuilder) super.actions(actions);
    }
    
    @Override
     public CopyOfBuilder scheduleBitwise(List<String> scheduleBitwise) {
      return (CopyOfBuilder) super.scheduleBitwise(scheduleBitwise);
    }
    
    @Override
     public CopyOfBuilder createdBy(String createdBy) {
      return (CopyOfBuilder) super.createdBy(createdBy);
    }
    
    @Override
     public CopyOfBuilder getSettingsUrl(String getSettingsUrl) {
      return (CopyOfBuilder) super.getSettingsUrl(getSettingsUrl);
    }
    
    @Override
     public CopyOfBuilder putSettingsUrl(String putSettingsUrl) {
      return (CopyOfBuilder) super.putSettingsUrl(putSettingsUrl);
    }
    
    @Override
     public CopyOfBuilder enable(Boolean enable) {
      return (CopyOfBuilder) super.enable(enable);
    }
    
    @Override
     public CopyOfBuilder pauseUntil(String pauseUntil) {
      return (CopyOfBuilder) super.pauseUntil(pauseUntil);
    }
    
    @Override
     public CopyOfBuilder city(DeviceCity city) {
      return (CopyOfBuilder) super.city(city);
    }
  }
  
}
