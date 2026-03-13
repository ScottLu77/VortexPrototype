package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the CreateSnoozeRuleResponse type in your schema. */
public final class CreateSnoozeRuleResponse {
  private final String id;
  public String getId() {
      return id;
  }
  
  private CreateSnoozeRuleResponse(String id) {
    this.id = id;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      CreateSnoozeRuleResponse createSnoozeRuleResponse = (CreateSnoozeRuleResponse) obj;
      return ObjectsCompat.equals(getId(), createSnoozeRuleResponse.getId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .toString()
      .hashCode();
  }
  
  public static IdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id);
  }
  public interface IdStep {
    BuildStep id(String id);
  }
  

  public interface BuildStep {
    CreateSnoozeRuleResponse build();
  }
  

  public static class Builder implements IdStep, BuildStep {
    private String id;
    public Builder() {
      
    }
    
    private Builder(String id) {
      this.id = id;
    }
    
    @Override
     public CreateSnoozeRuleResponse build() {
        
        return new CreateSnoozeRuleResponse(
          id);
    }
    
    @Override
     public BuildStep id(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id) {
      super(id);
      Objects.requireNonNull(id);
    }
    
    @Override
     public CopyOfBuilder id(String id) {
      return (CopyOfBuilder) super.id(id);
    }
  }
  
}
