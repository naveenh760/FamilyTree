package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrotherInLawRelationshipTest {

    static Family family = new Family();

    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }


    @ParameterizedTest
    @CsvSource({ "Tritha, Jaya", "Amba, Ish Vich Aras" })
    void getRelatedPersons(String personName, String expected) {
        // Spouse's brothers and Husbands of siblings
        if (family.getPersonMap().containsKey(personName)) {
            Person testPerson = family.getPersonMap().get(personName);
            List<Person> brotherInLaws = RelationshipFactory.create("Brother-In-Law").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(brotherInLaws);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}