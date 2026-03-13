package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the PauseOrganizationAlarmSettingOutput type in your schema. */
public final class PauseOrganizationAlarmSettingOutput {
  private final String pauseUntil;
  public String getPauseUntil() {
      return pauseUntil;
  }
  
  private PauseOrganizationAlarmSettingOutput(String pauseUntil) {
    this.pauseUntil = pauseUntil;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PauseOrganizationAlarmSettingOutput pauseOrganizationAlarmSettingOutput = (PauseOrganizationAlarmSettingOutput) obj;
      return ObjectsCompat.equals(getPauseUntil(), pauseOrganizationAlarmSettingOutput.getPauseUntil());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getPauseUntil())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(pauseUntil);
  }
  public interface BuildStep {
    PauseOrganizationAlarmSettingOutput build();
    BuildStep pauseUntil(String pauseUntil);
  }
  

  public static class Builder implements BuildStep {
    private String pauseUntil;
    public Builder() {
      
    }
    
    private Builder(String pauseUntil) {
      this.pauseUntil = pauseUntil;
    }
    
    @Override
     public PauseOrganizationAlarmSettingOutput build() {
        
        return new PauseOrganizationAlarmSettingOutput(
          pauseUntil);
    }
    
    @Override
     public BuildStep pauseUntil(String pauseUntil) {
        this.pauseUntil = pauseUntil;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String pauseUntil) {
      super(pauseUntil);
      
    }
    
    @Override
     public CopyOfBuilder pauseUntil(String pauseUntil) {
      return (CopyOfBuilder) super.pauseUntil(pauseUntil);
    }
  }
  
}
