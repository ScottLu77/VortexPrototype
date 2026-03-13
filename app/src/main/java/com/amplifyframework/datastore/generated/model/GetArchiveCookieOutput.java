package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GetArchiveCookieOutput type in your schema. */
public final class GetArchiveCookieOutput {
  private final String cookie;
  private final String err;
  public String getCookie() {
      return cookie;
  }
  
  public String getErr() {
      return err;
  }
  
  private GetArchiveCookieOutput(String cookie, String err) {
    this.cookie = cookie;
    this.err = err;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GetArchiveCookieOutput getArchiveCookieOutput = (GetArchiveCookieOutput) obj;
      return ObjectsCompat.equals(getCookie(), getArchiveCookieOutput.getCookie()) &&
              ObjectsCompat.equals(getErr(), getArchiveCookieOutput.getErr());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getCookie())
      .append(getErr())
      .toString()
      .hashCode();
  }
  
  public static CookieStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(cookie,
      err);
  }
  public interface CookieStep {
    BuildStep cookie(String cookie);
  }
  

  public interface BuildStep {
    GetArchiveCookieOutput build();
    BuildStep err(String err);
  }
  

  public static class Builder implements CookieStep, BuildStep {
    private String cookie;
    private String err;
    public Builder() {
      
    }
    
    private Builder(String cookie, String err) {
      this.cookie = cookie;
      this.err = err;
    }
    
    @Override
     public GetArchiveCookieOutput build() {
        
        return new GetArchiveCookieOutput(
          cookie,
          err);
    }
    
    @Override
     public BuildStep cookie(String cookie) {
        Objects.requireNonNull(cookie);
        this.cookie = cookie;
        return this;
    }
    
    @Override
     public BuildStep err(String err) {
        this.err = err;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String cookie, String err) {
      super(cookie, err);
      Objects.requireNonNull(cookie);
    }
    
    @Override
     public CopyOfBuilder cookie(String cookie) {
      return (CopyOfBuilder) super.cookie(cookie);
    }
    
    @Override
     public CopyOfBuilder err(String err) {
      return (CopyOfBuilder) super.err(err);
    }
  }
  
}
