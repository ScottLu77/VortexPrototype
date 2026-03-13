package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the HTTPHeader type in your schema. */
public final class HTTPHeader {
  private final String key;
  private final String value;
  public String getKey() {
      return key;
  }
  
  public String getValue() {
      return value;
  }
  
  private HTTPHeader(String key, String value) {
    this.key = key;
    this.value = value;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      HTTPHeader httpHeader = (HTTPHeader) obj;
      return ObjectsCompat.equals(getKey(), httpHeader.getKey()) &&
              ObjectsCompat.equals(getValue(), httpHeader.getValue());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getKey())
      .append(getValue())
      .toString()
      .hashCode();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(key,
      value);
  }
  public interface BuildStep {
    HTTPHeader build();
    BuildStep key(String key);
    BuildStep value(String value);
  }
  

  public static class Builder implements BuildStep {
    private String key;
    private String value;
    public Builder() {
      
    }
    
    private Builder(String key, String value) {
      this.key = key;
      this.value = value;
    }
    
    @Override
     public HTTPHeader build() {
        
        return new HTTPHeader(
          key,
          value);
    }
    
    @Override
     public BuildStep key(String key) {
        this.key = key;
        return this;
    }
    
    @Override
     public BuildStep value(String value) {
        this.value = value;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String key, String value) {
      super(key, value);
      
    }
    
    @Override
     public CopyOfBuilder key(String key) {
      return (CopyOfBuilder) super.key(key);
    }
    
    @Override
     public CopyOfBuilder value(String value) {
      return (CopyOfBuilder) super.value(value);
    }
  }
  
}
