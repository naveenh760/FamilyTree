package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaughterRelationshipTest {

    @Test
    void getRelatedPersons() {
        Person mother = new Person("A", "Female");
        Person childB = new Person("B", "Male");
        Person childC = new Person("C", "Female");
        mother.addChild(childB);
        mother.addChild(childC);
        List<Person> daughters = RelationshipFactory.create("Daughter").getRelatedPersons(mother);
        assertTrue(daughters.contains(childC));
        assertFalse(daughters.contains(childB));

    }
}