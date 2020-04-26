package com.bridgelabz.seliniumtesting.fileoperations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class CreateFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String workingDir = System.getProperty("user.dir");
		FileWriter file = new FileWriter(workingDir + "\\ExcelSheet\\ExcelSheet.csv");
		file.append("name");
		file.append(",");
		file.append("email");
		file.append(",");
		file.append("password");
		file.append(",");
		file.append("mobileNumber");
		file.append("\n");
		@SuppressWarnings("unchecked")
		List<List<String>> rows = Arrays.asList(Arrays.asList("shaiksha","iamshaiksha2019@gmail.com","Shaiksha@123","7993374636"));
		for (List<String> data : rows) 
		{
			file.append(String.join(",", data));
			file.append("\n");
		}
		System.out.println("Details  stored sucessfully in a file ...");
		file.flush();
		file.close();

	}

}
