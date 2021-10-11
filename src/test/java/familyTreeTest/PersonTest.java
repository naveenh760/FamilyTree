package familyTreeTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;

class PersonTest {

	static Family family = new Family();

	@BeforeAll
	static void setUpBeforeClass() {
		family.buildInitialTree("./src/main/resources/InitialTree.txt");
	}

	@Test
	void testAddChild() {
		Person mother = new Person("A", "Female");
		Person child = new Person("B", "Male");
		mother.addChild(child);
		assertTrue(mother.getChildren().contains(child));
	}






}
