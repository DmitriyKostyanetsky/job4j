package ru.job4j.comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListUserThenTreeSetUser() {
        User user1 = new User("Ivan", 24);
        User user2 = new User("Sergey", 20);
        int result = user1.compareTo(user2);
        assertThat(result, is(1));
    }

    @Test
    public void whenLengthThenSortLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Sergey", 25);
        User user2 = new User("Ivan", 30);
        User user3 = new User("Sergey", 20);
        User user4 = new User("Ivan", 25);
        List<User> result = Arrays.asList(
                user1, user2, user3, user4
        );
        sortUser.sortNameLength(result);
        List<User> expect = Arrays.asList(
                user2, user4, user1, user3
        );
        assertEquals(result, expect);
    }

    @Test
    public void whenNameAndLengthThenSortNameLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Sergey", 25);
        User user2 = new User("Ivan", 30);
        User user3 = new User("Sergey", 20);
        User user4 = new User("Ivan", 25);
        List<User> result = Arrays.asList(
                user1, user2, user3, user4
        );
        sortUser.sortByAllFields(result);
        List<User> expect = Arrays.asList(
                user4, user2, user3, user1
        );
        assertEquals(result, expect);
    }
}