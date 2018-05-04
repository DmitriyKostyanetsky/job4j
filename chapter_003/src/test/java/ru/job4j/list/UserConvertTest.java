package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListThenHashMap() {
        UserConvert convert = new UserConvert();
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "John", "Manchester");
        User user2 = new User(2, "Denis", "Moskva");
        User user3 = new User(3, "Maria", "London");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        HashMap<Integer, User> result = convert.process(userList);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, user1);
        expect.put(2, user2);
        expect.put(3, user3);
        assertThat(result, is(expect));
    }
}
