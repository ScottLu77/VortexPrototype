package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;

/** This is an auto generated class representing the Archive type in your schema. */
public final class Archive {
  private final String thingName;
  private final String createdAt;
  private final String filename;
  private final String creatorNickname;
  private final String creatorEmail;
  private final String startAt;
  private final String endAt;
  private final String owner;
  private final Status status;
  private final Integer videoLength;
  private final Integer videoSize;
  private final String taskArn;
  private final String id;
  private final String sharedToken;
  private final String updatedAt;
  private final String derivant;
  private final Integer cloudSize;
  private final ArchiveSharedLinkOutput sharedLink;
  private final Boolean hasH265;
  public String getThingName() {
      return thingName;
  }
  
  public String getCreatedAt() {
      return createdAt;
  }
  
  public String getFilename() {
      return filename;
  }
  
  public String getCreatorNickname() {
      return creatorNickname;
  }
  
  public String getCreatorEmail() {
      return creatorEmail;
  }
  
  public String getStartAt() {
      return startAt;
  }
  
  public String getEndAt() {
      return endAt;
  }
  
  public String getOwner() {
      return owner;
  }
  
  public Status getStatus() {
      return status;
  }
  
  public Integer getVideoLength() {
      return videoLength;
  }
  
  public Integer getVideoSize() {
      return videoSize;
  }
  
  public String getTaskArn() {
      return taskArn;
  }
  
  public String getId() {
      return id;
  }
  
  public String getSharedToken() {
      return sharedToken;
  }
  
  public String getUpdatedAt() {
      return updatedAt;
  }
  
  public String getDerivant() {
      return derivant;
  }
  
  public Integer getCloudSize() {
      return cloudSize;
  }
  
  public ArchiveSharedLinkOutput getSharedLink() {
      return sharedLink;
  }
  
  public Boolean getHasH265() {
      return hasH265;
  }
  
  private Archive(String thingName, String createdAt, String filename, String creatorNickname, String creatorEmail, String startAt, String endAt, String owner, Status status, Integer videoLength, Integer videoSize, String taskArn, String id, String sharedToken, String updatedAt, String derivant, Integer cloudSize, ArchiveSharedLinkOutput sharedLink, Boolean hasH265) {
    this.thingName = thingName;
    this.createdAt = createdAt;
    this.filename = filename;
    this.creatorNickname = creatorNickname;
    this.creatorEmail = creatorEmail;
    this.startAt = startAt;
    this.endAt = endAt;
    this.owner = owner;
    this.status = status;
    this.videoLength = videoLength;
    this.videoSize = videoSize;
    this.taskArn = taskArn;
    this.id = id;
    this.sharedToken = sharedToken;
    this.updatedAt = updatedAt;
    this.derivant = derivant;
    this.cloudSize = cloudSize;
    this.sharedLink = sharedLink;
    this.hasH265 = hasH265;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Archive archive = (Archive) obj;
      return ObjectsCompat.equals(getThingName(), archive.getThingName()) &&
              ObjectsCompat.equals(getCreatedAt(), archive.getCreatedAt()) &&
              ObjectsCompat.equals(getFilename(), archive.getFilename()) &&
              ObjectsCompat.equals(getCreatorNickname(), archive.getCreatorNickname()) &&
              ObjectsCompat.equals(getCreatorEmail(), archive.getCreatorEmail()) &&
              ObjectsCompat.equals(getStartAt(), archive.getStartAt()) &&
              ObjectsCompat.equals(getEndAt(), archive.getEndAt()) &&
              ObjectsCompat.equals(getOwner(), archive.getOwner()) &&
              ObjectsCompat.equals(getStatus(), archive.getStatus()) &&
              ObjectsCompat.equals(getVideoLength(), archive.getVideoLength()) &&
              ObjectsCompat.equals(getVideoSize(), archive.getVideoSize()) &&
              ObjectsCompat.equals(getTaskArn(), archive.getTaskArn()) &&
              ObjectsCompat.equals(getId(), archive.getId()) &&
              ObjectsCompat.equals(getSharedToken(), archive.getSharedToken()) &&
              ObjectsCompat.equals(getUpdatedAt(), archive.getUpdatedAt()) &&
              ObjectsCompat.equals(getDerivant(), archive.getDerivant()) &&
              ObjectsCompat.equals(getCloudSize(), archive.getCloudSize()) &&
              ObjectsCompat.equals(getSharedLink(), archive.getSharedLink()) &&
              ObjectsCompat.equals(getHasH265(), archive.getHasH265());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getThingName())
      .append(getCreatedAt())
      .append(getFilename())
      .append(getCreatorNickname())
      .append(getCreatorEmail())
      .append(getStartAt())
      .append(getEndAt())
      .append(getOwner())
      .append(getStatus())
      .append(getVideoLength())
      .append(getVideoSize())
      .append(getTaskArn())
      .append(getId())
      .append(getSharedToken())
      .append(getUpdatedAt())
      .append(getDerivant())
      .append(getCloudSize())
      .append(getSharedLink())
      .append(getHasH265())
      .toString()
      .hashCode();
  }
  
  public static ThingNameStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(thingName,
      createdAt,
      filename,
      creatorNickname,
      creatorEmail,
      startAt,
      endAt,
      owner,
      status,
      videoLength,
      videoSize,
      taskArn,
      id,
      sharedToken,
      updatedAt,
      derivant,
      cloudSize,
      sharedLink,
      hasH265);
  }
  public interface ThingNameStep {
    CreatedAtStep thingName(String thingName);
  }
  

  public interface CreatedAtStep {
    FilenameStep createdAt(String createdAt);
  }
  

  public interface FilenameStep {
    CreatorNicknameStep filename(String filename);
  }
  

  public interface CreatorNicknameStep {
    CreatorEmailStep creatorNickname(String creatorNickname);
  }
  

  public interface CreatorEmailStep {
    StartAtStep creatorEmail(String creatorEmail);
  }
  

  public interface StartAtStep {
    EndAtStep startAt(String startAt);
  }
  

  public interface EndAtStep {
    UpdatedAtStep endAt(String endAt);
  }
  

  public interface UpdatedAtStep {
    SharedLinkStep updatedAt(String updatedAt);
  }
  

  public interface SharedLinkStep {
    BuildStep sharedLink(ArchiveSharedLinkOutput sharedLink);
  }

  public interface BuildStep {
    Archive build();
    BuildStep owner(String owner);
    BuildStep status(Status status);
    BuildStep videoLength(Integer videoLength);
    BuildStep videoSize(Integer videoSize);
    BuildStep taskArn(String taskArn);
    BuildStep id(String id);
    BuildStep sharedToken(String sharedToken);
    BuildStep derivant(String derivant);
    BuildStep cloudSize(Integer cloudSize);
    BuildStep hasH265(Boolean hasH265);
  }
  

  public static class Builder implements ThingNameStep, CreatedAtStep, FilenameStep, CreatorNicknameStep, CreatorEmailStep, StartAtStep, EndAtStep, UpdatedAtStep, SharedLinkStep, BuildStep {
    private String thingName;
    private String createdAt;
    private String filename;
    private String creatorNickname;
    private String creatorEmail;
    private String startAt;
    private String endAt;
    private String updatedAt;
    private ArchiveSharedLinkOutput sharedLink;
    private String owner;
    private Status status;
    private Integer videoLength;
    private Integer videoSize;
    private String taskArn;
    private String id;
    private String sharedToken;
    private String derivant;
    private Integer cloudSize;
    private Boolean hasH265;
    public Builder() {
      
    }
    
    private Builder(String thingName, String createdAt, String filename, String creatorNickname, String creatorEmail, String startAt, String endAt, String owner, Status status, Integer videoLength, Integer videoSize, String taskArn, String id, String sharedToken, String updatedAt, String derivant, Integer cloudSize, ArchiveSharedLinkOutput sharedLink, Boolean hasH265) {
      this.thingName = thingName;
      this.createdAt = createdAt;
      this.filename = filename;
      this.creatorNickname = creatorNickname;
      this.creatorEmail = creatorEmail;
      this.startAt = startAt;
      this.endAt = endAt;
      this.owner = owner;
      this.status = status;
      this.videoLength = videoLength;
      this.videoSize = videoSize;
      this.taskArn = taskArn;
      this.id = id;
      this.sharedToken = sharedToken;
      this.updatedAt = updatedAt;
      this.derivant = derivant;
      this.cloudSize = cloudSize;
      this.sharedLink = sharedLink;
      this.hasH265 = hasH265;
    }
    
    @Override
     public Archive build() {
        
        return new Archive(
          thingName,
          createdAt,
          filename,
          creatorNickname,
          creatorEmail,
          startAt,
          endAt,
          owner,
          status,
          videoLength,
          videoSize,
          taskArn,
          id,
          sharedToken,
          updatedAt,
          derivant,
          cloudSize,
          sharedLink,
          hasH265);
    }
    
    @Override
     public CreatedAtStep thingName(String thingName) {
        Objects.requireNonNull(thingName);
        this.thingName = thingName;
        return this;
    }
    
    @Override
     public FilenameStep createdAt(String createdAt) {
        Objects.requireNonNull(createdAt);
        this.createdAt = createdAt;
        return this;
    }
    
    @Override
     public CreatorNicknameStep filename(String filename) {
        Objects.requireNonNull(filename);
        this.filename = filename;
        return this;
    }
    
    @Override
     public CreatorEmailStep creatorNickname(String creatorNickname) {
        Objects.requireNonNull(creatorNickname);
        this.creatorNickname = creatorNickname;
        return this;
    }
    
    @Override
     public StartAtStep creatorEmail(String creatorEmail) {
        Objects.requireNonNull(creatorEmail);
        this.creatorEmail = creatorEmail;
        return this;
    }
    
    @Override
     public EndAtStep startAt(String startAt) {
        Objects.requireNonNull(startAt);
        this.startAt = startAt;
        return this;
    }
    
    @Override
     public UpdatedAtStep endAt(String endAt) {
        Objects.requireNonNull(endAt);
        this.endAt = endAt;
        return this;
    }
    
    @Override
     public SharedLinkStep updatedAt(String updatedAt) {
        Objects.requireNonNull(updatedAt);
        this.updatedAt = updatedAt;
        return this;
    }
    
    @Override
     public BuildStep sharedLink(ArchiveSharedLinkOutput sharedLink) {
        Objects.requireNonNull(sharedLink);
        this.sharedLink = sharedLink;
        return this;
    }
    
    @Override
     public BuildStep owner(String owner) {
        this.owner = owner;
        return this;
    }
    
    @Override
     public BuildStep status(Status status) {
        this.status = status;
        return this;
    }
    
    @Override
     public BuildStep videoLength(Integer videoLength) {
        this.videoLength = videoLength;
        return this;
    }
    
    @Override
     public BuildStep videoSize(Integer videoSize) {
        this.videoSize = videoSize;
        return this;
    }
    
    @Override
     public BuildStep taskArn(String taskArn) {
        this.taskArn = taskArn;
        return this;
    }
    
    @Override
     public BuildStep id(String id) {
        this.id = id;
        return this;
    }
    
    @Override
     public BuildStep sharedToken(String sharedToken) {
        this.sharedToken = sharedToken;
        return this;
    }
    
    @Override
     public BuildStep derivant(String derivant) {
        this.derivant = derivant;
        return this;
    }
    
    @Override
     public BuildStep cloudSize(Integer cloudSize) {
        this.cloudSize = cloudSize;
        return this;
    }
    
    @Override
     public BuildStep hasH265(Boolean hasH265) {
        this.hasH265 = hasH265;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String thingName, String createdAt, String filename, String creatorNickname, String creatorEmail, String startAt, String endAt, String owner, Status status, Integer videoLength, Integer videoSize, String taskArn, String id, String sharedToken, String updatedAt, String derivant, Integer cloudSize, ArchiveSharedLinkOutput sharedLink, Boolean hasH265) {
      super(thingName, createdAt, filename, creatorNickname, creatorEmail, startAt, endAt, owner, status, videoLength, videoSize, taskArn, id, sharedToken, updatedAt, derivant, cloudSize, sharedLink, hasH265);
      Objects.requireNonNull(thingName);
      Objects.requireNonNull(createdAt);
      Objects.requireNonNull(filename);
      Objects.requireNonNull(creatorNickname);
      Objects.requireNonNull(creatorEmail);
      Objects.requireNonNull(startAt);
      Objects.requireNonNull(endAt);
      Objects.requireNonNull(updatedAt);
      Objects.requireNonNull(sharedLink);
    }
    
    @Override
     public CopyOfBuilder thingName(String thingName) {
      return (CopyOfBuilder) super.thingName(thingName);
    }
    
    @Override
     public CopyOfBuilder createdAt(String createdAt) {
      return (CopyOfBuilder) super.createdAt(createdAt);
    }
    
    @Override
     public CopyOfBuilder filename(String filename) {
      return (CopyOfBuilder) super.filename(filename);
    }
    
    @Override
     public CopyOfBuilder creatorNickname(String creatorNickname) {
      return (CopyOfBuilder) super.creatorNickname(creatorNickname);
    }
    
    @Override
     public CopyOfBuilder creatorEmail(String creatorEmail) {
      return (CopyOfBuilder) super.creatorEmail(creatorEmail);
    }
    
    @Override
     public CopyOfBuilder startAt(String startAt) {
      return (CopyOfBuilder) super.startAt(startAt);
    }
    
    @Override
     public CopyOfBuilder endAt(String endAt) {
      return (CopyOfBuilder) super.endAt(endAt);
    }
    
    @Override
     public CopyOfBuilder updatedAt(String updatedAt) {
      return (CopyOfBuilder) super.updatedAt(updatedAt);
    }
    
    @Override
     public CopyOfBuilder sharedLink(ArchiveSharedLinkOutput sharedLink) {
      return (CopyOfBuilder) super.sharedLink(sharedLink);
    }
    
    @Override
     public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }
    
    @Override
     public CopyOfBuilder status(Status status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder videoLength(Integer videoLength) {
      return (CopyOfBuilder) super.videoLength(videoLength);
    }
    
    @Override
     public CopyOfBuilder videoSize(Integer videoSize) {
      return (CopyOfBuilder) super.videoSize(videoSize);
    }
    
    @Override
     public CopyOfBuilder taskArn(String taskArn) {
      return (CopyOfBuilder) super.taskArn(taskArn);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
    
    @Override
     public CopyOfBuilder sharedToken(String sharedToken) {
      return (CopyOfBuilder) super.sharedToken(sharedToken);
    }
    
    @Override
     public CopyOfBuilder derivant(String derivant) {
      return (CopyOfBuilder) super.derivant(derivant);
    }
    
    @Override
     public CopyOfBuilder cloudSize(Integer cloudSize) {
      return (CopyOfBuilder) super.cloudSize(cloudSize);
    }
    
    @Override
     public CopyOfBuilder hasH265(Boolean hasH265) {
      return (CopyOfBuilder) super.hasH265(hasH265);
    }
  }
  
}
