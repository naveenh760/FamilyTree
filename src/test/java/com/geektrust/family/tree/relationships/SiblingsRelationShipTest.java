package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiblingsRelationShipTest {

    @Test
    void getRelatedPersons() {
        Person mother = Person.builder().name("A").gender("Female").build();
        Person childB = Person.builder().name("B").gender("Male").mother(mother).build();
        Person childC = Person.builder().name("C").gender("Female").mother(mother).build();
        List<Person> siblings = RelationshipFactory.create("Siblings").getRelatedPersons(childB);
        assertTrue(siblings.contains(childC));
        assertEquals(1, siblings.size());
    }
}