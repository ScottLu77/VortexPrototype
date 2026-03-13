package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryAccessControlIntegrationOutput type in your schema. */
public final class QueryAccessControlIntegrationOutput {
  private final AccessControlProvider provider;
  private final String integrationId;
  public AccessControlProvider getProvider() {
      return provider;
  }
  
  public String getIntegrationId() {
      return integrationId;
  }
  
  private QueryAccessControlIntegrationOutput(AccessControlProvider provider, String integrationId) {
    this.provider = provider;
    this.integrationId = integrationId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryAccessControlIntegrationOutput queryAccessControlIntegrationOutput = (QueryAccessControlIntegrationOutput) obj;
      return ObjectsCompat.equals(getProvider(), queryAccessControlIntegrationOutput.getProvider()) &&
              ObjectsCompat.equals(getIntegrationId(), queryAccessControlIntegrationOutput.getIntegrationId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getProvider())
      .append(getIntegrationId())
      .toString()
      .hashCode();
  }
  
  public static ProviderStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(provider,
      integrationId);
  }
  public interface ProviderStep {
    BuildStep provider(AccessControlProvider provider);
  }
  

  public interface BuildStep {
    QueryAccessControlIntegrationOutput build();
    BuildStep integrationId(String integrationId);
  }
  

  public static class Builder implements ProviderStep, BuildStep {
    private AccessControlProvider provider;
    private String integrationId;
    public Builder() {
      
    }
    
    private Builder(AccessControlProvider provider, String integrationId) {
      this.provider = provider;
      this.integrationId = integrationId;
    }
    
    @Override
     public QueryAccessControlIntegrationOutput build() {
        
        return new QueryAccessControlIntegrationOutput(
          provider,
          integrationId);
    }
    
    @Override
     public BuildStep provider(AccessControlProvider provider) {
        Objects.requireNonNull(provider);
        this.provider = provider;
        return this;
    }
    
    @Override
     public BuildStep integrationId(String integrationId) {
        this.integrationId = integrationId;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(AccessControlProvider provider, String integrationId) {
      super(provider, integrationId);
      Objects.requireNonNull(provider);
    }
    
    @Override
     public CopyOfBuilder provider(AccessControlProvider provider) {
      return (CopyOfBuilder) super.provider(provider);
    }
    
    @Override
     public CopyOfBuilder integrationId(String integrationId) {
      return (CopyOfBuilder) super.integrationId(integrationId);
    }
  }
  
}
