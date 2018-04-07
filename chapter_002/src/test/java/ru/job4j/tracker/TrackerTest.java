package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", new String[]{"1243L"});
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenDeleteItemThenTrackerOffsetArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "itemOne", new String[]{"1243L"});
        tracker.add(item);
        tracker.delete(item.getId());
        Item result = null;
        assertThat(result, is(tracker.findById(item.getId())));
    }

    @Test
    public void whenFindNameThenTrackerShowNameArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", new String[]{"1243L"});
        Item item1 = new Item("test2", "testDescription2", new String[]{"1243L"});
        tracker.add(item);
        tracker.add(item1);
        String key = "test1";
        Item[] result = tracker.findByName(key);
        assertThat(tracker.getAll()[0], is(result[0]));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", new String[]{"1243L"});
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", new String[]{"1243L"});
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
}
