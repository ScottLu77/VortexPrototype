package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GrantExternalServiceAPITokenOutput type in your schema. */
public final class GrantExternalServiceAPITokenOutput {
  private final String token;
  private final String encoderToken;
  public String getToken() {
      return token;
  }
  
  public String getEncoderToken() {
      return encoderToken;
  }
  
  private GrantExternalServiceAPITokenOutput(String token, String encoderToken) {
    this.token = token;
    this.encoderToken = encoderToken;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GrantExternalServiceAPITokenOutput grantExternalServiceApiTokenOutput = (GrantExternalServiceAPITokenOutput) obj;
      return ObjectsCompat.equals(getToken(), grantExternalServiceApiTokenOutput.getToken()) &&
              ObjectsCompat.equals(getEncoderToken(), grantExternalServiceApiTokenOutput.getEncoderToken());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getToken())
      .append(getEncoderToken())
      .toString()
      .hashCode();
  }
  
  public static TokenStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(token,
      encoderToken);
  }
  public interface TokenStep {
    BuildStep token(String token);
  }
  

  public interface BuildStep {
    GrantExternalServiceAPITokenOutput build();
    BuildStep encoderToken(String encoderToken);
  }
  

  public static class Builder implements TokenStep, BuildStep {
    private String token;
    private String encoderToken;
    public Builder() {
      
    }
    
    private Builder(String token, String encoderToken) {
      this.token = token;
      this.encoderToken = encoderToken;
    }
    
    @Override
     public GrantExternalServiceAPITokenOutput build() {
        
        return new GrantExternalServiceAPITokenOutput(
          token,
          encoderToken);
    }
    
    @Override
     public BuildStep token(String token) {
        Objects.requireNonNull(token);
        this.token = token;
        return this;
    }
    
    @Override
     public BuildStep encoderToken(String encoderToken) {
        this.encoderToken = encoderToken;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String token, String encoderToken) {
      super(token, encoderToken);
      Objects.requireNonNull(token);
    }
    
    @Override
     public CopyOfBuilder token(String token) {
      return (CopyOfBuilder) super.token(token);
    }
    
    @Override
     public CopyOfBuilder encoderToken(String encoderToken) {
      return (CopyOfBuilder) super.encoderToken(encoderToken);
    }
  }
  
}
