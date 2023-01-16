package comparators;


import militUnit.Person;

import java.util.Comparator;

public class PersonDateOfBirthComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2){
        return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
    }
}
