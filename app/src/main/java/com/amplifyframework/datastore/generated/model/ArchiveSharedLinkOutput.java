package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;

/** This is an auto generated class representing the ArchiveSharedLinkOutput type in your schema. */
public final class ArchiveSharedLinkOutput {
  private final String id;
  private final Boolean enabled;
  private final String password;
  private final String expireTime;
  private final String url;
  private final Boolean enableDownload;
  public String getId() {
      return id;
  }
  
  public Boolean getEnabled() {
      return enabled;
  }
  
  public String getPassword() {
      return password;
  }
  
  public String getExpireTime() {
      return expireTime;
  }
  
  public String getUrl() {
      return url;
  }

  public Boolean getEnableDownload() {
      return enableDownload;
  }

  private ArchiveSharedLinkOutput(String id, Boolean enabled, String password, String expireTime, String url, Boolean enableDownload) {
    this.id = id;
    this.enabled = enabled;
    this.password = password;
    this.expireTime = expireTime;
    this.url = url;
    this.enableDownload = enableDownload;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ArchiveSharedLinkOutput archiveSharedLinkOutput = (ArchiveSharedLinkOutput) obj;
      return ObjectsCompat.equals(getId(), archiveSharedLinkOutput.getId()) &&
              ObjectsCompat.equals(getEnabled(), archiveSharedLinkOutput.getEnabled()) &&
              ObjectsCompat.equals(getPassword(), archiveSharedLinkOutput.getPassword()) &&
              ObjectsCompat.equals(getExpireTime(), archiveSharedLinkOutput.getExpireTime()) &&
              ObjectsCompat.equals(getUrl(), archiveSharedLinkOutput.getUrl()) &&
              ObjectsCompat.equals(getEnableDownload(), archiveSharedLinkOutput.getEnableDownload());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getEnabled())
      .append(getPassword())
      .append(getExpireTime())
      .append(getUrl())
      .append(getEnableDownload())
      .toString()
      .hashCode();
  }
  
  public static IdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      enabled,
      password,
      expireTime,
      url,
      enableDownload);
  }
  public interface IdStep {
    EnabledStep id(String id);
  }
  

  public interface EnabledStep {
    BuildStep enabled(Boolean enabled);
  }
  

  public interface BuildStep {
    ArchiveSharedLinkOutput build();
    BuildStep password(String password);
    BuildStep expireTime(String expireTime);
    BuildStep url(String url);
    BuildStep enableDownload(Boolean enableDownload);
  }
  

  public static class Builder implements IdStep, EnabledStep, BuildStep {
    private String id;
    private Boolean enabled;
    private String password;
    private String expireTime;
    private String url;
    private Boolean enableDownload;
    public Builder() {
      
    }
    
    private Builder(String id, Boolean enabled, String password, String expireTime, String url, Boolean enableDownload) {
      this.id = id;
      this.enabled = enabled;
      this.password = password;
      this.expireTime = expireTime;
      this.url = url;
      this.enableDownload = enableDownload;
    }
    
    @Override
     public ArchiveSharedLinkOutput build() {
        
        return new ArchiveSharedLinkOutput(
          id,
          enabled,
          password,
          expireTime,
          url,
          enableDownload);
    }
    
    @Override
     public EnabledStep id(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }
    
    @Override
     public BuildStep enabled(Boolean enabled) {
        Objects.requireNonNull(enabled);
        this.enabled = enabled;
        return this;
    }

    @Override
     public BuildStep password(String password) {
        this.password = password;
        return this;
    }
    
    @Override
     public BuildStep expireTime(String expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    @Override
    public BuildStep url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public BuildStep enableDownload(Boolean enableDownload) {
        this.enableDownload = enableDownload;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Boolean enabled, String password, String expireTime, String url, Boolean enableDownload) {
      super(id, enabled, password, expireTime, url, enableDownload);
      Objects.requireNonNull(id);
      Objects.requireNonNull(enabled);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
    
    @Override
     public CopyOfBuilder enabled(Boolean enabled) {
      return (CopyOfBuilder) super.enabled(enabled);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
    }
    
    @Override
     public CopyOfBuilder expireTime(String expireTime) {
      return (CopyOfBuilder) super.expireTime(expireTime);
    }
    
    @Override
     public CopyOfBuilder url(String url) {
      return (CopyOfBuilder) super.url(url);
    }

    @Override
    public CopyOfBuilder enableDownload(Boolean enableDownload) {
        return (CopyOfBuilder) super.enableDownload(enableDownload);
    }
  }
  
}
