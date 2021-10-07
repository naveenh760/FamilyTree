package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChildRelationshipTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRelatedPersons() {
        Person mother = new Person("A", "Female");
        Person childB = new Person("B", "Male");
        Person childC = new Person("C", "Female");
        mother.addChild(childB);
        mother.addChild(childC);
        PersonRelationship childRelationShip = RelationshipFactory.create("Child");
        List<Person> children =childRelationShip.getRelatedPersons(mother);
        assertTrue(children.contains(childB));
        assertTrue(children.contains(childC));
    }
}