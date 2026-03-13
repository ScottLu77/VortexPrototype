package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QuerySSOProviderOutput type in your schema. */
public final class QuerySSOProviderOutput {
  private final String provider;
  public String getProvider() {
      return provider;
  }
  
  private QuerySSOProviderOutput(String provider) {
    this.provider = provider;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QuerySSOProviderOutput querySsoProviderOutput = (QuerySSOProviderOutput) obj;
      return ObjectsCompat.equals(getProvider(), querySsoProviderOutput.getProvider());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getProvider())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(provider);
  }
  public interface BuildStep {
    QuerySSOProviderOutput build();
    BuildStep provider(String provider);
  }
  

  public static class Builder implements BuildStep {
    private String provider;
    public Builder() {
      
    }
    
    private Builder(String provider) {
      this.provider = provider;
    }
    
    @Override
     public QuerySSOProviderOutput build() {
        
        return new QuerySSOProviderOutput(
          provider);
    }
    
    @Override
     public BuildStep provider(String provider) {
        this.provider = provider;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String provider) {
      super(provider);
      
    }
    
    @Override
     public CopyOfBuilder provider(String provider) {
      return (CopyOfBuilder) super.provider(provider);
    }
  }
  
}
