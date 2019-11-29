package com.pluhin.api.websms.service;

import com.pluhin.api.websms.domain.websms.WebSmsCredentials;
import com.pluhin.api.websms.domain.websms.WebSmsGetBalanceResponse;
import com.pluhin.api.websms.domain.websms.WebSmsSendSmsResponse;
import java.util.List;

public interface WebSmsService {

  WebSmsSendSmsResponse sendSms(List<String> recipients, String message, WebSmsCredentials credentials);

  WebSmsGetBalanceResponse getBalance(WebSmsCredentials credentials);
}
