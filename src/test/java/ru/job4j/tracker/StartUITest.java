package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        UserAction[] actions = {
                new ShowItemsAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String expected = "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Show all items ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "test", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        Item item1 = new Item("test");
        tracker.add(item);
        tracker.add(item1);
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String expected = "Menu." + System.lineSeparator()
                + "0. Find by name item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find items by name ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + item1 + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find by name item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        Item item1 = new Item("test32");
        tracker.add(item);
        tracker.add(item1);
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String expected = "Menu." + System.lineSeparator()
                + "0. Find by id item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by id ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find by id item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }
}