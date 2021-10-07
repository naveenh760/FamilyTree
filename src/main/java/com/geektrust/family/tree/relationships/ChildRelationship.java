package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public class ChildRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        if (p.isMale()) {
            return RelationshipFactory.create("Child")
                    .getRelatedPersons(p.getSpouse());
        } else {
            return p.children;
        }
    }
}
