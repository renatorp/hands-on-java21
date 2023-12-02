package com.handson.java21;

public class SealedTypesTest {

  sealed interface Animal permits Dog, Cat { }

  static final class Dog implements Animal {
    String bark() {
      return "au";
    }
  }

  static final class Cat implements Animal {
    public String meow() {
      return "meow";
    }
  }
}
