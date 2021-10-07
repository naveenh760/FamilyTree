package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.List;

public class PaternalAuntRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Father's sisters
        return	RelationshipFactory.create("Sister")
                .getRelatedPersons(p.getMother().getSpouse());
    }
}
