package ru.item;

import org.junit.Before;
import org.junit.Test;
import productes.Chancery;
import productes.Food;
import productes.Product;
import productes.chancery.Notebook;
import productes.chancery.Pen;
import productes.chancery.Pencil;
import productes.food.Confectionery;
import productes.food.Meat;
import productes.food.Vegetables;

import java.util.ArrayList;
import java.util.List;

public class ProductesTest {

    private List<Product> productList = new ArrayList<>();
    private List<Food> foodList;
    private List<Chancery> chanceryList;

    @Before
    public void setUp() {
        foodList = new ArrayList<Food>() {{
            add(new Meat("meat1", 100, 1, "10.10.18", 48, "pork" ));
            add(new Meat("meat2", 100, 2, "10.10.18", 48, "beef" ));
            add(new Meat("meat3", 100, 3, "10.10.18", 48, "chicken" ));
            add(new Vegetables("vegetables1", 4, 12, "11.11.18", 64, "tomato"));
            add(new Vegetables("vegetables2", 5, 12, "11.11.18", 64, "pumpkin"));
            add(new Vegetables("vegetables3", 6, 12, "11.11.18", 64, "salad"));
            add(new Confectionery("confectionery1", 1110, 7, "13.03.18", 18, 300));
            add(new Confectionery("confectionery2", 2010, 8, "13.09.18", 30, 1000));
        }};
        chanceryList = new ArrayList<Chancery>() {{
            add(new Pen("Parker", 30000, 9, "Parker-Int", "black", 2));
            add(new Pencil("Ret", 100, 10, "Ret-Int", "grey", 6));
            add(new Pencil("Mark", 300, 11, "Mark-Int", "yellow", 10));
            add(new Notebook("Note1", 250, 12, "Ret-Int", "line", 150));
            add(new Notebook("Note2", 210, 13, "PenPen", "cell", 200));
        }};
        productList.addAll(foodList);
        productList.addAll(chanceryList);
    }

    @Test
    public void testProduct() {
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).info();
        }
    }
}