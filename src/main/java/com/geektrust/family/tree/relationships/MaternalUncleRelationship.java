package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public class MaternalUncleRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Mother's brothers
        return RelationshipFactory.create("Brother")
                .getRelatedPersons(p.getMother());

    }
}
