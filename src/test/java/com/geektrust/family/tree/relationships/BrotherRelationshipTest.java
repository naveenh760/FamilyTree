package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrotherRelationshipTest {

    @Test
    void getRelatedPersons() {
        Person mother = new Person("A", "Female");
        Person childB = new Person("B", "Male");
        Person childC = new Person("C", "Female");
        Person childD = new Person("D", "Male");
        mother.addChild(childB);
        mother.addChild(childC);
        mother.addChild(childD);
        List<Person> brothers = RelationshipFactory.create("Brother").getRelatedPersons(childC);
        assertTrue(brothers.contains(childD));
    }
}