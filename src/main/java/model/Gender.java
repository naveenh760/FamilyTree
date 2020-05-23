package model;

public enum Gender {

	Male("Male"), Female("Female");
	@SuppressWarnings("unused")
	private final String name;

	private Gender(String name) {
		this.name = name;
	}
}
