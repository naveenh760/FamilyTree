package com.geektrust.family.tree.main;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.geektrust.family.tree.commands.Command;
import com.geektrust.family.tree.model.Person;
import com.geektrust.family.tree.utility.DataReader;

public class Family {

	public Family() {
		setPersonMap(new HashMap<>());
	}

	private Map<String, Person> personMap;

	public static void setSpouseRelation(Person husband, Person wife) {
		wife.setSpouse(husband);
		husband.setSpouse(wife);
	}

	public void buildInitialTree(String fileName) {

		try {
			File file = new File(fileName);
			DataReader reader = new DataReader(file);
			readCommands(reader);
		} catch (IOException e) {
			System.out.println("Initial tree could not be built");
		}
	}

	public void readCommands(DataReader reader) throws IOException {
		String line;
		while ((line = reader.getLine()) != null) {
			String[] tokens = line.split("\\s+");
			Command command = Command.Factory.create(tokens, this);
			String result = command.execute();
			if (!result.isEmpty()) {
				System.out.println(result);
			}
		}

	}

	static public String personListToString(List<Person> personRelationList) {
		String result;
		if (personRelationList == null || personRelationList.isEmpty()) {
			result = "NONE";
		}

		else {
			result = personRelationList.stream().filter(Objects::nonNull).map(Person::toString)
					.collect(Collectors.joining(" "));
		}

		return result;
	}

	public Map<String, Person> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, Person> personMap) {
		this.personMap = personMap;
	}
}
