package com.geektrust.family.tree.commands;

import java.util.List;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import com.geektrust.family.tree.relationships.PersonRelationship;
import com.geektrust.family.tree.relationships.RelationshipFactory;

public class GetRelationship extends Command {

	public GetRelationship(List<String> arguments, Family family) {
		super(arguments, family);
	}

	@Override
	public String execute() {
		String result;
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
					PersonRelationship personRelationship = RelationshipFactory.create(relationship);
					List<Person> persons = personRelationship.getRelatedPersons(person);
					result = Family.personListToString(persons);
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
