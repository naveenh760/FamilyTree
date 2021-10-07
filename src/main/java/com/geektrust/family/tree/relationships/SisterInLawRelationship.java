package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SisterInLawRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Spouse's sisters and Wives of siblings

        Person spouse = p.getSpouse();
        List<Person> sistersOfSpouse = new LinkedList<>();
        if (spouse != null) {
            sistersOfSpouse = RelationshipFactory.create("Sister").getRelatedPersons(spouse);
        }

        List<Person> wivesOfBrothers;
        wivesOfBrothers = RelationshipFactory.create("Brother").getRelatedPersons(p)
                .stream()
                .map(Person::getSpouse)
                .collect(Collectors.toList());

        List<Person> sisterInLaws = new LinkedList<>(sistersOfSpouse);
        sisterInLaws.addAll(wivesOfBrothers);
        return sisterInLaws;
    }
}
