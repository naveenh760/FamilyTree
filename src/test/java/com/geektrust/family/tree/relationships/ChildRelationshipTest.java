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
        Person mother = Person.builder().name("A").gender("Female").build();
        Person childB = Person.builder().name("B").gender("Male").mother(mother).build();
        Person childC = Person.builder().name("C").gender("Female").mother(mother).build();
        PersonRelationship childRelationShip = RelationshipFactory.create("Child");
        List<Person> children =childRelationShip.getRelatedPersons(mother);
        assertTrue(children.contains(childB));
        assertTrue(children.contains(childC));
    }
}