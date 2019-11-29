package com.pluhin.api.websms.domain.websms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebSmsGetBalanceResponse {

  private final String status;
  private final Double balance;
  private final Double balanceViber;
  private final String error;
  private final String message;

  @JsonCreator
  public WebSmsGetBalanceResponse(
      @JsonProperty("status") String status,
      @JsonProperty("balance") Double balance,
      @JsonProperty("balance_viber") Double balanceViber,
      @JsonProperty("error") String error,
      @JsonProperty("message") String message) {
    this.status = status;
    this.balance = balance;
    this.balanceViber = balanceViber;
    this.error = error;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getBalanceViber() {
    return balanceViber;
  }

  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }
}
