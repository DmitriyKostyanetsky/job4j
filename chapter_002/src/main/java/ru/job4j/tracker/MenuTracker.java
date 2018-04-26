package ru.job4j.tracker;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 14.04.18
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = this.new AddItem(0, "Добавить заявку");
        this.actions[position++] = this.new ShowAllItems(1, "Показать все заявки");
        this.actions[position++] = this.new EditItem(2, "Редактировать заявку");
        this.actions[position++] = this.new DeleteItem(3, "Удалить заявку");
        this.actions[position++] = this.new FindByName(4, "Найти заявку по имени");
        this.actions[position++] = this.new FindById(5, "Найти заявку по id");
        this.actions[position++] = this.new ExitMenu(6, "Выйти из меню");
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public int[] getActions() {
        int[] key = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            key[i] = actions[i].key();
        }
        return key;
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Добавление новой заявки-------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Новая заявка с Id : " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDesc());
        }
    }

    public class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Все заявки-------");
            int number = 0;
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    number++;
                    System.out.println(number + ". имя : " + item.getName() + " id : " + item.getId() + " описание : " + item.getDesc());
                }
            }
            System.out.println("---------------------------------");
        }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Редактировать заявку-------");
            String id = input.ask("Введите id редактируемой заявки : ");
            String name = input.ask("Введите новое имя заявки : ");
            String desc = input.ask("Введите новое описание заявки : ");
            for (Item item : tracker.getAll()) {
                if (item.getId().equals(id)) {
                    item.setName(name);
                    item.setDesc(desc);
                    tracker.replace(id, item);
                }
                System.out.println("Имя : " + item.getName() + " id : " + item.getId() + " описание : " + item.getDesc());
            }
            System.out.println("-------Заявка отредактирована-------");
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Удалить заявку-------");
            String id = input.ask("Введите id заявки : ");
            tracker.delete(id);
            System.out.println("Удаленная заявка : " + id);
            System.out.println("-------Заявка удалена-------");
        }
    }

    public class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Найти заявку по имени-------");
            String name = input.ask("Введите имя : ");
            int number = 0;
            Item[] result = tracker.findByName(name);
            for (Item item : result) {
                if (item == null) {
                    continue;
                }
                number++;
                System.out.println(number + ". ID заявки: " + item.getId() + " Описание: " + item.getDesc() + " Имя: " + item.getName());
            }
            System.out.println("---------------------------------");
        }
    }

    public class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Найти заявку по id-------");
            String id = input.ask("Введите id : ");
            Item result = tracker.findById(id);
            System.out.println("ID заявки: " + result.getId() + " Описание: " + result.getDesc() + " Имя: " + result.getName());
            System.out.println("---------------------------------");
        }
    }

    public class ExitMenu extends BaseAction {

        public ExitMenu(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.exit(1);
        }
    }
}