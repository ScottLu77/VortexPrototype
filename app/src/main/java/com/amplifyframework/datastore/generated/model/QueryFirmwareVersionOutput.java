package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryFirmwareVersionOutput type in your schema. */
public final class QueryFirmwareVersionOutput {
  private final String currentVersion;
  private final String targetVersion;
  private final String releaseNote;
  public String getCurrentVersion() {
      return currentVersion;
  }
  
  public String getTargetVersion() {
      return targetVersion;
  }
  
  public String getReleaseNote() {
      return releaseNote;
  }
  
  private QueryFirmwareVersionOutput(String currentVersion, String targetVersion, String releaseNote) {
    this.currentVersion = currentVersion;
    this.targetVersion = targetVersion;
    this.releaseNote = releaseNote;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryFirmwareVersionOutput queryFirmwareVersionOutput = (QueryFirmwareVersionOutput) obj;
      return ObjectsCompat.equals(getCurrentVersion(), queryFirmwareVersionOutput.getCurrentVersion()) &&
              ObjectsCompat.equals(getTargetVersion(), queryFirmwareVersionOutput.getTargetVersion()) &&
              ObjectsCompat.equals(getReleaseNote(), queryFirmwareVersionOutput.getReleaseNote());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getCurrentVersion())
      .append(getTargetVersion())
      .append(getReleaseNote())
      .toString()
      .hashCode();
  }
  
  public static CurrentVersionStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(currentVersion,
      targetVersion,
      releaseNote);
  }
  public interface CurrentVersionStep {
    TargetVersionStep currentVersion(String currentVersion);
  }
  

  public interface TargetVersionStep {
    ReleaseNoteStep targetVersion(String targetVersion);
  }
  

  public interface ReleaseNoteStep {
    BuildStep releaseNote(String releaseNote);
  }
  

  public interface BuildStep {
    QueryFirmwareVersionOutput build();
  }
  

  public static class Builder implements CurrentVersionStep, TargetVersionStep, ReleaseNoteStep, BuildStep {
    private String currentVersion;
    private String targetVersion;
    private String releaseNote;
    public Builder() {
      
    }
    
    private Builder(String currentVersion, String targetVersion, String releaseNote) {
      this.currentVersion = currentVersion;
      this.targetVersion = targetVersion;
      this.releaseNote = releaseNote;
    }
    
    @Override
     public QueryFirmwareVersionOutput build() {
        
        return new QueryFirmwareVersionOutput(
          currentVersion,
          targetVersion,
          releaseNote);
    }
    
    @Override
     public TargetVersionStep currentVersion(String currentVersion) {
        Objects.requireNonNull(currentVersion);
        this.currentVersion = currentVersion;
        return this;
    }
    
    @Override
     public ReleaseNoteStep targetVersion(String targetVersion) {
        Objects.requireNonNull(targetVersion);
        this.targetVersion = targetVersion;
        return this;
    }
    
    @Override
     public BuildStep releaseNote(String releaseNote) {
        Objects.requireNonNull(releaseNote);
        this.releaseNote = releaseNote;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String currentVersion, String targetVersion, String releaseNote) {
      super(currentVersion, targetVersion, releaseNote);
      Objects.requireNonNull(currentVersion);
      Objects.requireNonNull(targetVersion);
      Objects.requireNonNull(releaseNote);
    }
    
    @Override
     public CopyOfBuilder currentVersion(String currentVersion) {
      return (CopyOfBuilder) super.currentVersion(currentVersion);
    }
    
    @Override
     public CopyOfBuilder targetVersion(String targetVersion) {
      return (CopyOfBuilder) super.targetVersion(targetVersion);
    }
    
    @Override
     public CopyOfBuilder releaseNote(String releaseNote) {
      return (CopyOfBuilder) super.releaseNote(releaseNote);
    }
  }
  
}
