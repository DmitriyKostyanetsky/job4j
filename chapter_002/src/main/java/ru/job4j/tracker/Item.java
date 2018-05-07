package ru.job4j.tracker;

public class Item {
    private String id;
    String name;
    String desc;
    String comments;

    public Item(String name, String desc, String comments) {
        this.name = name;
        this.desc = desc;
        this.comments = comments;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item() {

    }

    public void setId(String identification) {
        id = identification;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}