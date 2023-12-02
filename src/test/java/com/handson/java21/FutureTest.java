package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FutureTest {

  @Test
  void futureTest() throws InterruptedException {
    try (var executor = Executors
        .newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
      var future = executor.submit(() -> "Hello, world!");

      Thread.sleep(100);

      var result = switch (future.state()) {
        case CANCELLED, FAILED -> throw new IllegalStateException("could't finish the work!");
        case SUCCESS -> future.resultNow();
        default -> null;
      };
      assertThat(result).isEqualTo("Hello, world!");
    }
  }
}
