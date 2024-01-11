package com.demo.crm_Hybridframework.LoginTest;

import java.util.ArrayList;

import org.junit.Test;

import com.demo.crm_Hybridframework.base.ExcelReader;
import com.demo.crm_Hybridframework.base.keywordImpl;

public class LoginTest {

	@Test
	public void Test() 

	{
		keywordImpl key = new keywordImpl();
		ArrayList data = ExcelReader.getTestData("E:\\Assignment.xlsx");
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals("open")) {
				key.open();
			}
			if (data.get(i).equals("url")) {
				key.url(data.get(i + 1).toString());
			}
			
			

			if (data.get(i).equals("click")) {
				String objectName = data.get(i + 2).toString();
				key.click(objectName);
			}
			
			if (data.get(i).equals("input")) {
				String testdata = data.get(i + 1).toString();
				String objectName = data.get(i + 2).toString();
				key.input(testdata, objectName);
			}

		}

	}

}
