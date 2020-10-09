package com.au.momenton.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.au.momenton.model.Employee;

public class CsvLoader {

	public Map<Integer, Employee> loadFromResource(String resourceName, boolean hasHeader) throws Exception {
		Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

		try {
			// get data from the csv file inside resources folder.
			InputStream is = CsvLoader.class.getResourceAsStream(resourceName);
			InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String csvLine = bufferedReader.readLine();

			if (hasHeader) {
				csvLine = bufferedReader.readLine();
			}
			while (csvLine != null) {
				Employee employee = null;

				String[] csvField = csvLine.split(",");
				String name = csvField[0].trim();
				int id = Integer.parseInt(csvField[1]);
				int managerId = 0;
				if(csvField.length == 3 && !csvField[2].isEmpty())
					managerId = Integer.parseInt(csvField[2]);
				employee = new Employee(name, id, managerId);

				employees.put(employee.getId(), employee);
				csvLine = bufferedReader.readLine();
			}
		} catch (IOException e) {
			throw (new Exception("TransactionCsvLoader failure : Could not loadFromResource '" + resourceName + "'"));
		}
		return employees;
	}
}
