package com.orangehrm.utils;

import java.util.ArrayList;

public class ExcelData {

	static ExcelReader reader;
	public static String filePath = System.getProperty("user.dir") + "\\resources\\TestData.xlsx";
	static String sheetName;

	public static ArrayList<Object[]> readExcelTestData() {
		ArrayList<Object[]> xclData = new ArrayList<Object[]>();
		try {
			reader = new ExcelReader(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheetName = reader.getSheetName(0);

		for (int rownNum = 2; rownNum < (reader.rowCount(sheetName) + 1); rownNum++) // SheetName
		{
			String username = reader.getCellData(sheetName, 0, rownNum);
			String password = reader.getCellData(sheetName, 1, rownNum);

			// Object obj[] = new Object[];
			Object obj[] = { username, password };
			xclData.add(obj);
			System.out.println(rownNum + " "+ obj[0] + " "+ obj[1]);
		}
		return xclData;
	}
}
