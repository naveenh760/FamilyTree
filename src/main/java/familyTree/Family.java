package familyTree;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import commands.Command;
import model.Person;
import utility.DataReader;

public class Family {

	public Family() {
		personMap = new HashMap<>();
	}

	public Map<String, Person> personMap;

	public static void setSpouseRelation(Person husband, Person wife) {
		wife.setSpouse(husband);
		husband.setSpouse(wife);
	}

	public void buildInitialTree(String fileName) {

		try {
			File file = new File(fileName);
			// System.out.println(file.getAbsolutePath());
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

}
