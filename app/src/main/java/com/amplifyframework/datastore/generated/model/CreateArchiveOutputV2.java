package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the CreateArchiveOutputV2 type in your schema. */
public final class CreateArchiveOutputV2 {
  private final Archive archive;
  private final Boolean res;
  public Archive getArchive() {
      return archive;
  }
  
  public Boolean getRes() {
      return res;
  }
  
  private CreateArchiveOutputV2(Archive archive, Boolean res) {
    this.archive = archive;
    this.res = res;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      CreateArchiveOutputV2 createArchiveOutputV2 = (CreateArchiveOutputV2) obj;
      return ObjectsCompat.equals(getArchive(), createArchiveOutputV2.getArchive()) &&
              ObjectsCompat.equals(getRes(), createArchiveOutputV2.getRes());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getArchive())
      .append(getRes())
      .toString()
      .hashCode();
  }
  
  public static ResStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(archive,
      res);
  }
  public interface ResStep {
    BuildStep res(Boolean res);
  }
  

  public interface BuildStep {
    CreateArchiveOutputV2 build();
    BuildStep archive(Archive archive);
  }
  

  public static class Builder implements ResStep, BuildStep {
    private Boolean res;
    private Archive archive;
    public Builder() {
      
    }
    
    private Builder(Archive archive, Boolean res) {
      this.archive = archive;
      this.res = res;
    }
    
    @Override
     public CreateArchiveOutputV2 build() {
        
        return new CreateArchiveOutputV2(
          archive,
          res);
    }
    
    @Override
     public BuildStep res(Boolean res) {
        Objects.requireNonNull(res);
        this.res = res;
        return this;
    }
    
    @Override
     public BuildStep archive(Archive archive) {
        this.archive = archive;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Archive archive, Boolean res) {
      super(archive, res);
      Objects.requireNonNull(res);
    }
    
    @Override
     public CopyOfBuilder res(Boolean res) {
      return (CopyOfBuilder) super.res(res);
    }
    
    @Override
     public CopyOfBuilder archive(Archive archive) {
      return (CopyOfBuilder) super.archive(archive);
    }
  }
  
}
