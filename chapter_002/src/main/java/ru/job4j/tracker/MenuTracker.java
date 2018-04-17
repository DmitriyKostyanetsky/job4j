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

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindByName();
        this.actions[5] = new FindById();
        this.actions[6] = new ExitMenu();
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

    public class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Добавление новой заявки-------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("-------Новая заявка с Id : " + item.getId() + "-------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Добавить заявку");
        }
    }

    public class ShowAllItems implements UserAction {
        public int key() {
            return 1;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки");
        }
    }

    public class EditItem implements UserAction {
        public int key() {
            return 2;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Редактировать заявку");
        }
    }

    public class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Удалить заявку-------");
            String id = input.ask("Введите id заявки : ");
            tracker.delete(id);
            System.out.println("Удаленная заявка : " + id);
            System.out.println("-------Заявка удалена-------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }

    public class FindByName implements UserAction {
        public int key() {
            return 4;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по имени");
        }
    }

    public class FindById implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("-------Найти заявку по id-------");
            String id = input.ask("Введите id : ");
            Item result = tracker.findById(id);
            System.out.println("ID заявки: " + result.getId() + " Описание: " + result.getDesc() + " Имя: " + result.getName());
            System.out.println("---------------------------------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по id");
        }
    }

    public class ExitMenu implements UserAction {
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            System.exit(6);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Выйти из меню");
        }
    }
}