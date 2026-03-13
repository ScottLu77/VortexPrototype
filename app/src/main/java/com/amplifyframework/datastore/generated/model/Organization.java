package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Organization type in your schema. */
public final class Organization {
  private final String id;
  private final String name;
  private final String owner;
  private final Boolean isFreePlan;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getOwner() {
      return owner;
  }
  
  public Boolean getIsFreePlan() {
      return isFreePlan;
  }
  
  private Organization(String id, String name, String owner, Boolean isFreePlan) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.isFreePlan = isFreePlan;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Organization organization = (Organization) obj;
      return ObjectsCompat.equals(getId(), organization.getId()) &&
              ObjectsCompat.equals(getName(), organization.getName()) &&
              ObjectsCompat.equals(getOwner(), organization.getOwner()) &&
              ObjectsCompat.equals(getIsFreePlan(), organization.getIsFreePlan());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getOwner())
      .append(getIsFreePlan())
      .toString()
      .hashCode();
  }
  
  public static IdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      owner,
      isFreePlan);
  }
  public interface IdStep {
    NameStep id(String id);
  }
  

  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    Organization build();
    BuildStep owner(String owner);
    BuildStep isFreePlan(Boolean isFreePlan);
  }
  

  public static class Builder implements IdStep, NameStep, BuildStep {
    private String id;
    private String name;
    private String owner;
    private Boolean isFreePlan;
    public Builder() {
      
    }
    
    private Builder(String id, String name, String owner, Boolean isFreePlan) {
      this.id = id;
      this.name = name;
      this.owner = owner;
      this.isFreePlan = isFreePlan;
    }
    
    @Override
     public Organization build() {
        
        return new Organization(
          id,
          name,
          owner,
          isFreePlan);
    }
    
    @Override
     public NameStep id(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep owner(String owner) {
        this.owner = owner;
        return this;
    }
    
    @Override
     public BuildStep isFreePlan(Boolean isFreePlan) {
        this.isFreePlan = isFreePlan;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String owner, Boolean isFreePlan) {
      super(id, name, owner, isFreePlan);
      Objects.requireNonNull(id);
      Objects.requireNonNull(name);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }
    
    @Override
     public CopyOfBuilder isFreePlan(Boolean isFreePlan) {
      return (CopyOfBuilder) super.isFreePlan(isFreePlan);
    }
  }
  
}
