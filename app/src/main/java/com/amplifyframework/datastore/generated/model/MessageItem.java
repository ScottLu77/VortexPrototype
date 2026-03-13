package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the MessageItem type in your schema. */
public final class MessageItem {
  private final DeviceCompositeType source;
  private final String eventID;
  private final Double time;
  private final String type;
  private final String name;
  private final Double localtime;
  private final Double starttime;
  private final String thumbnails3key;
  private final String extraInfo;
  private final String information;
  private final String profileID;
  private final List<String> recognizedThumbnailS3Keys;
  private final List<String> sceneThumbnailS3Keys;
  private final String messageTypeID;
  public DeviceCompositeType getSource() {
      return source;
  }
  
  public String getEventId() {
      return eventID;
  }
  
  public Double getTime() {
      return time;
  }
  
  public String getType() {
      return type;
  }
  
  public String getName() {
      return name;
  }
  
  public Double getLocaltime() {
      return localtime;
  }
  
  public Double getStarttime() {
      return starttime;
  }
  
  public String getThumbnails3key() {
      return thumbnails3key;
  }
  
  public String getExtraInfo() {
      return extraInfo;
  }
  
  public String getInformation() {
      return information;
  }
  
  public String getProfileId() {
      return profileID;
  }
  
  public List<String> getRecognizedThumbnailS3Keys() {
      return recognizedThumbnailS3Keys;
  }
  
  public List<String> getSceneThumbnailS3Keys() {
      return sceneThumbnailS3Keys;
  }
  
  public String getMessageTypeId() {
      return messageTypeID;
  }
  
  private MessageItem(DeviceCompositeType source, String eventID, Double time, String type, String name, Double localtime, Double starttime, String thumbnails3key, String extraInfo, String information, String profileID, List<String> recognizedThumbnailS3Keys, List<String> sceneThumbnailS3Keys, String messageTypeID) {
    this.source = source;
    this.eventID = eventID;
    this.time = time;
    this.type = type;
    this.name = name;
    this.localtime = localtime;
    this.starttime = starttime;
    this.thumbnails3key = thumbnails3key;
    this.extraInfo = extraInfo;
    this.information = information;
    this.profileID = profileID;
    this.recognizedThumbnailS3Keys = recognizedThumbnailS3Keys;
    this.sceneThumbnailS3Keys = sceneThumbnailS3Keys;
    this.messageTypeID = messageTypeID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      MessageItem messageItem = (MessageItem) obj;
      return ObjectsCompat.equals(getSource(), messageItem.getSource()) &&
              ObjectsCompat.equals(getEventId(), messageItem.getEventId()) &&
              ObjectsCompat.equals(getTime(), messageItem.getTime()) &&
              ObjectsCompat.equals(getType(), messageItem.getType()) &&
              ObjectsCompat.equals(getName(), messageItem.getName()) &&
              ObjectsCompat.equals(getLocaltime(), messageItem.getLocaltime()) &&
              ObjectsCompat.equals(getStarttime(), messageItem.getStarttime()) &&
              ObjectsCompat.equals(getThumbnails3key(), messageItem.getThumbnails3key()) &&
              ObjectsCompat.equals(getExtraInfo(), messageItem.getExtraInfo()) &&
              ObjectsCompat.equals(getInformation(), messageItem.getInformation()) &&
              ObjectsCompat.equals(getProfileId(), messageItem.getProfileId()) &&
              ObjectsCompat.equals(getRecognizedThumbnailS3Keys(), messageItem.getRecognizedThumbnailS3Keys()) &&
              ObjectsCompat.equals(getSceneThumbnailS3Keys(), messageItem.getSceneThumbnailS3Keys()) &&
              ObjectsCompat.equals(getMessageTypeId(), messageItem.getMessageTypeId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getSource())
      .append(getEventId())
      .append(getTime())
      .append(getType())
      .append(getName())
      .append(getLocaltime())
      .append(getStarttime())
      .append(getThumbnails3key())
      .append(getExtraInfo())
      .append(getInformation())
      .append(getProfileId())
      .append(getRecognizedThumbnailS3Keys())
      .append(getSceneThumbnailS3Keys())
      .append(getMessageTypeId())
      .toString()
      .hashCode();
  }
  
  public static SourceStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(source,
      eventID,
      time,
      type,
      name,
      localtime,
      starttime,
      thumbnails3key,
      extraInfo,
      information,
      profileID,
      recognizedThumbnailS3Keys,
      sceneThumbnailS3Keys,
      messageTypeID);
  }
  public interface SourceStep {
    EventIdStep source(DeviceCompositeType source);
  }
  

  public interface EventIdStep {
    TimeStep eventId(String eventId);
  }
  

  public interface TimeStep {
    TypeStep time(Double time);
  }
  

  public interface TypeStep {
    RecognizedThumbnailS3KeysStep type(String type);
  }
  

  public interface RecognizedThumbnailS3KeysStep {
    SceneThumbnailS3KeysStep recognizedThumbnailS3Keys(List<String> recognizedThumbnailS3Keys);
  }
  

  public interface SceneThumbnailS3KeysStep {
    MessageTypeIdStep sceneThumbnailS3Keys(List<String> sceneThumbnailS3Keys);
  }
  

  public interface MessageTypeIdStep {
    BuildStep messageTypeId(String messageTypeId);
  }
  

  public interface BuildStep {
    MessageItem build();
    BuildStep name(String name);
    BuildStep localtime(Double localtime);
    BuildStep starttime(Double starttime);
    BuildStep thumbnails3key(String thumbnails3key);
    BuildStep extraInfo(String extraInfo);
    BuildStep information(String information);
    BuildStep profileId(String profileId);
  }
  

  public static class Builder implements SourceStep, EventIdStep, TimeStep, TypeStep, RecognizedThumbnailS3KeysStep, SceneThumbnailS3KeysStep, MessageTypeIdStep, BuildStep {
    private DeviceCompositeType source;
    private String eventID;
    private Double time;
    private String type;
    private List<String> recognizedThumbnailS3Keys;
    private List<String> sceneThumbnailS3Keys;
    private String messageTypeID;
    private String name;
    private Double localtime;
    private Double starttime;
    private String thumbnails3key;
    private String extraInfo;
    private String information;
    private String profileID;
    public Builder() {
      
    }
    
    private Builder(DeviceCompositeType source, String eventID, Double time, String type, String name, Double localtime, Double starttime, String thumbnails3key, String extraInfo, String information, String profileID, List<String> recognizedThumbnailS3Keys, List<String> sceneThumbnailS3Keys, String messageTypeID) {
      this.source = source;
      this.eventID = eventID;
      this.time = time;
      this.type = type;
      this.name = name;
      this.localtime = localtime;
      this.starttime = starttime;
      this.thumbnails3key = thumbnails3key;
      this.extraInfo = extraInfo;
      this.information = information;
      this.profileID = profileID;
      this.recognizedThumbnailS3Keys = recognizedThumbnailS3Keys;
      this.sceneThumbnailS3Keys = sceneThumbnailS3Keys;
      this.messageTypeID = messageTypeID;
    }
    
    @Override
     public MessageItem build() {
        
        return new MessageItem(
          source,
          eventID,
          time,
          type,
          name,
          localtime,
          starttime,
          thumbnails3key,
          extraInfo,
          information,
          profileID,
          recognizedThumbnailS3Keys,
          sceneThumbnailS3Keys,
          messageTypeID);
    }
    
    @Override
     public EventIdStep source(DeviceCompositeType source) {
        Objects.requireNonNull(source);
        this.source = source;
        return this;
    }
    
    @Override
     public TimeStep eventId(String eventId) {
        Objects.requireNonNull(eventId);
        this.eventID = eventId;
        return this;
    }
    
    @Override
     public TypeStep time(Double time) {
        Objects.requireNonNull(time);
        this.time = time;
        return this;
    }
    
    @Override
     public RecognizedThumbnailS3KeysStep type(String type) {
        Objects.requireNonNull(type);
        this.type = type;
        return this;
    }
    
    @Override
     public SceneThumbnailS3KeysStep recognizedThumbnailS3Keys(List<String> recognizedThumbnailS3Keys) {
        Objects.requireNonNull(recognizedThumbnailS3Keys);
        this.recognizedThumbnailS3Keys = recognizedThumbnailS3Keys;
        return this;
    }
    
    @Override
     public MessageTypeIdStep sceneThumbnailS3Keys(List<String> sceneThumbnailS3Keys) {
        Objects.requireNonNull(sceneThumbnailS3Keys);
        this.sceneThumbnailS3Keys = sceneThumbnailS3Keys;
        return this;
    }
    
    @Override
     public BuildStep messageTypeId(String messageTypeId) {
        Objects.requireNonNull(messageTypeId);
        this.messageTypeID = messageTypeId;
        return this;
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep localtime(Double localtime) {
        this.localtime = localtime;
        return this;
    }
    
    @Override
     public BuildStep starttime(Double starttime) {
        this.starttime = starttime;
        return this;
    }
    
    @Override
     public BuildStep thumbnails3key(String thumbnails3key) {
        this.thumbnails3key = thumbnails3key;
        return this;
    }
    
    @Override
     public BuildStep extraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }
    
    @Override
     public BuildStep information(String information) {
        this.information = information;
        return this;
    }
    
    @Override
     public BuildStep profileId(String profileId) {
        this.profileID = profileId;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(DeviceCompositeType source, String eventId, Double time, String type, String name, Double localtime, Double starttime, String thumbnails3key, String extraInfo, String information, String profileId, List<String> recognizedThumbnailS3Keys, List<String> sceneThumbnailS3Keys, String messageTypeId) {
      super(source, eventID, time, type, name, localtime, starttime, thumbnails3key, extraInfo, information, profileID, recognizedThumbnailS3Keys, sceneThumbnailS3Keys, messageTypeID);
      Objects.requireNonNull(source);
      Objects.requireNonNull(eventID);
      Objects.requireNonNull(time);
      Objects.requireNonNull(type);
      Objects.requireNonNull(recognizedThumbnailS3Keys);
      Objects.requireNonNull(sceneThumbnailS3Keys);
      Objects.requireNonNull(messageTypeID);
    }
    
    @Override
     public CopyOfBuilder source(DeviceCompositeType source) {
      return (CopyOfBuilder) super.source(source);
    }
    
    @Override
     public CopyOfBuilder eventId(String eventId) {
      return (CopyOfBuilder) super.eventId(eventId);
    }
    
    @Override
     public CopyOfBuilder time(Double time) {
      return (CopyOfBuilder) super.time(time);
    }
    
    @Override
     public CopyOfBuilder type(String type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder recognizedThumbnailS3Keys(List<String> recognizedThumbnailS3Keys) {
      return (CopyOfBuilder) super.recognizedThumbnailS3Keys(recognizedThumbnailS3Keys);
    }
    
    @Override
     public CopyOfBuilder sceneThumbnailS3Keys(List<String> sceneThumbnailS3Keys) {
      return (CopyOfBuilder) super.sceneThumbnailS3Keys(sceneThumbnailS3Keys);
    }
    
    @Override
     public CopyOfBuilder messageTypeId(String messageTypeId) {
      return (CopyOfBuilder) super.messageTypeId(messageTypeId);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder localtime(Double localtime) {
      return (CopyOfBuilder) super.localtime(localtime);
    }
    
    @Override
     public CopyOfBuilder starttime(Double starttime) {
      return (CopyOfBuilder) super.starttime(starttime);
    }
    
    @Override
     public CopyOfBuilder thumbnails3key(String thumbnails3key) {
      return (CopyOfBuilder) super.thumbnails3key(thumbnails3key);
    }
    
    @Override
     public CopyOfBuilder extraInfo(String extraInfo) {
      return (CopyOfBuilder) super.extraInfo(extraInfo);
    }
    
    @Override
     public CopyOfBuilder information(String information) {
      return (CopyOfBuilder) super.information(information);
    }
    
    @Override
     public CopyOfBuilder profileId(String profileId) {
      return (CopyOfBuilder) super.profileId(profileId);
    }
  }
  
}
