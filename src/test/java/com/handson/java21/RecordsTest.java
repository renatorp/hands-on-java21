package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class RecordsTest {

  interface JdkEvent {
    String name();
  }

  record JdkReleasedEvent(String name) implements JdkEvent { }
  record JdkSupportEndedEvent(String name, LocalDate date) implements JdkEvent { }

  @Test
  void recordTest() {
    var event = new JdkReleasedEvent("Java21");
    var eventCopy = new JdkReleasedEvent("Java21");

    assertThat(event.name).isEqualTo("Java21");
    assertThat(eventCopy).isEqualTo(event);
    assertThat(event.toString()).isEqualTo("JdkReleasedEvent[name=Java21]");
  }

  @Test
  void recordWithEnhancedSwitchTest() {
    printJdkEvent(new JdkReleasedEvent("Java21"));
    printJdkEvent(new JdkSupportEndedEvent("Java20", LocalDate.of(2023,9,19)));
  }

  @Test
  void recordWithInstanceOfTest() {
    assertThat(getEolFromEvent(new JdkReleasedEvent("Java21"))).isNull();
    assertThat(getEolFromEvent(new JdkSupportEndedEvent("Java20", LocalDate.of(2023,9,19)))).isNotNull();
  }

  private String getEolFromEvent(JdkEvent event) {
    if (event instanceof JdkSupportEndedEvent(var name, var date)) {
      return date.toString();
    }
    return null;
  }

  private void printJdkEvent(JdkEvent event) {
    switch (event) {
      case JdkReleasedEvent(var name) -> System.out.println(String.format("Java version %s just released", name));
      case JdkSupportEndedEvent(var name, var date) -> System.out.println(String.format("Ended support of Java version %s at %s", name, date));
      default -> { }
    }
  }

}
