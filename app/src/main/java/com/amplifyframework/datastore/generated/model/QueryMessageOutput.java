package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the QueryMessageOutput type in your schema. */
public final class QueryMessageOutput {
  private final List<MessageItem> items;
  private final String nextToken;
  private final Integer totalCount;
  public List<MessageItem> getItems() {
      return items;
  }
  
  public String getNextToken() {
      return nextToken;
  }
  
  public Integer getTotalCount() {
      return totalCount;
  }
  
  private QueryMessageOutput(List<MessageItem> items, String nextToken, Integer totalCount) {
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
      QueryMessageOutput queryMessageOutput = (QueryMessageOutput) obj;
      return ObjectsCompat.equals(getItems(), queryMessageOutput.getItems()) &&
              ObjectsCompat.equals(getNextToken(), queryMessageOutput.getNextToken()) &&
              ObjectsCompat.equals(getTotalCount(), queryMessageOutput.getTotalCount());
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
    TotalCountStep items(List<MessageItem> items);
  }
  

  public interface TotalCountStep {
    BuildStep totalCount(Integer totalCount);
  }
  

  public interface BuildStep {
    QueryMessageOutput build();
    BuildStep nextToken(String nextToken);
  }
  

  public static class Builder implements ItemsStep, TotalCountStep, BuildStep {
    private List<MessageItem> items;
    private Integer totalCount;
    private String nextToken;
    public Builder() {
      
    }
    
    private Builder(List<MessageItem> items, String nextToken, Integer totalCount) {
      this.items = items;
      this.nextToken = nextToken;
      this.totalCount = totalCount;
    }
    
    @Override
     public QueryMessageOutput build() {
        
        return new QueryMessageOutput(
          items,
          nextToken,
          totalCount);
    }
    
    @Override
     public TotalCountStep items(List<MessageItem> items) {
        Objects.requireNonNull(items);
        this.items = items;
        return this;
    }
    
    @Override
     public BuildStep totalCount(Integer totalCount) {
        Objects.requireNonNull(totalCount);
        this.totalCount = totalCount;
        return this;
    }
    
    @Override
     public BuildStep nextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(List<MessageItem> items, String nextToken, Integer totalCount) {
      super(items, nextToken, totalCount);
      Objects.requireNonNull(items);
      Objects.requireNonNull(totalCount);
    }
    
    @Override
     public CopyOfBuilder items(List<MessageItem> items) {
      return (CopyOfBuilder) super.items(items);
    }
    
    @Override
     public CopyOfBuilder totalCount(Integer totalCount) {
      return (CopyOfBuilder) super.totalCount(totalCount);
    }
    
    @Override
     public CopyOfBuilder nextToken(String nextToken) {
      return (CopyOfBuilder) super.nextToken(nextToken);
    }
  }
  
}
