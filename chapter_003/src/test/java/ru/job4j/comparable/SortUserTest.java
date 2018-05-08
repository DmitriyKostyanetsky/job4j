package ru.job4j.comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        TreeSet<User> expect = new TreeSet<User>(new User(users.get(0).getName(), users.get(0).getAge())) {{
            add(new User("Albert", 27));
            add(new User("Kevin", 39));
            add(new User("Vasy", 45));
        }};
        assertThat(result, is(expect));
    }
}