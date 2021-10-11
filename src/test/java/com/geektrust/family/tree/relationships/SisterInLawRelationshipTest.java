package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SisterInLawRelationshipTest {
    static Family family = new Family();

    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }

    @ParameterizedTest
    @CsvSource({ "Ish, Amba Lika Chitra", "Satvy,Atya" })
    void getRelatedPersons(String personName, String expected) {
        // Spouse's sisters and Wives of siblings
        if (family.personMap.containsKey(personName)) {
            Person testPerson = family.personMap.get(personName);
            List<Person> sisterInLaws = RelationshipFactory.create("Sister-In-Law").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(sisterInLaws);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}