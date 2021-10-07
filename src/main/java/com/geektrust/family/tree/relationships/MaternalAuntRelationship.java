package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public class MaternalAuntRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Mother's Sisters
        return RelationshipFactory.create("Sister")
                .getRelatedPersons(p.getMother());
    }
}
