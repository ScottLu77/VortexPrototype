package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the SetUserMFAOutput type in your schema. */
public final class SetUserMFAOutput {
  private final Boolean res;
  public Boolean getRes() {
      return res;
  }
  
  private SetUserMFAOutput(Boolean res) {
    this.res = res;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SetUserMFAOutput setUserMfaOutput = (SetUserMFAOutput) obj;
      return ObjectsCompat.equals(getRes(), setUserMfaOutput.getRes());
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
    SetUserMFAOutput build();
  }
  

  public static class Builder implements ResStep, BuildStep {
    private Boolean res;
    public Builder() {
      
    }
    
    private Builder(Boolean res) {
      this.res = res;
    }
    
    @Override
     public SetUserMFAOutput build() {
        
        return new SetUserMFAOutput(
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
