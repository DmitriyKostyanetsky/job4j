package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharUpTest {

    @Test
    public void whenStartWithPrefixInCenterOfWordThenTrue() {
        ArrayCharUp word = new ArrayCharUp();
        boolean result = word.contains("Unstoppable", "stop");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPrefixInCenterOfWordThenFalse() {
        ArrayCharUp word = new ArrayCharUp();
        boolean result = word.contains("Unstoppable", "opa");
        assertThat(result, is(false));
    }

    @Test
    public void whenStartWithPrefixInCenterOfWordThenTrue12() {
        ArrayCharUp word = new ArrayCharUp();
        boolean result = word.contains("12", "1");
        assertThat(result, is(true));
    }
}