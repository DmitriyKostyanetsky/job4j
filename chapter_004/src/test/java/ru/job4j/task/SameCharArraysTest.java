package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SameCharArraysTest {

    @Test
    public void whenTwoArraysAreSameThenTrue() {
        SameCharArrays same = new SameCharArrays("Developer", "Developer");
        assertThat(same.isSameArrays(), is(true));
    }

    @Test
    public void whenTwoArraysAreSameThenFalse() {
        SameCharArrays same = new SameCharArrays("Developer", "Developper");
        assertThat(same.isSameArrays(), is(false));
    }
}