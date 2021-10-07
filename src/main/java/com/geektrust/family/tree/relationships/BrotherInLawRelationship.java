package com.geektrust.family.tree.relationships;

import com.geektrust.family.tree.model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BrotherInLawRelationship implements PersonRelationship{
    @Override
    public List<Person> getRelatedPersons(Person p) {
        // Spouse's brothers and Husbands of siblings

        Person spouse = p.getSpouse();
        List<Person> brothersOfSpouse = new LinkedList<>();
        if (spouse != null) {
            brothersOfSpouse = RelationshipFactory.create("Brother").getRelatedPersons(spouse);
        }

        List<Person> husbandsOfSisters;
        husbandsOfSisters = RelationshipFactory.create("Sister").getRelatedPersons(p)
                .stream()
                .map(Person::getSpouse)
                .collect(Collectors.toList());

        List<Person> brotherInLaws = new LinkedList<>(brothersOfSpouse);
        brotherInLaws.addAll(husbandsOfSisters);
        return brotherInLaws;
    }
}
