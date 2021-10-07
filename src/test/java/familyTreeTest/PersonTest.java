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




	@Test
	void testGetSiblings() {
		Person mother = new Person("A", "Female");
		Person childB = new Person("B", "Male");
		Person childC = new Person("C", "Female");
		mother.addChild(childB);
		mother.addChild(childC);

		assertTrue(childB.getSiblings().contains(childC));
		assertEquals(1, childB.getSiblings().size());
	}

	@Test
	void testGetBrothers() {
		Person mother = new Person("A", "Female");
		Person childB = new Person("B", "Male");
		Person childC = new Person("C", "Female");
		Person childD = new Person("D", "Male");
		mother.addChild(childB);
		mother.addChild(childC);
		mother.addChild(childD);

		assertTrue(childC.getBrothers().contains(childD));
	}

	@Test
	void testGetSisters() {
		Person mother = new Person("A", "Female");
		Person childB = new Person("B", "Male");
		Person childC = new Person("C", "Female");
		Person childD = new Person("D", "Male");
		mother.addChild(childB);
		mother.addChild(childC);
		mother.addChild(childD);

		assertTrue(childB.getSisters().contains(childC));
	}

	@ParameterizedTest
	@CsvSource({ "Tritha, Jaya", "Amba, Ish Vich Aras" })
	void testGetBrotherInLaws(String personName, String expected) {
		// Spouse's brothers and Husbands of siblings
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getBrotherInLaws());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}

	}

	@ParameterizedTest
	@CsvSource({ "Ish, Amba Lika Chitra", "Satvy,Atya" })
	void testGetSisterInLaws(String personName, String expected) {
		// Spouse's sisters and Wives of siblings
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getSisterInLaws());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}
	}

	@ParameterizedTest
	@CsvSource({ "Vasa, Atya", "Chika,Satya" })
	void testGetPaternalAunts(String personName, String expected) {
		// Father's sisters
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getPaternalAunts());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}
	}

	@ParameterizedTest
	@CsvSource({ "Vasa, NONE", "Yodhan,Tritha" })
	void testGetMaternalAunts(String personName, String expected) {
		// Mother's Sisters
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getMaternalAunts());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}
	}

	@ParameterizedTest
	@CsvSource({ "Atya, Chit Ish Vich Aras", "Kriya, NONE" })
	void testGetMaternalUncles(String personName, String expected) {
		// Mother's brothers
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getMaternalUncles());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}
	}

	@ParameterizedTest
	@CsvSource({ "Tritha, Ish Vich Aras", "Vasa, Vyas" })
	void testGetPaternalUncles(String personName, String expected) {
		// Father's brothers
		if (family.personMap.containsKey(personName)) {
			Person testPerson = family.personMap.get(personName);
			String actualOutput = Family.personListToString(testPerson.getPaternalUncles());
			assertEquals(expected, actualOutput);

		} else {
			fail("Invalid Test data");
		}
	}

}
