package com.geektrust.family.tree.commands;

import com.geektrust.family.tree.main.Family;
import com.geektrust.family.tree.model.Person;

import java.util.List;

public class AddSpouse1 extends Command{

    protected AddSpouse1(List<String> arguments, Family family) {
        super(arguments, family);
    }

    @Override
    public String execute() {
        // ADD_SPOUSE1 "Person1" "Person2" "Gender"
        String result = "";
        String husbandName = "";
        String wifeName = "";
        if (arguments.size() != 3) {
            result = "Invalid number of arguments to ADD_SPOUSE1";
        } else {
            String gender = arguments.get(2);
            if(gender.equals("Female")){
                husbandName = arguments.get(0);
                wifeName = arguments.get(1);
            }
            else if(gender.equals("Male")){
                wifeName = arguments.get(0);
                husbandName = arguments.get(1);
            }
            else{
                result = "Invalid gender";
            }

            Person husband;
            Person wife;

            if (family.getPersonMap().containsKey(husbandName)) {
                husband = family.getPersonMap().get(husbandName);
                if(husband.isFemale() || husband.getSpouse() != null){
                    result = "SPOUSE_ADDITION_FAILED";
                    return result;
                }
            } else {
                husband = Person.builder()
                        .name(husbandName)
                        .gender("Male")
                        .build();
                family.getPersonMap().put(husbandName, husband);
            }

            if (family.getPersonMap().containsKey(wifeName)) {
                wife = family.getPersonMap().get(wifeName);
                if(wife.isMale() || wife.getSpouse() != null){
                    result = "SPOUSE_ADDITION_FAILED";
                    return result;
                }
            } else {
                wife = Person.builder()
                        .name(wifeName)
                        .gender("Female")
                        .build();
                family.getPersonMap().put(wifeName, wife);
            }

            Family.setSpouseRelation(husband, wife);
        }
        if (result.isEmpty()) {
            result = "SPOUSE_ADDITION_SUCCEDED";
        }
        return result;

    }
}
