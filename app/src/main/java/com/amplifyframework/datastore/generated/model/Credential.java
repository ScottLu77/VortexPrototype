package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Credential type in your schema. */
public final class Credential {
  private final String accessKeyId;
  private final String secretAccessKey;
  private final String sessionToken;
  public String getAccessKeyId() {
      return accessKeyId;
  }
  
  public String getSecretAccessKey() {
      return secretAccessKey;
  }
  
  public String getSessionToken() {
      return sessionToken;
  }
  
  private Credential(String accessKeyId, String secretAccessKey, String sessionToken) {
    this.accessKeyId = accessKeyId;
    this.secretAccessKey = secretAccessKey;
    this.sessionToken = sessionToken;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Credential credential = (Credential) obj;
      return ObjectsCompat.equals(getAccessKeyId(), credential.getAccessKeyId()) &&
              ObjectsCompat.equals(getSecretAccessKey(), credential.getSecretAccessKey()) &&
              ObjectsCompat.equals(getSessionToken(), credential.getSessionToken());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getAccessKeyId())
      .append(getSecretAccessKey())
      .append(getSessionToken())
      .toString()
      .hashCode();
  }
  
  public static AccessKeyIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(accessKeyId,
      secretAccessKey,
      sessionToken);
  }
  public interface AccessKeyIdStep {
    BuildStep accessKeyId(String accessKeyId);
  }
  

  public interface BuildStep {
    Credential build();
    BuildStep secretAccessKey(String secretAccessKey);
    BuildStep sessionToken(String sessionToken);
  }
  

  public static class Builder implements AccessKeyIdStep, BuildStep {
    private String accessKeyId;
    private String secretAccessKey;
    private String sessionToken;
    public Builder() {
      
    }
    
    private Builder(String accessKeyId, String secretAccessKey, String sessionToken) {
      this.accessKeyId = accessKeyId;
      this.secretAccessKey = secretAccessKey;
      this.sessionToken = sessionToken;
    }
    
    @Override
     public Credential build() {
        
        return new Credential(
          accessKeyId,
          secretAccessKey,
          sessionToken);
    }
    
    @Override
     public BuildStep accessKeyId(String accessKeyId) {
        Objects.requireNonNull(accessKeyId);
        this.accessKeyId = accessKeyId;
        return this;
    }
    
    @Override
     public BuildStep secretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }
    
    @Override
     public BuildStep sessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String accessKeyId, String secretAccessKey, String sessionToken) {
      super(accessKeyId, secretAccessKey, sessionToken);
      Objects.requireNonNull(accessKeyId);
    }
    
    @Override
     public CopyOfBuilder accessKeyId(String accessKeyId) {
      return (CopyOfBuilder) super.accessKeyId(accessKeyId);
    }
    
    @Override
     public CopyOfBuilder secretAccessKey(String secretAccessKey) {
      return (CopyOfBuilder) super.secretAccessKey(secretAccessKey);
    }
    
    @Override
     public CopyOfBuilder sessionToken(String sessionToken) {
      return (CopyOfBuilder) super.sessionToken(sessionToken);
    }
  }
  
}
