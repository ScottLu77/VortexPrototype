package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GetCardHolderInfoOutput type in your schema. */
public final class GetCardHolderInfoOutput {
  private final String userId;
  private final String userName;
  private final String userEmail;
  private final String userImage;
  public String getUserId() {
      return userId;
  }
  
  public String getUserName() {
      return userName;
  }
  
  public String getUserEmail() {
      return userEmail;
  }
  
  public String getUserImage() {
      return userImage;
  }
  
  private GetCardHolderInfoOutput(String userId, String userName, String userEmail, String userImage) {
    this.userId = userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.userImage = userImage;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GetCardHolderInfoOutput getCardHolderInfoOutput = (GetCardHolderInfoOutput) obj;
      return ObjectsCompat.equals(getUserId(), getCardHolderInfoOutput.getUserId()) &&
              ObjectsCompat.equals(getUserName(), getCardHolderInfoOutput.getUserName()) &&
              ObjectsCompat.equals(getUserEmail(), getCardHolderInfoOutput.getUserEmail()) &&
              ObjectsCompat.equals(getUserImage(), getCardHolderInfoOutput.getUserImage());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getUserId())
      .append(getUserName())
      .append(getUserEmail())
      .append(getUserImage())
      .toString()
      .hashCode();
  }
  
  public static UserIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(userId,
      userName,
      userEmail,
      userImage);
  }
  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    GetCardHolderInfoOutput build();
    BuildStep userName(String userName);
    BuildStep userEmail(String userEmail);
    BuildStep userImage(String userImage);
  }
  

  public static class Builder implements UserIdStep, BuildStep {
    private String userId;
    private String userName;
    private String userEmail;
    private String userImage;
    public Builder() {
      
    }
    
    private Builder(String userId, String userName, String userEmail, String userImage) {
      this.userId = userId;
      this.userName = userName;
      this.userEmail = userEmail;
      this.userImage = userImage;
    }
    
    @Override
     public GetCardHolderInfoOutput build() {
        
        return new GetCardHolderInfoOutput(
          userId,
          userName,
          userEmail,
          userImage);
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userId = userId;
        return this;
    }
    
    @Override
     public BuildStep userName(String userName) {
        this.userName = userName;
        return this;
    }
    
    @Override
     public BuildStep userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }
    
    @Override
     public BuildStep userImage(String userImage) {
        this.userImage = userImage;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String userId, String userName, String userEmail, String userImage) {
      super(userId, userName, userEmail, userImage);
      Objects.requireNonNull(userId);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder userName(String userName) {
      return (CopyOfBuilder) super.userName(userName);
    }
    
    @Override
     public CopyOfBuilder userEmail(String userEmail) {
      return (CopyOfBuilder) super.userEmail(userEmail);
    }
    
    @Override
     public CopyOfBuilder userImage(String userImage) {
      return (CopyOfBuilder) super.userImage(userImage);
    }
  }
  
}
