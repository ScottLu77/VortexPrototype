package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryUserMFAOutput type in your schema. */
public final class QueryUserMFAOutput {
  private final Boolean enableMFA;
  public Boolean getEnableMfa() {
      return enableMFA;
  }
  
  private QueryUserMFAOutput(Boolean enableMFA) {
    this.enableMFA = enableMFA;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryUserMFAOutput queryUserMfaOutput = (QueryUserMFAOutput) obj;
      return ObjectsCompat.equals(getEnableMfa(), queryUserMfaOutput.getEnableMfa());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getEnableMfa())
      .toString()
      .hashCode();
  }
  
  public static EnableMfaStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(enableMFA);
  }
  public interface EnableMfaStep {
    BuildStep enableMfa(Boolean enableMfa);
  }
  

  public interface BuildStep {
    QueryUserMFAOutput build();
  }
  

  public static class Builder implements EnableMfaStep, BuildStep {
    private Boolean enableMFA;
    public Builder() {
      
    }
    
    private Builder(Boolean enableMFA) {
      this.enableMFA = enableMFA;
    }
    
    @Override
     public QueryUserMFAOutput build() {
        
        return new QueryUserMFAOutput(
          enableMFA);
    }
    
    @Override
     public BuildStep enableMfa(Boolean enableMfa) {
        Objects.requireNonNull(enableMfa);
        this.enableMFA = enableMfa;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Boolean enableMfa) {
      super(enableMFA);
      Objects.requireNonNull(enableMFA);
    }
    
    @Override
     public CopyOfBuilder enableMfa(Boolean enableMfa) {
      return (CopyOfBuilder) super.enableMfa(enableMfa);
    }
  }
  
}
