package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SiblingsRelationShip implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        Person mother = p.getMother();
        if (mother == null) {
            return Collections.emptyList();
        }
        PersonRelationship childRelationship = RelationshipFactory.create("Child");
        List<Person> children = new ArrayList<>(childRelationship.getRelatedPersons(mother));
        children.remove(p);
        return children;
    }
}
