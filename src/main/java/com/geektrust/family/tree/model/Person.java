package com.geektrust.family.tree.model;

import lombok.Builder;

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

	private String name;
	private Gender gender;
	private Person mother;
	private List<Person> children;
	private Person spouse;

	@Builder
	private Person(String name, String gender,Person mother) {
		this.name = name;
		this.gender = gender.equals("Male") ? Gender.Male : Gender.Female;
		this.mother = mother;
		this.setChildren(new ArrayList<>());
		if(mother != null){
			mother.addChild(this);
		}
	}

	public Person getMother() {
		return mother;
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
		getChildren().add(child);
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

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}
}
