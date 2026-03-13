package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the SIService type in your schema. */
public final class SIService {
  private final Integer companyID;
  private final String companyName;
  private final String phoneNumber;
  private final String email;
  private final Boolean enableRemoteAccess;
  private final Boolean autoSendSystemEvent;
  public Integer getCompanyId() {
      return companyID;
  }
  
  public String getCompanyName() {
      return companyName;
  }
  
  public String getPhoneNumber() {
      return phoneNumber;
  }
  
  public String getEmail() {
      return email;
  }
  
  public Boolean getEnableRemoteAccess() {
      return enableRemoteAccess;
  }
  
  public Boolean getAutoSendSystemEvent() {
      return autoSendSystemEvent;
  }
  
  private SIService(Integer companyID, String companyName, String phoneNumber, String email, Boolean enableRemoteAccess, Boolean autoSendSystemEvent) {
    this.companyID = companyID;
    this.companyName = companyName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.enableRemoteAccess = enableRemoteAccess;
    this.autoSendSystemEvent = autoSendSystemEvent;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SIService siService = (SIService) obj;
      return ObjectsCompat.equals(getCompanyId(), siService.getCompanyId()) &&
              ObjectsCompat.equals(getCompanyName(), siService.getCompanyName()) &&
              ObjectsCompat.equals(getPhoneNumber(), siService.getPhoneNumber()) &&
              ObjectsCompat.equals(getEmail(), siService.getEmail()) &&
              ObjectsCompat.equals(getEnableRemoteAccess(), siService.getEnableRemoteAccess()) &&
              ObjectsCompat.equals(getAutoSendSystemEvent(), siService.getAutoSendSystemEvent());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getCompanyId())
      .append(getCompanyName())
      .append(getPhoneNumber())
      .append(getEmail())
      .append(getEnableRemoteAccess())
      .append(getAutoSendSystemEvent())
      .toString()
      .hashCode();
  }
  
  public static CompanyIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(companyID,
      companyName,
      phoneNumber,
      email,
      enableRemoteAccess,
      autoSendSystemEvent);
  }
  public interface CompanyIdStep {
    CompanyNameStep companyId(Integer companyId);
  }
  

  public interface CompanyNameStep {
    EmailStep companyName(String companyName);
  }
  

  public interface EmailStep {
    EnableRemoteAccessStep email(String email);
  }
  

  public interface EnableRemoteAccessStep {
    BuildStep enableRemoteAccess(Boolean enableRemoteAccess);
  }
  

  public interface BuildStep {
    SIService build();
    BuildStep phoneNumber(String phoneNumber);
    BuildStep autoSendSystemEvent(Boolean autoSendSystemEvent);
  }
  

  public static class Builder implements CompanyIdStep, CompanyNameStep, EmailStep, EnableRemoteAccessStep, BuildStep {
    private Integer companyID;
    private String companyName;
    private String email;
    private Boolean enableRemoteAccess;
    private String phoneNumber;
    private Boolean autoSendSystemEvent;
    public Builder() {
      
    }
    
    private Builder(Integer companyID, String companyName, String phoneNumber, String email, Boolean enableRemoteAccess, Boolean autoSendSystemEvent) {
      this.companyID = companyID;
      this.companyName = companyName;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.enableRemoteAccess = enableRemoteAccess;
      this.autoSendSystemEvent = autoSendSystemEvent;
    }
    
    @Override
     public SIService build() {
        
        return new SIService(
          companyID,
          companyName,
          phoneNumber,
          email,
          enableRemoteAccess,
          autoSendSystemEvent);
    }
    
    @Override
     public CompanyNameStep companyId(Integer companyId) {
        Objects.requireNonNull(companyId);
        this.companyID = companyId;
        return this;
    }
    
    @Override
     public EmailStep companyName(String companyName) {
        Objects.requireNonNull(companyName);
        this.companyName = companyName;
        return this;
    }
    
    @Override
     public EnableRemoteAccessStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep enableRemoteAccess(Boolean enableRemoteAccess) {
        Objects.requireNonNull(enableRemoteAccess);
        this.enableRemoteAccess = enableRemoteAccess;
        return this;
    }
    
    @Override
     public BuildStep phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    @Override
     public BuildStep autoSendSystemEvent(Boolean autoSendSystemEvent) {
        this.autoSendSystemEvent = autoSendSystemEvent;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Integer companyId, String companyName, String phoneNumber, String email, Boolean enableRemoteAccess, Boolean autoSendSystemEvent) {
      super(companyID, companyName, phoneNumber, email, enableRemoteAccess, autoSendSystemEvent);
      Objects.requireNonNull(companyID);
      Objects.requireNonNull(companyName);
      Objects.requireNonNull(email);
      Objects.requireNonNull(enableRemoteAccess);
    }
    
    @Override
     public CopyOfBuilder companyId(Integer companyId) {
      return (CopyOfBuilder) super.companyId(companyId);
    }
    
    @Override
     public CopyOfBuilder companyName(String companyName) {
      return (CopyOfBuilder) super.companyName(companyName);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder enableRemoteAccess(Boolean enableRemoteAccess) {
      return (CopyOfBuilder) super.enableRemoteAccess(enableRemoteAccess);
    }
    
    @Override
     public CopyOfBuilder phoneNumber(String phoneNumber) {
      return (CopyOfBuilder) super.phoneNumber(phoneNumber);
    }
    
    @Override
     public CopyOfBuilder autoSendSystemEvent(Boolean autoSendSystemEvent) {
      return (CopyOfBuilder) super.autoSendSystemEvent(autoSendSystemEvent);
    }
  }
  
}
