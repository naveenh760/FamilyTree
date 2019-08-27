package commands;

import java.util.List;

import familyTree.Family;
import familyTree.Person;

public class AddChildIni extends Command {

	public AddChildIni(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		// ADD_CHILD "Mother's-name" "Child's-name" "Gender"
        String result = "";
		if (arguments.size() != 3) {
			result = "Invalid number of arugments to ADD_CHILD";
			return result;
		} else {
			String motherName = arguments.get(0);
			String childName = arguments.get(1);
			String gender = arguments.get(2);
			Person mother = family.personMap.get(motherName);
			result = validateMother(mother);
			if(!result.isEmpty()) {
				return result;
			}
			else {
				Person child;
				if (gender.equals("Male") || gender.equals("Female")) {
					child = new Person(childName,gender);
				} 
			    else {
					result = "CHILD_ADDITION_FAILED";
					return result;
				}

				family.personMap.put(childName, child);
				mother.addChild(child);
				return result;
			}

		}

	}
	
	private String validateMother(Person mother) {
		String result = "";
		if (mother == null) {
			result = "PERSON_NOT_FOUND";
			return result;
		} else if (mother.isMale()) {
			result = "CHILD_ADDITION_FAILED";
			return result;
		} 

		if (mother.getSpouse() == null) {
			result = "PERSON_NOT_MARRIED";
			return result;
		}
       return result;
	}

}
