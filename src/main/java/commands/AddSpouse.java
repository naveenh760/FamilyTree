package commands;

import java.util.List;

import familyTree.Family;
import familyTree.Person;

public class AddSpouse extends Command {

	public AddSpouse(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		// ADDS_SPOUSE "Husband-Name" "Wife-Name"
        String result = "";
		if (arguments.size() != 2) {
			result = "Invalid number of arguments to ADD_SPOUSE";
			return result;
		} else {
			String husbandName = arguments.get(0);
			String wifeName = arguments.get(1);
			Person husband;
			Person wife;

			if (family.personMap.containsKey(husbandName)) {
				husband = family.personMap.get(husbandName);
			} else {
				husband = new Person(husbandName,"Male");
				family.personMap.put(husbandName, husband);
			}

			if (family.personMap.containsKey(wifeName)) {
				wife = family.personMap.get(wifeName);
			} else {
				wife = new Person(wifeName, "Female");
				family.personMap.put(wifeName, wife);
			}

			Family.setSpouseRelation(husband, wife);
            return result;
		}

	}

}
