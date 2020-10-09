package com.au.momenton.utils;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.au.momenton.model.Employee;

public class CsvLoaderTest {

    @Test
    public void loadFromResource() throws Exception {
        CsvLoader csvLoader = new CsvLoader();
        Map<Integer, Employee> employees = csvLoader.loadFromResource("/employee_data.csv", true);
        assertEquals(3, employees.size());
    }
}