package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    private User user1;
    private User user2;
    private Map<User, String> map;

    @Before
    public void setUp() {
        user1 = new User("Ivan", 1, new GregorianCalendar(1990, Calendar.DECEMBER, 30));
        user2 = new User("Ivan", 1, new GregorianCalendar(1990, Calendar.DECEMBER, 30));
        map = new HashMap<>();
    }

    @Test
    public void whenPutEqualsObjectsThen() {
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));
        System.out.println(map);
    }
}