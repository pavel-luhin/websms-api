package com.pluhin.api.websms.domain.websms;

public class WebSmsCredentials {

  private final String senderName;
  private final String username;
  private final String apiKey;

  public WebSmsCredentials(String senderName, String username, String apiKey) {
    this.senderName = senderName;
    this.username = username;
    this.apiKey = apiKey;
  }

  public String getSenderName() {
    return senderName;
  }

  public String getUsername() {
    return username;
  }

  public String getApiKey() {
    return apiKey;
  }
}
