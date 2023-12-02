package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {

  /**
   * Clamps the value to fit between min and max. If the value is
   * less than min, then min is returned. If the value is greater
   * than max, then max is returned. Otherwise, the original value
   * is returned.
   */
  @Test
  void rangeTest() {
    assertThat(Math.clamp(2, 1, 3)).isEqualTo(2);
    assertThat(Math.clamp(4, 1, 3)).isEqualTo(3);
    assertThat(Math.clamp(0, 1, 3)).isEqualTo(1);
  }

  @Test
  void formatTest() {
    var formatted = "My %s is over %d".formatted("level", 9000);
    assertThat(formatted).isEqualTo("My level is over 9000");
  }

}
