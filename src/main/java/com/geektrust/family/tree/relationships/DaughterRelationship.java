package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class DaughterRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        PersonRelationship childRelationship = RelationshipFactory.create("Child");
        List<Person>  children = childRelationship.getRelatedPersons(p);
        return children.stream()
                .filter(Person::isFemale)
                .collect(Collectors.toList());
    }
}
