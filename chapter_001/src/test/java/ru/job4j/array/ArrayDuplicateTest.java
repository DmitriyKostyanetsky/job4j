package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicaye() {
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] input = new String[]{"Hello", "Bye", "Hello", "Super", "Bye"};
        String[] result = dupl.remove(input);
        String[] except = new String[]{"Hello", "Bye", "Super"};
        assertThat(result, arrayContainingInAnyOrder(except));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] input = new String[]{"Hello", "Hello", "Super", "Bye", "Bye", "Super", "Hello", "World", "Super", "Class", "World"};
        String[] result = dupl.remove(input);
        String[] except = new String[]{"Hello", "Super", "Bye", "World", "Class"};
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}