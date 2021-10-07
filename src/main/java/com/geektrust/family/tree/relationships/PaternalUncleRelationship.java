package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public class PaternalUncleRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Father's brothers
        return RelationshipFactory.create("Brother")
                .getRelatedPersons(p.getMother().getSpouse());
    }
}
