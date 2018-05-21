package ru.job4j.department;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartmentSortTest {
    @Test
    public void whenK1ThenAscendingSort() {
        DepartmentSort ds = new DepartmentSort();

        String[] departments = new String[7];
        departments[0] = "K1\\SK1";
        departments[1] = "K2\\SK1\\SSK1";
        departments[2] = "K2\\SK1\\SSK2";
        departments[3] = "K1\\SK1\\SSK1";
        departments[4] = "K2";
        departments[5] = "K1\\SK2";
        departments[6] = "K1\\SK1\\SSK2";

        List<Departments> expect = Arrays.asList(
                new Departments("K1"),
                new Departments("K1\\SK1"),
                new Departments("K1\\SK1\\SSK1"),
                new Departments("K1\\SK1\\SSK2"),
                new Departments("K1\\SK2"),
                new Departments("K2"),
                new Departments("K2\\SK1"),
                new Departments("K2\\SK1\\SSK1"),
                new Departments("K2\\SK1\\SSK2")
        );

        ds.stringToList(departments);
        List<Departments> result = ds.AscendingOrDescendingSort(1);
        assertEquals(result, expect);
    }

    @Test
    public void whenK2ThenDescendingSort() {
        DepartmentSort ds = new DepartmentSort();

        String[] departments = new String[7];
        departments[0] = "K1\\SK1";
        departments[1] = "K2\\SK1\\SSK1";
        departments[2] = "K2\\SK1\\SSK2";
        departments[3] = "K1\\SK1\\SSK1";
        departments[4] = "K2";
        departments[5] = "K1\\SK2";
        departments[6] = "K1\\SK1\\SSK2";

        List<Departments> expect = Arrays.asList(
                new Departments("K2"),
                new Departments("K2\\SK1"),
                new Departments("K2\\SK1\\SSK2"),
                new Departments("K2\\SK1\\SSK1"),
                new Departments("K1"),
                new Departments("K1\\SK2"),
                new Departments("K1\\SK1"),
                new Departments("K1\\SK1\\SSK2"),
                new Departments("K1\\SK1\\SSK1")
        );

        ds.stringToList(departments);
        List<Departments> result = ds.AscendingOrDescendingSort(-1);
        assertEquals(result, expect);
    }
}