package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 24.03.18
 */

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        //Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        //Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        //Считаем площадь.
        double result = triangle.area();
        //Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}