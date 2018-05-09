package ru.job4j.comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListUserThenTreeSetUser() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<User>() {{
            add(new User("Vasy", 45));
            add(new User("Kevin", 39));
            add(new User("Albert", 27));
        }};
        Set<User> result = sortUser.sort(users);
        List<User> expect = new ArrayList<User>() {{
            add(new User("Albert", 27));
            add(new User("Kevin", 39));
            add(new User("Vasy", 45));
        }};
        assertThat(result, is(expect));
    }

    @Test
    public void whenLengthThenSortLength() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<User>() {{
            add(new User("Sergey", 25));
            add(new User("Ivan", 30));
            add(new User("Sergey", 20));
            add(new User("Ivan", 25));
        }};
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = new ArrayList<User>() {{
            add(new User("Ivan", 30));
            add(new User("Ivan", 25));
            add(new User("Sergey", 25));
            add(new User("Sergey", 20));
        }};
        assertThat(result, is(expect));
    }

    @Test
    public void whenNameAndLengthThenSortNameLength() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<User>() {{
            add(new User("Sergey", 25));
            add(new User("Ivan", 30));
            add(new User("Sergey", 20));
            add(new User("Ivan", 25));
        }};
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = new ArrayList<User>() {{
            add(new User("Ivan", 25));
            add(new User("Ivan", 30));
            add(new User("Sergey", 20));
            add(new User("Sergey", 25));
        }};
        assertThat(result, is(expect));
    }
}