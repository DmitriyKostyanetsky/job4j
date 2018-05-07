package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private Item item = new Item();

    @Before
    public void inputData() {
        this.item = tracker.add(new Item("test1", "desc1"));
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(1).getName(), is("test name"));
    }

    @Test
    public void whenUserChoseShowAllItemsThenTrackerGetAll() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0), is(this.item));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Input input = new StubInput(new String[]{"2", this.item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(this.item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasDeleteItem() {
        Input input = new StubInput(new String[]{"3", this.item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item result = null;
        assertThat(tracker.findById(this.item.getId()), is(result));
    }

    @Test
    public void whenUserFindByIdThenTrackerHasShowIdItem() {
        Input input = new StubInput(new String[]{"5", this.item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getId(), is(this.item.getId()));
    }

    @Test
    public void whenUserFindByNameThenTrackerHasShowNameItems() {
        Input input = new StubInput(new String[]{"4", "test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is(this.item.getName()));
    }
}