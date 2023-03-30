package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author artem.polschak@gmail.com on 28.03.2023.
 * @project job4j_design
 */
class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5).contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .containsExactly("first", "second", "three", "four", "five")
                .startsWith("first", "second")
                .endsWith("five");
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five", "second", "zero");
        assertThat(list).hasSize(7).contains("second", "four", "zero")
                .contains("three", Index.atIndex(2))
                .containsOnly("first", "second", "three", "four", "five", "zero")
                .containsExactlyInAnyOrder("second", "four", "second", "five", "zero", "first", "three")
                .doesNotContain("two")
                .endsWith("zero");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("bob", "dean", "jack", "sam", "adam", "wolandemord", "garry");
        assertThat(set).hasSize(7).contains("dean", "sam", "adam")
                .containsOnly("dean", "bob", "adam", "jack", "wolandemord", "garry", "sam")
                .containsAnyOf("dack", "puss", "adam")
                .doesNotContain("subaru");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("bob", "dean", "jack", "sam", "adam", "garry");
        assertThat(map).hasSize(6).containsKeys("dean", "sam", "garry")
                .containsValues(2, 3, 5)
                .doesNotContainKey("susanna")
                .doesNotContainValue(10)
                .containsEntry("jack", 2);
    }


}