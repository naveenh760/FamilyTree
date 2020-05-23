package model;

import java.util.*;
import java.util.stream.Collectors;

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

	public void setSpouse(Person spouse) {
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
		return getChildren().stream()
				.filter(p -> p.isMale())
				.collect(Collectors.toList());
	}

	public List<Person> getDaughters() {
		return getChildren().stream()
				.filter(p -> p.isFemale())
				.collect(Collectors.toList());
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
		return getSiblings().stream()
				.filter(Person::isMale)
				.collect(Collectors.toList());
	}

	public List<Person> getSisters() {
		return getSiblings().stream()
				.filter(Person::isFemale)
				.collect(Collectors.toList());
	}

	public List<Person> getBrotherInLaws() {
		// Spouse's brothers and Husbands of siblings

		Person spouse = this.getSpouse();
		List<Person> brothersOfSpouse = new LinkedList<Person>();
		if (spouse != null) {
			brothersOfSpouse = spouse.getBrothers();
		}
		
		List<Person> husbandsOfSisters = new LinkedList<Person>();
		husbandsOfSisters = this.getSisters().stream()
						 .map(sister -> sister.getSpouse())
						 .collect(Collectors.toList());
		
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
		
		List<Person> wivesOfBrothers = new LinkedList<Person>();
		wivesOfBrothers = this.getBrothers().stream()
						  .map(brother -> brother.getSpouse())
						  .collect(Collectors.toList());
		
		List<Person> sisterInLaws = new LinkedList<Person>(sistersOfSpouse);
		sisterInLaws.addAll(wivesOfBrothers);
		return sisterInLaws;

	}

	public List<Person> getPaternalAunts() {
		// Father's sisters
	 return	this.getMother().getSpouse().getSisters();
	}

	public List<Person> getMaternalAunts() {
		// Mother's Sisters
		return this.getMother().getSisters();
	}

	public List<Person> getMaternalUncles() {
		// Mother's brothers		
		return this.getMother().getBrothers();
	}

	public List<Person> getPaternalUncles() {
		// Father's brothers
		return this.getMother().getSpouse().getBrothers();
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
