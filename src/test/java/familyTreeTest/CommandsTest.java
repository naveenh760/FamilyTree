package familyTreeTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import commands.Command;
import familyTree.Family;

class CommandsTest {

	static Family family = new Family();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		family.buildInitialTree("./src/main/resources/InitialTree.txt");
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/commandsTestFile.csv")
	void commandsTest(String commandText, String expectedResult) {
		String[] tokens = commandText.split("\\s+");
		Command command = Command.Factory.create(tokens, family);
		String result = command.execute();
		assertEquals(expectedResult, result);
	}

}
