package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.SequencedCollection;
import java.util.TreeSet;
import java.util.Vector;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

public class CollectionTest {

  @Test
  void sequencedCollectionsTest() {
    assertThat(fillUpCollection(Lists.newArrayList()).getFirst()).isEqualTo("black");
    assertThat(fillUpCollection(LinkedHashSet.newLinkedHashSet(6)).getFirst()).isEqualTo("black");
    assertThat(fillUpCollection(new LinkedList<>()).getFirst()).isEqualTo("black");
    assertThat(fillUpCollection(new Vector<>()).getFirst()).isEqualTo("black");

  }

  private static SequencedCollection<String> fillUpCollection(SequencedCollection<String> collection) {
    collection.add("red");
    collection.add("blue");
    collection.add("purple");
    collection.addFirst("black");
    collection.addLast("orange");
    collection.add("red");
    return collection;
  }
}
