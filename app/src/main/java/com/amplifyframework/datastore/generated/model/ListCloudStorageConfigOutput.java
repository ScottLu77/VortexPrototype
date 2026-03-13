package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the ListCloudStorageConfigOutput type in your schema. */
public final class ListCloudStorageConfigOutput {
  private final List<CloudStorage> items;
  public List<CloudStorage> getItems() {
      return items;
  }
  
  private ListCloudStorageConfigOutput(List<CloudStorage> items) {
    this.items = items;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ListCloudStorageConfigOutput listCloudStorageConfigOutput = (ListCloudStorageConfigOutput) obj;
      return ObjectsCompat.equals(getItems(), listCloudStorageConfigOutput.getItems());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getItems())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(items);
  }
  public interface BuildStep {
    ListCloudStorageConfigOutput build();
    BuildStep items(List<CloudStorage> items);
  }
  

  public static class Builder implements BuildStep {
    private List<CloudStorage> items;
    public Builder() {
      
    }
    
    private Builder(List<CloudStorage> items) {
      this.items = items;
    }
    
    @Override
     public ListCloudStorageConfigOutput build() {
        
        return new ListCloudStorageConfigOutput(
          items);
    }
    
    @Override
     public BuildStep items(List<CloudStorage> items) {
        this.items = items;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<CloudStorage> items) {
      super(items);
      
    }
    
    @Override
     public CopyOfBuilder items(List<CloudStorage> items) {
      return (CopyOfBuilder) super.items(items);
    }
  }
  
}
