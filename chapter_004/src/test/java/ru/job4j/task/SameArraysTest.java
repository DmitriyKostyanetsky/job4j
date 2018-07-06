package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SameArraysTest {

    @Test
    public void whenTwoArraysAreSameThenTrue() {
        SameArrays same = new SameArrays("Developer", "Developer");
        assertThat(same.isSameArrays(), is(true));
    }

    @Test
    public void whenTwoArraysAreSameThenFalse() {
        SameArrays same = new SameArrays("Developer", "Developper");
        assertThat(same.isSameArrays(), is(false));
    }
}