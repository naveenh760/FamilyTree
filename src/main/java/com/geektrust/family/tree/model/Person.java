package com.geektrust.family.tree.model;

import java.util.ArrayList;
import java.util.List;

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
