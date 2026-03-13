package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the StartWorkingInOrganizationOutput type in your schema. */
public final class StartWorkingInOrganizationOutput {
  private final Boolean res;
  public Boolean getRes() {
      return res;
  }
  
  private StartWorkingInOrganizationOutput(Boolean res) {
    this.res = res;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      StartWorkingInOrganizationOutput startWorkingInOrganizationOutput = (StartWorkingInOrganizationOutput) obj;
      return ObjectsCompat.equals(getRes(), startWorkingInOrganizationOutput.getRes());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getRes())
      .toString()
      .hashCode();
  }
  
  public static ResStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(res);
  }
  public interface ResStep {
    BuildStep res(Boolean res);
  }
  

  public interface BuildStep {
    StartWorkingInOrganizationOutput build();
  }
  

  public static class Builder implements ResStep, BuildStep {
    private Boolean res;
    public Builder() {
      
    }
    
    private Builder(Boolean res) {
      this.res = res;
    }
    
    @Override
     public StartWorkingInOrganizationOutput build() {
        
        return new StartWorkingInOrganizationOutput(
          res);
    }
    
    @Override
     public BuildStep res(Boolean res) {
        Objects.requireNonNull(res);
        this.res = res;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Boolean res) {
      super(res);
      Objects.requireNonNull(res);
    }
    
    @Override
     public CopyOfBuilder res(Boolean res) {
      return (CopyOfBuilder) super.res(res);
    }
  }
  
}
