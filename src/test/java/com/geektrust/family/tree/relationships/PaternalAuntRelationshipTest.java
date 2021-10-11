package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaternalAuntRelationshipTest {
    static Family family = new Family();

    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }


    @ParameterizedTest
    @CsvSource({ "Vasa, Atya", "Chika,Satya" })
    void getRelatedPersons(String personName, String expected) {
        // Father's sisters
        if (family.personMap.containsKey(personName)) {
            Person testPerson = family.personMap.get(personName);
            List<Person> paternalAunts = RelationshipFactory.create("Paternal-Aunt").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(paternalAunts);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}