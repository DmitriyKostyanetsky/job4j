package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "1";
    private static final String ALL = "2";
    private static final String EDIT = "3";
    private static final String DELETE = "4";
    private static final String FIND_BY_ID = "5";
    private static final String FIND_BY_NAME = "6";
    private static final String EXIT = "7";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void showMenu() {
        System.out.println("Меню.");
        System.out.println("1. Добавить заявку.");
        System.out.println("2. Показать все заявки.");
        System.out.println("3. Редактировать заявку.");
        System.out.println("4. Удалить заявку.");
        System.out.println("5. Найти заявку по id.");
        System.out.println("6. Найти заявку по имени.");
        System.out.println("7. Выйти.");

    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findId();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findName();
            }  else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    public void createItem() {
        System.out.println("-------Добавление новой заявки-------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("-------Новая заявка с Id : " + item.getId() + "-------");
    }

    public void showAllItems() {
        System.out.println("-------Показать все заявки-------");
        int number = 0;
        for (Item item : this.tracker.getAll()) {
            if (item != null) {
                number++;
                System.out.println(number + ". имя : " + item.getName() + " id : " + item.getId() + " описание : " + item.getDesc());
            }
        }
        System.out.println("---------------------------------");
    }

    public void editItem() {
        System.out.println("-------Редактировать заявку-------");
        String id = this.input.ask("Введите id редактируемой заявки : ");
        String name = this.input.ask("Введите новое имя заявки : ");
        String desc = this.input.ask("Введите новое описание заявки : ");
        for (Item item : this.tracker.getAll()) {
            if (item.getId().equals(id)) {
                item.setName(name);
                item.setDesc(desc);
                this.tracker.replace(id, item);
            }
        }
        System.out.println("-------Заявка отредактирована-------");
    }

    public void deleteItem() {
        System.out.println("-------Удалить заявку-------");
        String id = this.input.ask("Введите id заявки : ");
        this.tracker.delete(id);
        System.out.println("-------Заявка удалена-------");
    }

    public void findId() {
        System.out.println("-------Найти заявку по id-------");
        String id = this.input.ask("Введите id : ");
        Item result = this.tracker.findById(id);
        System.out.println("ID заявки: " + result.getId() + " Описание: " + result.getDesc() + " Имя: " + result.getName());
        System.out.println("---------------------------------");
    }

    public void findName() {
        System.out.println("-------Найти заявку по имени-------");
        String name = this.input.ask("Введите имя : ");
        int number = 0;
        Item[] result = this.tracker.findByName(name);
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