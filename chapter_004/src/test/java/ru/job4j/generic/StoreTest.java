package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StoreTest {

    private User[] users = new User[] {new User("1"), new User("2"), new User("3")};
    private UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore(users, new SimpleArray<>(users));
    }

    @Test
    public void whenAddNewUserThenNewUserId10() {
        userStore.add(new User("10"));
        assertThat(users[2].getId(), is("10"));
    }

    @Test
    public void whenReplaceUserThenNewUserId100() {
        boolean result = userStore.replace("1", new User("100"));
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        boolean result = userStore.delete("2");
        assertThat(result, is(true));
    }

    @Test
    public void whenFindByIdThenTrue() {
        User result = userStore.findById("3");
        assertThat(result, is(users[2]));
    }
}