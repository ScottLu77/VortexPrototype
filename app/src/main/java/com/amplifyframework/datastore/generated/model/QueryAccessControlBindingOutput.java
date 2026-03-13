package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryAccessControlBindingOutput type in your schema. */
public final class QueryAccessControlBindingOutput {
  private final AccessControlProvider provider;
  private final LatestAccessControlObjects latest;
  private final CurrentAccessControlBinding binding;
  public AccessControlProvider getProvider() {
      return provider;
  }
  
  public LatestAccessControlObjects getLatest() {
      return latest;
  }
  
  public CurrentAccessControlBinding getBinding() {
      return binding;
  }
  
  private QueryAccessControlBindingOutput(AccessControlProvider provider, LatestAccessControlObjects latest, CurrentAccessControlBinding binding) {
    this.provider = provider;
    this.latest = latest;
    this.binding = binding;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryAccessControlBindingOutput queryAccessControlBindingOutput = (QueryAccessControlBindingOutput) obj;
      return ObjectsCompat.equals(getProvider(), queryAccessControlBindingOutput.getProvider()) &&
              ObjectsCompat.equals(getLatest(), queryAccessControlBindingOutput.getLatest()) &&
              ObjectsCompat.equals(getBinding(), queryAccessControlBindingOutput.getBinding());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getProvider())
      .append(getLatest())
      .append(getBinding())
      .toString()
      .hashCode();
  }
  
  public static ProviderStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(provider,
      latest,
      binding);
  }
  public interface ProviderStep {
    LatestStep provider(AccessControlProvider provider);
  }
  

  public interface LatestStep {
    BindingStep latest(LatestAccessControlObjects latest);
  }
  

  public interface BindingStep {
    BuildStep binding(CurrentAccessControlBinding binding);
  }
  

  public interface BuildStep {
    QueryAccessControlBindingOutput build();
  }
  

  public static class Builder implements ProviderStep, LatestStep, BindingStep, BuildStep {
    private AccessControlProvider provider;
    private LatestAccessControlObjects latest;
    private CurrentAccessControlBinding binding;
    public Builder() {
      
    }
    
    private Builder(AccessControlProvider provider, LatestAccessControlObjects latest, CurrentAccessControlBinding binding) {
      this.provider = provider;
      this.latest = latest;
      this.binding = binding;
    }
    
    @Override
     public QueryAccessControlBindingOutput build() {
        
        return new QueryAccessControlBindingOutput(
          provider,
          latest,
          binding);
    }
    
    @Override
     public LatestStep provider(AccessControlProvider provider) {
        Objects.requireNonNull(provider);
        this.provider = provider;
        return this;
    }
    
    @Override
     public BindingStep latest(LatestAccessControlObjects latest) {
        Objects.requireNonNull(latest);
        this.latest = latest;
        return this;
    }
    
    @Override
     public BuildStep binding(CurrentAccessControlBinding binding) {
        Objects.requireNonNull(binding);
        this.binding = binding;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(AccessControlProvider provider, LatestAccessControlObjects latest, CurrentAccessControlBinding binding) {
      super(provider, latest, binding);
      Objects.requireNonNull(provider);
      Objects.requireNonNull(latest);
      Objects.requireNonNull(binding);
    }
    
    @Override
     public CopyOfBuilder provider(AccessControlProvider provider) {
      return (CopyOfBuilder) super.provider(provider);
    }
    
    @Override
     public CopyOfBuilder latest(LatestAccessControlObjects latest) {
      return (CopyOfBuilder) super.latest(latest);
    }
    
    @Override
     public CopyOfBuilder binding(CurrentAccessControlBinding binding) {
      return (CopyOfBuilder) super.binding(binding);
    }
  }
  
}
