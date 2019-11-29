package com.pluhin.api.websms.service;

import static com.pluhin.api.websms.WebSmsConstants.BALANCE_COMMAND;
import static com.pluhin.api.websms.WebSmsConstants.SEND_SMS_COMMAND;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_API_KEY_PARAM;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_ENDPOINT;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_RECIPIENTS_PARAM;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_REQUEST_PARAM_KEY;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_REQUEST_PARAM_VALUE;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_SENDER_PARAM;
import static com.pluhin.api.websms.WebSmsConstants.WEBSMS_USER_PARAM;

import com.pluhin.api.websms.domain.websms.WebSmsCredentials;
import com.pluhin.api.websms.domain.websms.WebSmsGetBalanceResponse;
import com.pluhin.api.websms.domain.websms.WebSmsSendSmsResponse;
import com.pluhin.api.websms.exception.WebSmsExecutionException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DefaultWebSmsService implements WebSmsService {

  private final RestTemplate restTemplate;

  public DefaultWebSmsService() {
    restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
  }

  public WebSmsSendSmsResponse sendSms(List<String> recipients, String message, WebSmsCredentials credentials) {
    String phones = String.join(",", recipients);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(WEBSMS_ENDPOINT)
        .queryParam(WEBSMS_REQUEST_PARAM_KEY, WEBSMS_REQUEST_PARAM_VALUE + SEND_SMS_COMMAND)
        .queryParam(WEBSMS_USER_PARAM, credentials.getUsername())
        .queryParam(WEBSMS_API_KEY_PARAM, credentials.getApiKey())
        .queryParam(WEBSMS_RECIPIENTS_PARAM, phones)
        .queryParam(WEBSMS_SENDER_PARAM, credentials.getSenderName());

    ResponseEntity<WebSmsSendSmsResponse> response = restTemplate.getForEntity(
        builder.toUriString(),
        WebSmsSendSmsResponse.class
    );

    WebSmsSendSmsResponse responseBody = response.getBody();

    if (responseBody.getError() != null) {
      throw new WebSmsExecutionException(responseBody.getMessage());
    }

    return responseBody;
  }

  public WebSmsGetBalanceResponse getBalance(WebSmsCredentials credentials) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(WEBSMS_ENDPOINT)
        .queryParam(WEBSMS_REQUEST_PARAM_KEY, WEBSMS_REQUEST_PARAM_VALUE + BALANCE_COMMAND)
        .queryParam(WEBSMS_USER_PARAM, credentials.getUsername())
        .queryParam(WEBSMS_API_KEY_PARAM, credentials.getApiKey());

    ResponseEntity<WebSmsGetBalanceResponse> response = restTemplate.getForEntity(
        builder.toUriString(),
        WebSmsGetBalanceResponse.class
    );

    WebSmsGetBalanceResponse responseBody = response.getBody();

    if (responseBody.getError() != null) {
      throw new WebSmsExecutionException(responseBody.getMessage());
    }

    return responseBody;
  }
}
