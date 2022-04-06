package com.geektrust.family.tree.model;

import com.geektrust.family.tree.main.Family;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    static Family family = new Family();

    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }

    @Test
    void testAddChild() {
        Person mother = Person.builder().name("A").gender("Female").build();
        Person child = Person.builder().name("B").gender("Male").mother(mother).build();
        assertTrue(mother.getChildren().contains(child));
    }
}