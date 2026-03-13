package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the GetNvrRelayInfoOutput type in your schema. */
public final class GetNvrRelayInfoOutput {
  private final String proxyServerAddress;
  private final String proxyDomain;
  private final String traceId;
  public String getProxyServerAddress() {
      return proxyServerAddress;
  }
  
  public String getProxyDomain() {
      return proxyDomain;
  }
  
  public String getTraceId() {
      return traceId;
  }
  
  private GetNvrRelayInfoOutput(String proxyServerAddress, String proxyDomain, String traceId) {
    this.proxyServerAddress = proxyServerAddress;
    this.proxyDomain = proxyDomain;
    this.traceId = traceId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      GetNvrRelayInfoOutput getNvrRelayInfoOutput = (GetNvrRelayInfoOutput) obj;
      return ObjectsCompat.equals(getProxyServerAddress(), getNvrRelayInfoOutput.getProxyServerAddress()) &&
              ObjectsCompat.equals(getProxyDomain(), getNvrRelayInfoOutput.getProxyDomain()) &&
              ObjectsCompat.equals(getTraceId(), getNvrRelayInfoOutput.getTraceId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getProxyServerAddress())
      .append(getProxyDomain())
      .append(getTraceId())
      .toString()
      .hashCode();
  }
  
  public static ProxyServerAddressStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(proxyServerAddress,
      proxyDomain,
      traceId);
  }
  public interface ProxyServerAddressStep {
    ProxyDomainStep proxyServerAddress(String proxyServerAddress);
  }
  

  public interface ProxyDomainStep {
    TraceIdStep proxyDomain(String proxyDomain);
  }
  

  public interface TraceIdStep {
    BuildStep traceId(String traceId);
  }
  

  public interface BuildStep {
    GetNvrRelayInfoOutput build();
  }
  

  public static class Builder implements ProxyServerAddressStep, ProxyDomainStep, TraceIdStep, BuildStep {
    private String proxyServerAddress;
    private String proxyDomain;
    private String traceId;
    public Builder() {
      
    }
    
    private Builder(String proxyServerAddress, String proxyDomain, String traceId) {
      this.proxyServerAddress = proxyServerAddress;
      this.proxyDomain = proxyDomain;
      this.traceId = traceId;
    }
    
    @Override
     public GetNvrRelayInfoOutput build() {
        
        return new GetNvrRelayInfoOutput(
          proxyServerAddress,
          proxyDomain,
          traceId);
    }
    
    @Override
     public ProxyDomainStep proxyServerAddress(String proxyServerAddress) {
        Objects.requireNonNull(proxyServerAddress);
        this.proxyServerAddress = proxyServerAddress;
        return this;
    }
    
    @Override
     public TraceIdStep proxyDomain(String proxyDomain) {
        Objects.requireNonNull(proxyDomain);
        this.proxyDomain = proxyDomain;
        return this;
    }
    
    @Override
     public BuildStep traceId(String traceId) {
        Objects.requireNonNull(traceId);
        this.traceId = traceId;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String proxyServerAddress, String proxyDomain, String traceId) {
      super(proxyServerAddress, proxyDomain, traceId);
      Objects.requireNonNull(proxyServerAddress);
      Objects.requireNonNull(proxyDomain);
      Objects.requireNonNull(traceId);
    }
    
    @Override
     public CopyOfBuilder proxyServerAddress(String proxyServerAddress) {
      return (CopyOfBuilder) super.proxyServerAddress(proxyServerAddress);
    }
    
    @Override
     public CopyOfBuilder proxyDomain(String proxyDomain) {
      return (CopyOfBuilder) super.proxyDomain(proxyDomain);
    }
    
    @Override
     public CopyOfBuilder traceId(String traceId) {
      return (CopyOfBuilder) super.traceId(traceId);
    }
  }
  
}
