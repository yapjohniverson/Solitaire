package com.svi.training.handson1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

	/*
	 * this method reads from a file and returns the value of the file in a string
	 */
	@SuppressWarnings("resource")
	public String readFile(String inputFile) throws IOException {

		String txtFile = "";
		txtFile = new String(Files.readAllBytes(Paths.get(inputFile)));

		return txtFile;

		// todo write a code to read from file and place result into a string
		// return string
	}

}
