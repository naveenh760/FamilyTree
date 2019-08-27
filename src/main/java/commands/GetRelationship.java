package commands;

import java.util.ArrayList;
import java.util.List;

import familyTree.Family;
import familyTree.Person;

public class GetRelationship extends Command {

	public GetRelationship(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		String result = "";
		if (arguments.size() != 2) {
			result = "Invalid number of arguments to GET_RELATIONSHIP";
			return result;
		} else {
			String personName = arguments.get(0);
			String relationship = arguments.get(1);
			if (family.personMap.containsKey(personName)) {
				Person person = family.personMap.get(personName);
				List<Person> personRelationList;

				try {
					switch (relationship) {
					case "Paternal-Uncle":
						personRelationList = person.getPaternalUncles();
						result = Family.personListToString(personRelationList);
						break;
					case "Maternal-Uncle":
						personRelationList = person.getMaternalUncles();
						result = Family.personListToString(personRelationList);
						break;
					case "Paternal-Aunt":
						personRelationList = person.getPaternalAunts();
						result = Family.personListToString(personRelationList);
						break;
					case "Maternal-Aunt":
						personRelationList = person.getMaternalAunts();
						result = Family.personListToString(personRelationList);
						break;
					case "Sister-In-Law":
						personRelationList = person.getSisterInLaws();
						result = Family.personListToString(personRelationList);
						break;
					case "Brother-In-Law":
						personRelationList = person.getBrotherInLaws();
						result = Family.personListToString(personRelationList);
						break;
					case "Son":
						personRelationList = person.getSons();
						result = Family.personListToString(personRelationList);
						break;
					case "Daughter":
						personRelationList = person.getDaughters();
						result = Family.personListToString(personRelationList);
						break;
					case "Siblings":
						personRelationList = person.getSiblings();
						result = Family.personListToString(personRelationList);
						break;
					default:
						result = "INVALID_RELATIONSHIP";
						break;
					}

				} catch (NullPointerException e) {
					result = "NONE";
				}

			} else {
				result = "PERSON_NOT_FOUND";
			}

		}
		return result;
	}

}
