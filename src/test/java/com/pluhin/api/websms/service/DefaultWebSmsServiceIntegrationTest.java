package com.pluhin.api.websms.service;

import com.pluhin.api.websms.domain.websms.WebSmsCredentials;
import com.pluhin.api.websms.exception.WebSmsExecutionException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultWebSmsServiceIntegrationTest {

  private final WebSmsService sut = new DefaultWebSmsService();

  @Test
  void sendSmsShouldReturnError() {
    List<String> recipients = Collections.singletonList("+375291234567");
    String message = " rengwergre";


    Assertions.assertThrows(WebSmsExecutionException.class, () -> sut.sendSms(
        recipients,
        message,
        new WebSmsCredentials(
            "Vizitka",
            "test@yandex.ru",
            "mockKey")
        )
    );
  }

  @Test
  void getBalanceShouldReturnError() {
    Assertions.assertThrows(WebSmsExecutionException.class, () -> sut.getBalance(
        new WebSmsCredentials(
            "Vizitka",
            "test@yandex.ru",
            "mockKey")
        )
    );
  }
}