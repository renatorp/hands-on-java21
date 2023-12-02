package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpClientTest {

  @Test
  void httpClientTest() throws IOException, InterruptedException {
    try (var client = HttpClient.newHttpClient()) {
      var request = HttpRequest.newBuilder(URI.create("https://www.adobe.com")).build();
      var response = client.send(request, BodyHandlers.ofString());

      assertThat(response.statusCode()).isEqualTo(200);
      System.out.println(response.body());
    }
  }
}
