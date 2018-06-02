package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StoreTest {

    private User[] users = new User[] {new User("1"), new User("2"), new User("3")};
    private Role[] roles = new Role[] {new Role("0006"), new Role("0009"), new Role("0002")};
    private UserStore userStore;
    private RoleStore roleStore;

    @Before
    public void setUp() {
        userStore = new UserStore(users, new SimpleArray<>(users));
        roleStore = new RoleStore(roles, new SimpleArray<>(roles));
    }

    @Test
    public void whenAddNewUserAndRoleThenNewUserId10() {
        User[] userResult = new User[3];
        Role[] roleResult = new Role[3];
        UserStore store1 = new UserStore(userResult, new SimpleArray<>(userResult));
        RoleStore store2 = new RoleStore(roleResult, new SimpleArray<>(roleResult));
        store1.add(new User("10"));
        store2.add(new Role("0010"));
        assertThat(userResult[0].getId(), is("10"));
        assertThat(roleResult[0].getId(), is("0010"));
    }

    @Test
    public void whenReplaceUserAndRoleThenNewUserId100() {
        boolean userResult = userStore.replace("1", new User("100"));
        boolean roleResult = roleStore.replace("0009", new Role("000131"));
        assertThat(userResult, is(true));
        assertThat(roleResult, is(true));
    }

    @Test
    public void whenDeleteUserAndRoleThenUserIsNull() {
        boolean userResult = userStore.delete("2");
        boolean roleResult = roleStore.delete("0006");
        assertThat(userResult, is(true));
        assertThat(roleResult, is(true));
    }

    @Test
    public void whenFindByIdUserAndRoleThenTrue() {
        User userResult = userStore.findById("3");
        Role roleResult = roleStore.findById("0002");
        assertThat(userResult, is(users[2]));
        assertThat(roleResult, is(roles[2]));
    }
}