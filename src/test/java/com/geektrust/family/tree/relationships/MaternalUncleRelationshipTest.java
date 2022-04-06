package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaternalUncleRelationshipTest {
    static Family family = new Family();
    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }
    @ParameterizedTest
    @CsvSource({ "Atya, Chit Ish Vich Aras", "Kriya, NONE" })
    void getRelatedPersons(String personName, String expected) {
        // Mother's brothers
        if (family.getPersonMap().containsKey(personName)) {
            Person testPerson = family.getPersonMap().get(personName);
            List<Person> maternalUncles = RelationshipFactory.create("Maternal-Uncle").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(maternalUncles);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}