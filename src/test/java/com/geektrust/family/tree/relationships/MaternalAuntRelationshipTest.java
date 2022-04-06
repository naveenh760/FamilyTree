package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaternalAuntRelationshipTest {
    static Family family = new Family();
    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }
    @ParameterizedTest
    @CsvSource({ "Vasa, NONE", "Yodhan,Tritha" })
    void getRelatedPersons(String personName, String expected) {
        // Mother's Sisters
        if (family.getPersonMap().containsKey(personName)) {
            Person testPerson = family.getPersonMap().get(personName);
            List<Person> maternalAunts = RelationshipFactory.create("Maternal-Aunt").getRelatedPersons(testPerson);
            String actualOutput = Family.personListToString(maternalAunts);
            assertEquals(expected, actualOutput);

        } else {
            fail("Invalid Test data");
        }
    }
}