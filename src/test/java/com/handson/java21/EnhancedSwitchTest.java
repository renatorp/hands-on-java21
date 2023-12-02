package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnhancedSwitchTest {

  enum Country {
    USA, ENGLAND, PORTUGAL, BRAZIL, CAMBOJA, POLAND
  }

  private String calculateLanguage(Country country) {
    return switch (country) {
      case USA, ENGLAND ->  "english";
      case BRAZIL, PORTUGAL -> "portuguese";
      case POLAND -> "polish";
      case null -> "null";
      default -> "unknown";
    };
  }

  @Test
  void enhancedSwitchTest_enum() {
    assertThat(calculateLanguage(Country.PORTUGAL)).isEqualTo("portuguese");
    assertThat(calculateLanguage(Country.BRAZIL)).isEqualTo("portuguese");
    assertThat(calculateLanguage(Country.USA)).isEqualTo("english");
    assertThat(calculateLanguage(Country.ENGLAND)).isEqualTo("english");
    assertThat(calculateLanguage(Country.POLAND)).isEqualTo("polish");
    assertThat(calculateLanguage(null)).isEqualTo("null");
    assertThat(calculateLanguage(Country.CAMBOJA)).isEqualTo("unknown");

  }

  // As of Java 21
  private String formatterPatternSwitch(Object obj) {
    return switch (obj) {
      case null -> "null";
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s when s.isBlank() -> "blank String";
      case String s -> String.format("String %s", s);
      default        -> obj.toString();
    };
  }

  @Test
  void enhancedSwitchTest_string() {
    assertThat(formatterPatternSwitch(1)).isEqualTo("int 1");
    assertThat(formatterPatternSwitch(1L)).isEqualTo("long 1");
    assertThat(formatterPatternSwitch(1d)).isEqualTo("double 1,000000");
    assertThat(formatterPatternSwitch("1")).isEqualTo("String 1");
    assertThat(formatterPatternSwitch("")).isEqualTo("blank String");
    assertThat(formatterPatternSwitch(Country.ENGLAND)).isEqualTo("ENGLAND");
    assertThat(formatterPatternSwitch(null)).isEqualTo("null");
  }
}
