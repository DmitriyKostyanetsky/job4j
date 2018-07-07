package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SameCharArraysTest {

    @Test
    public void whenTwoArraysAreSameThenTrue() {
        SameCharArrays same = new SameCharArrays("baab", "abba");
        assertThat(same.isSameArrays(), is(true));
    }

    @Test
    public void whenTwoArraysAreSameThenFalse() {
        SameCharArrays same = new SameCharArrays("baab", "abbc");
        assertThat(same.isSameArrays(), is(false));
    }

    @Test
    public void whenTwoArraysAreZeroSameThenFalse() {
        SameCharArrays same = new SameCharArrays("0002", "0000");
        assertThat(same.isSameArrays(), is(false));
    }
}