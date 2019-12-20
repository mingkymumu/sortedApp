package com.noer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
class SortAppTest {

    @Test
    void sortPerson() {
        Main main = new Main();
        List<Person> personUnsorted = new ArrayList<>();
        personUnsorted.add( new Person("Json", "Statham", "Json Statham"));
        personUnsorted.add(new Person("Banana", "Apple", "Banana Apple"));

        List<Person> personExpected = new ArrayList<>();
               personExpected.add( new Person("Banana", "Apple", "Banana Apple"));
               personExpected.add( new Person("Json", "Statham", "Json Statham"));

        assertThat(personExpected,is(main.sortPerson(personExpected)));

    }
}