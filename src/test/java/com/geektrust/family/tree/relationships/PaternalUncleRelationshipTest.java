package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaternalUncleRelationshipTest {
    static Family family = new Family();
    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }

    @ParameterizedTest
    @CsvSource({ "Tritha, Ish Vich Aras", "Vasa, Vyas" })
    void getRelatedPersons(String personName,String expected) {
        // Father's brothers
        if (family.personMap.containsKey(personName)) {
            Person testPerson = family.personMap.get(personName);
            List<Person> paternalUncles = RelationshipFactory.create("Paternal-Uncle").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(paternalUncles);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}