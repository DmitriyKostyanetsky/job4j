package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item("test1", "testDescription", "1243L");
        items.add(item);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(items.get(0)));
    }

    @Test
    public void whenDeleteItemThenTrackerOffsetArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "itemOne", "1243L");
        tracker.add(item);
        tracker.delete(item.getId());
        Item result = null;
        assertThat(result, is(tracker.findById(item.getId())));
    }

    @Test
    public void whenFindNameThenTrackerShowNameArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", "1243L");
        Item item1 = new Item("test2", "testDescription2", "1243L");
        Item item2 = new Item("test2", "testDescription2", "1243L");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        String key = "test2";
        ArrayList<Item> result = tracker.findByName(key);
        assertThat(result.get(0).getName(), is(item1.getName()));
        assertThat(result.get(1).getName(), is(item2.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", "1243L");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", "1243L");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindIdThenTrackerShowIdItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", "1243L");
        Item item1 = new Item("test2", "testDescription2", "1243L");
        tracker.add(item);
        tracker.add(item1);
        String id = item1.getId();
        Item result = tracker.findById(id);
        assertThat(result.getId(), is(item1.getId()));
    }
}