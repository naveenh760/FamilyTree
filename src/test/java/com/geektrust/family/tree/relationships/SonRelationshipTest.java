package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SonRelationshipTest {

    @Test
    void getRelatedPersons() {
        Person mother = new Person("A", "Female");
        Person childB = new Person("B", "Male");
        Person childC = new Person("C", "Female");
        mother.addChild(childB);
        mother.addChild(childC);
        PersonRelationship sonRelationship = RelationshipFactory.create("Son");
        List<Person> sons = sonRelationship.getRelatedPersons(mother);
        assertTrue(sons.contains(childB));
        assertFalse(sons.contains(childC));
    }
}