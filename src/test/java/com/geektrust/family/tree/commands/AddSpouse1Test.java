package com.geektrust.family.tree.commands;

import com.geektrust.family.tree.main.Family;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AddSpouse1Test {
    static Family family = new Family();

    @BeforeAll
    static void setUpBeforeClass() {
        family.buildInitialTree("./src/main/resources/InitialTree.txt");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addSpouse1TestFile.csv")
    void testAddSpouse1(String commandText, String expectedResult) {
        String[] tokens = commandText.split("\\s+");
        Command command = Command.Factory.create(tokens, family);
        String result = command.execute();
        assertEquals(expectedResult, result);
    }
}