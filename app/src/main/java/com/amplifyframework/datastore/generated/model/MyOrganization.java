package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the MyOrganization type in your schema. */
public final class MyOrganization {
  private final String organizationID;
  private final String organizationName;
  private final Boolean onBoard;
  private final String inviterEmail;
  private final LicensePhase licensePhase;
  private final List<String> licenseMainPlans;
  private final Boolean isFreePlan;
  private final Location storageLocation;
  private final Boolean isRequiredMFA;
  private final String username;
  private final String snoozeUntil;
  private final Integer eventDelayTimeSeconds;
  private final List<SupportFeature> support;
  public String getOrganizationId() {
      return organizationID;
  }
  
  public String getOrganizationName() {
      return organizationName;
  }
  
  public Boolean getOnBoard() {
      return onBoard;
  }
  
  public String getInviterEmail() {
      return inviterEmail;
  }
  
  public LicensePhase getLicensePhase() {
      return licensePhase;
  }
  
  public List<String> getLicenseMainPlans() {
      return licenseMainPlans;
  }
  
  public Boolean getIsFreePlan() {
      return isFreePlan;
  }
  
  public Location getStorageLocation() {
      return storageLocation;
  }
  
  public Boolean getIsRequiredMfa() {
      return isRequiredMFA;
  }
  
  public String getUsername() {
      return username;
  }
  
  public String getSnoozeUntil() {
      return snoozeUntil;
  }
  
  public Integer getEventDelayTimeSeconds() {
      return eventDelayTimeSeconds;
  }
  
  public List<SupportFeature> getSupport() {
      return support;
  }
  
  private MyOrganization(String organizationID, String organizationName, Boolean onBoard, String inviterEmail, LicensePhase licensePhase, List<String> licenseMainPlans, Boolean isFreePlan, Location storageLocation, Boolean isRequiredMFA, String username, String snoozeUntil, Integer eventDelayTimeSeconds, List<SupportFeature> support) {
    this.organizationID = organizationID;
    this.organizationName = organizationName;
    this.onBoard = onBoard;
    this.inviterEmail = inviterEmail;
    this.licensePhase = licensePhase;
    this.licenseMainPlans = licenseMainPlans;
    this.isFreePlan = isFreePlan;
    this.storageLocation = storageLocation;
    this.isRequiredMFA = isRequiredMFA;
    this.username = username;
    this.snoozeUntil = snoozeUntil;
    this.eventDelayTimeSeconds = eventDelayTimeSeconds;
    this.support = support;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      MyOrganization myOrganization = (MyOrganization) obj;
      return ObjectsCompat.equals(getOrganizationId(), myOrganization.getOrganizationId()) &&
              ObjectsCompat.equals(getOrganizationName(), myOrganization.getOrganizationName()) &&
              ObjectsCompat.equals(getOnBoard(), myOrganization.getOnBoard()) &&
              ObjectsCompat.equals(getInviterEmail(), myOrganization.getInviterEmail()) &&
              ObjectsCompat.equals(getLicensePhase(), myOrganization.getLicensePhase()) &&
              ObjectsCompat.equals(getLicenseMainPlans(), myOrganization.getLicenseMainPlans()) &&
              ObjectsCompat.equals(getIsFreePlan(), myOrganization.getIsFreePlan()) &&
              ObjectsCompat.equals(getStorageLocation(), myOrganization.getStorageLocation()) &&
              ObjectsCompat.equals(getIsRequiredMfa(), myOrganization.getIsRequiredMfa()) &&
              ObjectsCompat.equals(getUsername(), myOrganization.getUsername()) &&
              ObjectsCompat.equals(getSnoozeUntil(), myOrganization.getSnoozeUntil()) &&
              ObjectsCompat.equals(getEventDelayTimeSeconds(), myOrganization.getEventDelayTimeSeconds()) &&
              ObjectsCompat.equals(getSupport(), myOrganization.getSupport());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getOrganizationId())
      .append(getOrganizationName())
      .append(getOnBoard())
      .append(getInviterEmail())
      .append(getLicensePhase())
      .append(getLicenseMainPlans())
      .append(getIsFreePlan())
      .append(getStorageLocation())
      .append(getIsRequiredMfa())
      .append(getUsername())
      .append(getSnoozeUntil())
      .append(getEventDelayTimeSeconds())
      .append(getSupport())
      .toString()
      .hashCode();
  }
  
  public static OrganizationIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(organizationID,
      organizationName,
      onBoard,
      inviterEmail,
      licensePhase,
      licenseMainPlans,
      isFreePlan,
      storageLocation,
      isRequiredMFA,
      username,
      snoozeUntil,
      eventDelayTimeSeconds,
      support);
  }
  public interface OrganizationIdStep {
    OrganizationNameStep organizationId(String organizationId);
  }
  

  public interface OrganizationNameStep {
    OnBoardStep organizationName(String organizationName);
  }
  

  public interface OnBoardStep {
    InviterEmailStep onBoard(Boolean onBoard);
  }
  

  public interface InviterEmailStep {
    StorageLocationStep inviterEmail(String inviterEmail);
  }
  

  public interface StorageLocationStep {
    IsRequiredMfaStep storageLocation(Location storageLocation);
  }
  

  public interface IsRequiredMfaStep {
    UsernameStep isRequiredMfa(Boolean isRequiredMfa);
  }
  

  public interface UsernameStep {
    BuildStep username(String username);
  }
  

  public interface BuildStep {
    MyOrganization build();
    BuildStep licensePhase(LicensePhase licensePhase);
    BuildStep licenseMainPlans(List<String> licenseMainPlans);
    BuildStep isFreePlan(Boolean isFreePlan);
    BuildStep snoozeUntil(String snoozeUntil);
    BuildStep eventDelayTimeSeconds(Integer eventDelayTimeSeconds);
    BuildStep support(List<SupportFeature> support);
  }
  

  public static class Builder implements OrganizationIdStep, OrganizationNameStep, OnBoardStep, InviterEmailStep, StorageLocationStep, IsRequiredMfaStep, UsernameStep, BuildStep {
    private String organizationID;
    private String organizationName;
    private Boolean onBoard;
    private String inviterEmail;
    private Location storageLocation;
    private Boolean isRequiredMFA;
    private String username;
    private LicensePhase licensePhase;
    private List<String> licenseMainPlans;
    private Boolean isFreePlan;
    private String snoozeUntil;
    private Integer eventDelayTimeSeconds;
    private List<SupportFeature> support;
    public Builder() {
      
    }
    
    private Builder(String organizationID, String organizationName, Boolean onBoard, String inviterEmail, LicensePhase licensePhase, List<String> licenseMainPlans, Boolean isFreePlan, Location storageLocation, Boolean isRequiredMFA, String username, String snoozeUntil, Integer eventDelayTimeSeconds, List<SupportFeature> support) {
      this.organizationID = organizationID;
      this.organizationName = organizationName;
      this.onBoard = onBoard;
      this.inviterEmail = inviterEmail;
      this.licensePhase = licensePhase;
      this.licenseMainPlans = licenseMainPlans;
      this.isFreePlan = isFreePlan;
      this.storageLocation = storageLocation;
      this.isRequiredMFA = isRequiredMFA;
      this.username = username;
      this.snoozeUntil = snoozeUntil;
      this.eventDelayTimeSeconds = eventDelayTimeSeconds;
      this.support = support;
    }
    
    @Override
     public MyOrganization build() {
        
        return new MyOrganization(
          organizationID,
          organizationName,
          onBoard,
          inviterEmail,
          licensePhase,
          licenseMainPlans,
          isFreePlan,
          storageLocation,
          isRequiredMFA,
          username,
          snoozeUntil,
          eventDelayTimeSeconds,
          support);
    }
    
    @Override
     public OrganizationNameStep organizationId(String organizationId) {
        Objects.requireNonNull(organizationId);
        this.organizationID = organizationId;
        return this;
    }
    
    @Override
     public OnBoardStep organizationName(String organizationName) {
        Objects.requireNonNull(organizationName);
        this.organizationName = organizationName;
        return this;
    }
    
    @Override
     public InviterEmailStep onBoard(Boolean onBoard) {
        Objects.requireNonNull(onBoard);
        this.onBoard = onBoard;
        return this;
    }
    
    @Override
     public StorageLocationStep inviterEmail(String inviterEmail) {
        Objects.requireNonNull(inviterEmail);
        this.inviterEmail = inviterEmail;
        return this;
    }
    
    @Override
     public IsRequiredMfaStep storageLocation(Location storageLocation) {
        Objects.requireNonNull(storageLocation);
        this.storageLocation = storageLocation;
        return this;
    }
    
    @Override
     public UsernameStep isRequiredMfa(Boolean isRequiredMfa) {
        Objects.requireNonNull(isRequiredMfa);
        this.isRequiredMFA = isRequiredMfa;
        return this;
    }
    
    @Override
     public BuildStep username(String username) {
        Objects.requireNonNull(username);
        this.username = username;
        return this;
    }
    
    @Override
     public BuildStep licensePhase(LicensePhase licensePhase) {
        this.licensePhase = licensePhase;
        return this;
    }
    
    @Override
     public BuildStep licenseMainPlans(List<String> licenseMainPlans) {
        this.licenseMainPlans = licenseMainPlans;
        return this;
    }
    
    @Override
     public BuildStep isFreePlan(Boolean isFreePlan) {
        this.isFreePlan = isFreePlan;
        return this;
    }
    
    @Override
     public BuildStep snoozeUntil(String snoozeUntil) {
        this.snoozeUntil = snoozeUntil;
        return this;
    }
    
    @Override
     public BuildStep eventDelayTimeSeconds(Integer eventDelayTimeSeconds) {
        this.eventDelayTimeSeconds = eventDelayTimeSeconds;
        return this;
    }
    
    @Override
     public BuildStep support(List<SupportFeature> support) {
        this.support = support;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String organizationId, String organizationName, Boolean onBoard, String inviterEmail, LicensePhase licensePhase, List<String> licenseMainPlans, Boolean isFreePlan, Location storageLocation, Boolean isRequiredMfa, String username, String snoozeUntil, Integer eventDelayTimeSeconds, List<SupportFeature> support) {
      super(organizationID, organizationName, onBoard, inviterEmail, licensePhase, licenseMainPlans, isFreePlan, storageLocation, isRequiredMFA, username, snoozeUntil, eventDelayTimeSeconds, support);
      Objects.requireNonNull(organizationID);
      Objects.requireNonNull(organizationName);
      Objects.requireNonNull(onBoard);
      Objects.requireNonNull(inviterEmail);
      Objects.requireNonNull(storageLocation);
      Objects.requireNonNull(isRequiredMFA);
      Objects.requireNonNull(username);
    }
    
    @Override
     public CopyOfBuilder organizationId(String organizationId) {
      return (CopyOfBuilder) super.organizationId(organizationId);
    }
    
    @Override
     public CopyOfBuilder organizationName(String organizationName) {
      return (CopyOfBuilder) super.organizationName(organizationName);
    }
    
    @Override
     public CopyOfBuilder onBoard(Boolean onBoard) {
      return (CopyOfBuilder) super.onBoard(onBoard);
    }
    
    @Override
     public CopyOfBuilder inviterEmail(String inviterEmail) {
      return (CopyOfBuilder) super.inviterEmail(inviterEmail);
    }
    
    @Override
     public CopyOfBuilder storageLocation(Location storageLocation) {
      return (CopyOfBuilder) super.storageLocation(storageLocation);
    }
    
    @Override
     public CopyOfBuilder isRequiredMfa(Boolean isRequiredMfa) {
      return (CopyOfBuilder) super.isRequiredMfa(isRequiredMfa);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder licensePhase(LicensePhase licensePhase) {
      return (CopyOfBuilder) super.licensePhase(licensePhase);
    }
    
    @Override
     public CopyOfBuilder licenseMainPlans(List<String> licenseMainPlans) {
      return (CopyOfBuilder) super.licenseMainPlans(licenseMainPlans);
    }
    
    @Override
     public CopyOfBuilder isFreePlan(Boolean isFreePlan) {
      return (CopyOfBuilder) super.isFreePlan(isFreePlan);
    }
    
    @Override
     public CopyOfBuilder snoozeUntil(String snoozeUntil) {
      return (CopyOfBuilder) super.snoozeUntil(snoozeUntil);
    }
    
    @Override
     public CopyOfBuilder eventDelayTimeSeconds(Integer eventDelayTimeSeconds) {
      return (CopyOfBuilder) super.eventDelayTimeSeconds(eventDelayTimeSeconds);
    }
    
    @Override
     public CopyOfBuilder support(List<SupportFeature> support) {
      return (CopyOfBuilder) super.support(support);
    }
  }
  
}
