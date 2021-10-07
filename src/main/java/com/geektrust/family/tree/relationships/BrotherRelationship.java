package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class BrotherRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        PersonRelationship siblingsRelationship = RelationshipFactory.create("Siblings");
        List<Person> siblings = siblingsRelationship.getRelatedPersons(p);
        return siblings.stream()
                .filter(Person::isMale)
                .collect(Collectors.toList());
    }
}
