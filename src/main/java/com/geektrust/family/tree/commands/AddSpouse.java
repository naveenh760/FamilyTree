package com.geektrust.family.tree.commands;

import java.util.List;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;

public class AddSpouse extends Command {

	public AddSpouse(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		// ADD_SPOUSE "Husband-Name" "Wife-Name"
        String result = "";
		if (arguments.size() != 2) {
			result = "Invalid number of arguments to ADD_SPOUSE";
		} else {
			String husbandName = arguments.get(0);
			String wifeName = arguments.get(1);
			Person husband;
			Person wife;

			if (family.getPersonMap().containsKey(husbandName)) {
				husband = family.getPersonMap().get(husbandName);
			} else {
				husband = Person.builder()
						.name(husbandName)
						.gender("Male")
						.build();
				family.getPersonMap().put(husbandName, husband);
			}

			if (family.getPersonMap().containsKey(wifeName)) {
				wife = family.getPersonMap().get(wifeName);
			} else {
				wife = Person.builder()
						.name(wifeName)
						.gender("Female")
						.build();
				family.getPersonMap().put(wifeName, wife);
			}

			Family.setSpouseRelation(husband, wife);
		}
		return result;

	}

}
