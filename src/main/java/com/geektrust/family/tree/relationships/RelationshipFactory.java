package com.geektrust.family.tree.relationships;

public class RelationshipFactory {

    public static PersonRelationship create(String relationship){
        PersonRelationship personRelationship;
        switch (relationship){
            case "Child":
                personRelationship = new ChildRelationship();
                break;
            case "Son":
                personRelationship = new SonRelationship();
                break;
            case "Daughter":
                personRelationship = new DaughterRelationship();
                break;
            case "Siblings":
                personRelationship = new SiblingsRelationShip();
                break;
            case "Sister":
                personRelationship = new SisterRelationship();
                break;
            case "Brother":
                personRelationship = new BrotherRelationship();
                break;
            case "Paternal-Uncle":
                personRelationship = new PaternalUncleRelationship();
                break;
            case "Maternal-Uncle":
                personRelationship = new MaternalUncleRelationship();
                break;
            case "Paternal-Aunt":
                personRelationship = new PaternalAuntRelationship();
                break;
            case "Maternal-Aunt":
                personRelationship = new MaternalAuntRelationship();
                break;
            case "Sister-In-Law":
                personRelationship = new SisterInLawRelationship();
                break;
            case "Brother-In-Law":
                personRelationship = new BrotherInLawRelationship();
                break;
            default:
                personRelationship = null;
        }
        return personRelationship;
    }
}
