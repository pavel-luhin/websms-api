package com.pluhin.api.websms.domain.websms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class WebSmsSendSmsResponse {

  private final String status;
  private final List<String> messages;
  private final Integer count;
  private final Integer parts;
  private final Integer amount;
  private final Integer balance;
  private final Byte test;
  private final Byte urgent;
  private final List<String> customId;

  //  error messages
  private final Integer error;
  private final String message;

  @JsonCreator
  public WebSmsSendSmsResponse(
      @JsonProperty("status") String status,
      @JsonProperty("messages_id") List<String> messages,
      @JsonProperty("count") Integer count,
      @JsonProperty("parts") Integer parts,
      @JsonProperty("amount") Integer amount,
      @JsonProperty("balance") Integer balance,
      @JsonProperty("test") Byte test,
      @JsonProperty("urgent") Byte urgent,
      @JsonProperty("custom_id") List<String> customId,
      @JsonProperty("error") Integer error,
      @JsonProperty("message") String message) {
    this.status = status;
    this.messages = messages;
    this.count = count;
    this.parts = parts;
    this.amount = amount;
    this.balance = balance;
    this.test = test;
    this.urgent = urgent;
    this.customId = customId;
    this.error = error;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public List<String> getMessages() {
    return messages;
  }

  public Integer getCount() {
    return count;
  }

  public Integer getParts() {
    return parts;
  }

  public Integer getAmount() {
    return amount;
  }

  public Integer getBalance() {
    return balance;
  }

  public Byte getTest() {
    return test;
  }

  public Byte getUrgent() {
    return urgent;
  }

  public List<String> getCustomId() {
    return customId;
  }

  public Integer getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }
}
