package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "test name", "desc", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "test name", "desc", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"4", item.getId(), "7"});
        new StartUI(input, tracker).init();
        Item result = null;
        assertThat(tracker.findById(item.getId()), is(result));
    }

    @Test
    public void whenUserFindByIdThenTrackerHasShowIdItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"5", item.getId(), "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getId(), is(item.getId()));
    }

    @Test
    public void whenUserFindByNameThenTrackerHasShowNameItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc2"));
        Item item1 = tracker.add(new Item("test1", "desc3"));
        Input input = new StubInput(new String[]{"6", "test1", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is(item.getName()));
        assertThat(tracker.getAll()[1].getName(), is(item1.getName()));
    }
}