package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void emojiTest() {
    var shockedFaceEmoji = "\uD83D\uDE31";
    var codePoint = Character.codePointAt(shockedFaceEmoji.toCharArray(), 0);
    assertThat(Character.isEmoji(codePoint)).isTrue();
  }

  @Test
  void repeatTest() {
    var line = new StringBuilder()
        .repeat("-", 10)
        .toString();
    assertThat(line).isEqualTo("----------");
  }
}
