package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Webhook type in your schema. */
public final class Webhook {
  private final String organizationID;
  private final String webhookID;
  private final String name;
  private final String url;
  private final WebhookSender sender;
  private final HTTPMethod httpMethod;
  private final AuthType authType;
  private final Boolean disableHTTPCerts;
  private final ContentType contentType;
  private final List<HTTPHeader> headers;
  private final String payload;
  private final List<String> alarmIDBindings;
  public String getOrganizationId() {
      return organizationID;
  }
  
  public String getWebhookId() {
      return webhookID;
  }
  
  public String getName() {
      return name;
  }
  
  public String getUrl() {
      return url;
  }
  
  public WebhookSender getSender() {
      return sender;
  }
  
  public HTTPMethod getHttpMethod() {
      return httpMethod;
  }
  
  public AuthType getAuthType() {
      return authType;
  }
  
  public Boolean getDisableHttpCerts() {
      return disableHTTPCerts;
  }
  
  public ContentType getContentType() {
      return contentType;
  }
  
  public List<HTTPHeader> getHeaders() {
      return headers;
  }
  
  public String getPayload() {
      return payload;
  }
  
  public List<String> getAlarmIdBindings() {
      return alarmIDBindings;
  }
  
  private Webhook(String organizationID, String webhookID, String name, String url, WebhookSender sender, HTTPMethod httpMethod, AuthType authType, Boolean disableHTTPCerts, ContentType contentType, List<HTTPHeader> headers, String payload, List<String> alarmIDBindings) {
    this.organizationID = organizationID;
    this.webhookID = webhookID;
    this.name = name;
    this.url = url;
    this.sender = sender;
    this.httpMethod = httpMethod;
    this.authType = authType;
    this.disableHTTPCerts = disableHTTPCerts;
    this.contentType = contentType;
    this.headers = headers;
    this.payload = payload;
    this.alarmIDBindings = alarmIDBindings;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Webhook webhook = (Webhook) obj;
      return ObjectsCompat.equals(getOrganizationId(), webhook.getOrganizationId()) &&
              ObjectsCompat.equals(getWebhookId(), webhook.getWebhookId()) &&
              ObjectsCompat.equals(getName(), webhook.getName()) &&
              ObjectsCompat.equals(getUrl(), webhook.getUrl()) &&
              ObjectsCompat.equals(getSender(), webhook.getSender()) &&
              ObjectsCompat.equals(getHttpMethod(), webhook.getHttpMethod()) &&
              ObjectsCompat.equals(getAuthType(), webhook.getAuthType()) &&
              ObjectsCompat.equals(getDisableHttpCerts(), webhook.getDisableHttpCerts()) &&
              ObjectsCompat.equals(getContentType(), webhook.getContentType()) &&
              ObjectsCompat.equals(getHeaders(), webhook.getHeaders()) &&
              ObjectsCompat.equals(getPayload(), webhook.getPayload()) &&
              ObjectsCompat.equals(getAlarmIdBindings(), webhook.getAlarmIdBindings());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getOrganizationId())
      .append(getWebhookId())
      .append(getName())
      .append(getUrl())
      .append(getSender())
      .append(getHttpMethod())
      .append(getAuthType())
      .append(getDisableHttpCerts())
      .append(getContentType())
      .append(getHeaders())
      .append(getPayload())
      .append(getAlarmIdBindings())
      .toString()
      .hashCode();
  }
  
  public static OrganizationIdStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(organizationID,
      webhookID,
      name,
      url,
      sender,
      httpMethod,
      authType,
      disableHTTPCerts,
      contentType,
      headers,
      payload,
      alarmIDBindings);
  }
  public interface OrganizationIdStep {
    WebhookIdStep organizationId(String organizationId);
  }
  

  public interface WebhookIdStep {
    NameStep webhookId(String webhookId);
  }
  

  public interface NameStep {
    UrlStep name(String name);
  }
  

  public interface UrlStep {
    SenderStep url(String url);
  }
  

  public interface SenderStep {
    HttpMethodStep sender(WebhookSender sender);
  }
  

  public interface HttpMethodStep {
    AuthTypeStep httpMethod(HTTPMethod httpMethod);
  }
  

  public interface AuthTypeStep {
    DisableHttpCertsStep authType(AuthType authType);
  }
  

  public interface DisableHttpCertsStep {
    ContentTypeStep disableHttpCerts(Boolean disableHttpCerts);
  }
  

  public interface ContentTypeStep {
    BuildStep contentType(ContentType contentType);
  }
  

  public interface BuildStep {
    Webhook build();
    BuildStep headers(List<HTTPHeader> headers);
    BuildStep payload(String payload);
    BuildStep alarmIdBindings(List<String> alarmIdBindings);
  }
  

  public static class Builder implements OrganizationIdStep, WebhookIdStep, NameStep, UrlStep, SenderStep, HttpMethodStep, AuthTypeStep, DisableHttpCertsStep, ContentTypeStep, BuildStep {
    private String organizationID;
    private String webhookID;
    private String name;
    private String url;
    private WebhookSender sender;
    private HTTPMethod httpMethod;
    private AuthType authType;
    private Boolean disableHTTPCerts;
    private ContentType contentType;
    private List<HTTPHeader> headers;
    private String payload;
    private List<String> alarmIDBindings;
    public Builder() {
      
    }
    
    private Builder(String organizationID, String webhookID, String name, String url, WebhookSender sender, HTTPMethod httpMethod, AuthType authType, Boolean disableHTTPCerts, ContentType contentType, List<HTTPHeader> headers, String payload, List<String> alarmIDBindings) {
      this.organizationID = organizationID;
      this.webhookID = webhookID;
      this.name = name;
      this.url = url;
      this.sender = sender;
      this.httpMethod = httpMethod;
      this.authType = authType;
      this.disableHTTPCerts = disableHTTPCerts;
      this.contentType = contentType;
      this.headers = headers;
      this.payload = payload;
      this.alarmIDBindings = alarmIDBindings;
    }
    
    @Override
     public Webhook build() {
        
        return new Webhook(
          organizationID,
          webhookID,
          name,
          url,
          sender,
          httpMethod,
          authType,
          disableHTTPCerts,
          contentType,
          headers,
          payload,
          alarmIDBindings);
    }
    
    @Override
     public WebhookIdStep organizationId(String organizationId) {
        Objects.requireNonNull(organizationId);
        this.organizationID = organizationId;
        return this;
    }
    
    @Override
     public NameStep webhookId(String webhookId) {
        Objects.requireNonNull(webhookId);
        this.webhookID = webhookId;
        return this;
    }
    
    @Override
     public UrlStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public SenderStep url(String url) {
        Objects.requireNonNull(url);
        this.url = url;
        return this;
    }
    
    @Override
     public HttpMethodStep sender(WebhookSender sender) {
        Objects.requireNonNull(sender);
        this.sender = sender;
        return this;
    }
    
    @Override
     public AuthTypeStep httpMethod(HTTPMethod httpMethod) {
        Objects.requireNonNull(httpMethod);
        this.httpMethod = httpMethod;
        return this;
    }
    
    @Override
     public DisableHttpCertsStep authType(AuthType authType) {
        Objects.requireNonNull(authType);
        this.authType = authType;
        return this;
    }
    
    @Override
     public ContentTypeStep disableHttpCerts(Boolean disableHttpCerts) {
        Objects.requireNonNull(disableHttpCerts);
        this.disableHTTPCerts = disableHttpCerts;
        return this;
    }
    
    @Override
     public BuildStep contentType(ContentType contentType) {
        Objects.requireNonNull(contentType);
        this.contentType = contentType;
        return this;
    }
    
    @Override
     public BuildStep headers(List<HTTPHeader> headers) {
        this.headers = headers;
        return this;
    }
    
    @Override
     public BuildStep payload(String payload) {
        this.payload = payload;
        return this;
    }
    
    @Override
     public BuildStep alarmIdBindings(List<String> alarmIdBindings) {
        this.alarmIDBindings = alarmIdBindings;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String organizationId, String webhookId, String name, String url, WebhookSender sender, HTTPMethod httpMethod, AuthType authType, Boolean disableHttpCerts, ContentType contentType, List<HTTPHeader> headers, String payload, List<String> alarmIdBindings) {
      super(organizationID, webhookID, name, url, sender, httpMethod, authType, disableHTTPCerts, contentType, headers, payload, alarmIDBindings);
      Objects.requireNonNull(organizationID);
      Objects.requireNonNull(webhookID);
      Objects.requireNonNull(name);
      Objects.requireNonNull(url);
      Objects.requireNonNull(sender);
      Objects.requireNonNull(httpMethod);
      Objects.requireNonNull(authType);
      Objects.requireNonNull(disableHTTPCerts);
      Objects.requireNonNull(contentType);
    }
    
    @Override
     public CopyOfBuilder organizationId(String organizationId) {
      return (CopyOfBuilder) super.organizationId(organizationId);
    }
    
    @Override
     public CopyOfBuilder webhookId(String webhookId) {
      return (CopyOfBuilder) super.webhookId(webhookId);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder url(String url) {
      return (CopyOfBuilder) super.url(url);
    }
    
    @Override
     public CopyOfBuilder sender(WebhookSender sender) {
      return (CopyOfBuilder) super.sender(sender);
    }
    
    @Override
     public CopyOfBuilder httpMethod(HTTPMethod httpMethod) {
      return (CopyOfBuilder) super.httpMethod(httpMethod);
    }
    
    @Override
     public CopyOfBuilder authType(AuthType authType) {
      return (CopyOfBuilder) super.authType(authType);
    }
    
    @Override
     public CopyOfBuilder disableHttpCerts(Boolean disableHttpCerts) {
      return (CopyOfBuilder) super.disableHttpCerts(disableHttpCerts);
    }
    
    @Override
     public CopyOfBuilder contentType(ContentType contentType) {
      return (CopyOfBuilder) super.contentType(contentType);
    }
    
    @Override
     public CopyOfBuilder headers(List<HTTPHeader> headers) {
      return (CopyOfBuilder) super.headers(headers);
    }
    
    @Override
     public CopyOfBuilder payload(String payload) {
      return (CopyOfBuilder) super.payload(payload);
    }
    
    @Override
     public CopyOfBuilder alarmIdBindings(List<String> alarmIdBindings) {
      return (CopyOfBuilder) super.alarmIdBindings(alarmIdBindings);
    }
  }
  
}
