package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public interface PersonRelationship {

    List<Person> getRelatedPersons(Person p);
}
