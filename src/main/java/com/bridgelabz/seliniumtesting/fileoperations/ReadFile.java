package com.bridgelabz.seliniumtesting.fileoperations;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String workingDir = System.getProperty("user.dir");
			BufferedReader reader = new BufferedReader(new FileReader(workingDir + "\\ExcelSheet\\ExcelSheet.csv"));
			String row;
			reader.readLine();
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				System.out.print(data[0]+"\t");
				System.out.print(data[1]+"\t");
				System.out.print(data[2]+"\t");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
