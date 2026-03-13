package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryAccessControlMessageOutput type in your schema. */
public final class QueryAccessControlMessageOutput {
  private final List<AccessControlWebhookEvent> items;
  private final String nextToken;
  private final Long totalCount;
  public List<AccessControlWebhookEvent> getItems() {
      return items;
  }
  
  public String getNextToken() {
      return nextToken;
  }
  
  public Long getTotalCount() {
      return totalCount;
  }
  
  private QueryAccessControlMessageOutput(List<AccessControlWebhookEvent> items, String nextToken, Long totalCount) {
    this.items = items;
    this.nextToken = nextToken;
    this.totalCount = totalCount;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QueryAccessControlMessageOutput queryAccessControlMessageOutput = (QueryAccessControlMessageOutput) obj;
      return ObjectsCompat.equals(getItems(), queryAccessControlMessageOutput.getItems()) &&
              ObjectsCompat.equals(getNextToken(), queryAccessControlMessageOutput.getNextToken()) &&
              ObjectsCompat.equals(getTotalCount(), queryAccessControlMessageOutput.getTotalCount());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getItems())
      .append(getNextToken())
      .append(getTotalCount())
      .toString()
      .hashCode();
  }
  
  public static ItemsStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(items,
      nextToken,
      totalCount);
  }
  public interface ItemsStep {
    BuildStep items(List<AccessControlWebhookEvent> items);
  }
  

  public interface BuildStep {
    QueryAccessControlMessageOutput build();
    BuildStep nextToken(String nextToken);
    BuildStep totalCount(Long totalCount);
  }
  

  public static class Builder implements ItemsStep, BuildStep {
    private List<AccessControlWebhookEvent> items;
    private String nextToken;
    private Long totalCount;
    public Builder() {
      
    }
    
    private Builder(List<AccessControlWebhookEvent> items, String nextToken, Long totalCount) {
      this.items = items;
      this.nextToken = nextToken;
      this.totalCount = totalCount;
    }
    
    @Override
     public QueryAccessControlMessageOutput build() {
        
        return new QueryAccessControlMessageOutput(
          items,
          nextToken,
          totalCount);
    }
    
    @Override
     public BuildStep items(List<AccessControlWebhookEvent> items) {
        Objects.requireNonNull(items);
        this.items = items;
        return this;
    }
    
    @Override
     public BuildStep nextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    
    @Override
     public BuildStep totalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<AccessControlWebhookEvent> items, String nextToken, Long totalCount) {
      super(items, nextToken, totalCount);
      Objects.requireNonNull(items);
    }
    
    @Override
     public CopyOfBuilder items(List<AccessControlWebhookEvent> items) {
      return (CopyOfBuilder) super.items(items);
    }
    
    @Override
     public CopyOfBuilder nextToken(String nextToken) {
      return (CopyOfBuilder) super.nextToken(nextToken);
    }
    
    @Override
     public CopyOfBuilder totalCount(Long totalCount) {
      return (CopyOfBuilder) super.totalCount(totalCount);
    }
  }
  
}
