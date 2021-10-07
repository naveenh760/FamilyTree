package com.geektrust.family.tree.main;

import java.io.*;
import com.geektrust.family.tree.utility.DataReader;

public class MainPgm {

	public static void main(String[] args) {
		Family family = new Family();
		family.buildInitialTree("../src/main/resources/InitialTree.txt");
		try {
			ProcessInput(args[0], family);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" Please enter location to input file");
		} catch (FileNotFoundException e1) {
			System.out.println("The input file does not exist");
		} catch (IOException e) {
			System.out.println("Error reading from file");
		}
	}

	public static void ProcessInput(String fileName, Family family) throws IOException {
		File file = new File(fileName);
		DataReader reader = new DataReader(file);
		family.readCommands(reader);
	}

}
