package familyTree;

import java.util.*;
import utility.Gender;

/**
 * 
 */

/**
 * @author NH054708
 *
 */
public class Person {

	/**
	 * 
	 */

	String name;
	Gender gender;
	Person mother;
	private List<Person> children;
	Person spouse;

	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender.equals("Male") ? Gender.Male : Gender.Female;
		this.children = new ArrayList<Person>();
	}

	protected Person getMother() {
		return mother;
	}

	protected void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getSpouse() {
		return spouse;
	}

	protected void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public boolean isMale() {
		if (this.gender == Gender.Male) {
			return true;
		}
		return false;
	}

	public boolean isFemale() {
		if (this.gender == Gender.Female) {
			return true;
		}
		return false;
	}

	public void addChild(Person child) {
		children.add(child);
		child.setMother(this);
	}

	public List<Person> getChildren() {
		if (isMale()) {
			return this.getSpouse().getChildren();
		} else {
			return children;
		}

	}

	public List<Person> getSons() {
		List<Person> sons = new LinkedList<Person>();
		List<Person> childrenList = getChildren();
		for (Person child : childrenList) {
			if (child.isMale()) {
				sons.add(child);
			}
		}
		return sons;

	}

	public List<Person> getDaughters() {
		List<Person> daughters = new LinkedList<Person>();
		List<Person> childrenList = getChildren();
		for (Person child : childrenList) {
			if (child.isFemale()) {
				daughters.add(child);
			}
		}
		return daughters;
	}

	public List<Person> getSiblings() {
		Person mother = getMother();
		if (mother == null) {
			return Collections.emptyList();
		}
		List<Person> siblings = new LinkedList<Person>(mother.getChildren());
		if (siblings != null) {
			siblings.remove(this);
		}
		return siblings;
	}

	public List<Person> getBrothers() {
		List<Person> siblings = getSiblings();
		List<Person> brothers = new LinkedList<Person>();
		for (Person sibling : siblings) {
			if (sibling.isMale()) {
				brothers.add(sibling);
			}
		}
		return brothers;
	}

	public List<Person> getSisters() {
		List<Person> siblings = this.getSiblings();
		List<Person> sisters = new LinkedList<Person>();
		for (Person sibling : siblings) {
			if (sibling.isFemale()) {
				sisters.add(sibling);
			}
		}

		return sisters;
	}

	public List<Person> getBrotherInLaws() {
		// Spouse's brothers and Husbands of siblings

		Person spouse = this.getSpouse();
		List<Person> brothersOfSpouse = new LinkedList<Person>();
		if (spouse != null) {
			brothersOfSpouse = spouse.getBrothers();
		}
		List<Person> sisters = this.getSisters();
		List<Person> husbandsOfSisters = new LinkedList<Person>();
		for (Person sister : sisters) {
			Person husband = sister.getSpouse();
			husbandsOfSisters.add(husband);
		}

		List<Person> brotherInLaws = new LinkedList<Person>(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);
		return brotherInLaws;
	}

	public List<Person> getSisterInLaws() {
		// Spouse's sisters and Wives of siblings

		Person spouse = this.getSpouse();
		List<Person> sistersOfSpouse = new LinkedList<Person>();
		if (spouse != null) {
			sistersOfSpouse = spouse.getSisters();
		}
		List<Person> brothers = this.getBrothers();
		List<Person> wivesOfBrothers = new LinkedList<Person>();
		for (Person brother : brothers) {
			Person wife = brother.getSpouse();
			wivesOfBrothers.add(wife);
		}

		List<Person> sisterInLaws = new LinkedList<Person>(sistersOfSpouse);
		sisterInLaws.addAll(wivesOfBrothers);
		return sisterInLaws;

	}

	public List<Person> getPaternalAunts() {
		// Father's sisters

		Person father = this.getMother().getSpouse();
		List<Person> fathersSisters = father.getSisters();
		return fathersSisters;

	}

	public List<Person> getMaternalAunts() {
		// Mother's Sisters

		Person mother = this.getMother();
		List<Person> sistersOfMother = mother.getSisters();
		return sistersOfMother;

	}

	public List<Person> getMaternalUncles() {
		// Mother's brothers

		Person mother = this.getMother();
		List<Person> brothersOfMother = mother.getBrothers();
		return brothersOfMother;

	}

	public List<Person> getPaternalUncles() {
		// Father's brothers

		Person father = this.getMother().getSpouse();
		List<Person> brothersOfFather = father.getBrothers();
		return brothersOfFather;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Person)) {
			return false;
		}

		Person p = (Person) obj;
		return p.name.equals(this.name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
