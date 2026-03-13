package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the ListMyOrganizationOutput type in your schema. */
public final class ListMyOrganizationOutput {
  private final List<MyOrganization> items;
  public List<MyOrganization> getItems() {
      return items;
  }
  
  private ListMyOrganizationOutput(List<MyOrganization> items) {
    this.items = items;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ListMyOrganizationOutput listMyOrganizationOutput = (ListMyOrganizationOutput) obj;
      return ObjectsCompat.equals(getItems(), listMyOrganizationOutput.getItems());
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
    ListMyOrganizationOutput build();
    BuildStep items(List<MyOrganization> items);
  }
  

  public static class Builder implements BuildStep {
    private List<MyOrganization> items;
    public Builder() {
      
    }
    
    private Builder(List<MyOrganization> items) {
      this.items = items;
    }
    
    @Override
     public ListMyOrganizationOutput build() {
        
        return new ListMyOrganizationOutput(
          items);
    }
    
    @Override
     public BuildStep items(List<MyOrganization> items) {
        this.items = items;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<MyOrganization> items) {
      super(items);
      
    }
    
    @Override
     public CopyOfBuilder items(List<MyOrganization> items) {
      return (CopyOfBuilder) super.items(items);
    }
  }
  
}
