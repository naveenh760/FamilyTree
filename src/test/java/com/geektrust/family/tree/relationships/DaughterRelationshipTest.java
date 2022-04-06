package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaughterRelationshipTest {

    @Test
    void getRelatedPersons() {
        Person mother = Person.builder().name("A").gender("Female").build();
        Person childB = Person.builder().name("B").gender("Male").mother(mother).build();
        Person childC = Person.builder().name("C").gender("Female").mother(mother).build();
        List<Person> daughters = RelationshipFactory.create("Daughter").getRelatedPersons(mother);
        assertTrue(daughters.contains(childC));
        assertFalse(daughters.contains(childB));

    }
}