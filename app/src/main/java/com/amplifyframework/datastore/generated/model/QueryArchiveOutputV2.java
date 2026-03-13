package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryArchiveOutputV2 type in your schema. */
public final class QueryArchiveOutputV2 {
  private final List<Archive> items;
  public List<Archive> getItems() {
      return items;
  }
  
  private QueryArchiveOutputV2(List<Archive> items) {
    this.items = items;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryArchiveOutputV2 queryArchiveOutputV2 = (QueryArchiveOutputV2) obj;
      return ObjectsCompat.equals(getItems(), queryArchiveOutputV2.getItems());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getItems())
      .toString()
      .hashCode();
  }
  
  public static ItemsStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(items);
  }
  public interface ItemsStep {
    BuildStep items(List<Archive> items);
  }
  

  public interface BuildStep {
    QueryArchiveOutputV2 build();
  }
  

  public static class Builder implements ItemsStep, BuildStep {
    private List<Archive> items;
    public Builder() {
      
    }
    
    private Builder(List<Archive> items) {
      this.items = items;
    }
    
    @Override
     public QueryArchiveOutputV2 build() {
        
        return new QueryArchiveOutputV2(
          items);
    }
    
    @Override
     public BuildStep items(List<Archive> items) {
        Objects.requireNonNull(items);
        this.items = items;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<Archive> items) {
      super(items);
      Objects.requireNonNull(items);
    }
    
    @Override
     public CopyOfBuilder items(List<Archive> items) {
      return (CopyOfBuilder) super.items(items);
    }
  }
  
}
