package com.geektrust.family.tree.model;

import java.util.*;
import java.util.stream.Collectors;

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
	public List<Person> children;
	Person spouse;

	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender.equals("Male") ? Gender.Male : Gender.Female;
		this.children = new ArrayList<>();
	}

	public Person getMother() {
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
		return this.gender == Gender.Male;
	}

	public boolean isFemale() {
		return this.gender == Gender.Female;
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
				.filter(Person::isMale)
				.collect(Collectors.toList());
	}

	public List<Person> getDaughters() {
		return getChildren().stream()
				.filter(Person::isFemale)
				.collect(Collectors.toList());
	}

	public List<Person> getSiblings() {
		Person mother = getMother();
		if (mother == null) {
			return Collections.emptyList();
		}
		List<Person> siblings = new LinkedList<>(mother.getChildren());
		siblings.remove(this);
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
		List<Person> brothersOfSpouse = new LinkedList<>();
		if (spouse != null) {
			brothersOfSpouse = spouse.getBrothers();
		}
		
		List<Person> husbandsOfSisters;
		husbandsOfSisters = this.getSisters().stream()
						 .map(Person::getSpouse)
						 .collect(Collectors.toList());
		
		List<Person> brotherInLaws = new LinkedList<>(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);
		return brotherInLaws;
	}

	public List<Person> getSisterInLaws() {
		// Spouse's sisters and Wives of siblings

		Person spouse = this.getSpouse();
		List<Person> sistersOfSpouse = new LinkedList<>();
		if (spouse != null) {
			sistersOfSpouse = spouse.getSisters();
		}
		
		List<Person> wivesOfBrothers;
		wivesOfBrothers = this.getBrothers().stream()
						  .map(Person::getSpouse)
						  .collect(Collectors.toList());
		
		List<Person> sisterInLaws = new LinkedList<>(sistersOfSpouse);
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
