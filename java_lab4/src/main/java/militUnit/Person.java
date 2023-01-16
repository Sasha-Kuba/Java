package militUnit;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import javax.xml.xpath.XPathEvaluationResult;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * class "Person" with fields: firstname, lastname, dateOfBirth
 * @author Desktop_PC
 * @version 1.0
 */
public class Person implements Comparable<Person>{
    @Pattern(regexp = "[A-Z][a-z]{1,100}", message = "Firstname must consists only letters and first of them must started with UpperCase and word must consist only 32 letters")
    public String firstname;
    @Pattern(regexp = "[A-Z][a-z]{1,100}", message = "Lastname must consists only letters and first of them must started with UpperCase and word must consist only 32 letters")
    public String lastname;
    @PastOrPresent(message = "Must be a date in the past or in the present")
    public LocalDate dateOfBirth;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     *  Overridden function
     *  @return  the string representation
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
    /**
     * Overridden function of comparison
     * @return  the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return  the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, dateOfBirth);
    }

    @Override
    public int compareTo(Person person) {
        return 0;
    }
    private static void validate(Person person) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Person>> check = validator.validate(person);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Person> element : check){
            sb.append("Error value "+element.getInvalidValue() + " because " + element.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /**
     * Class "Builder"
     * @author Desktop_PC
     * @version 1.0
     */


    public static class Builder {
        private Person person;

        public Builder(){ person = new Person(); }
        /**
         * Setter for firstname
         * @param firstname - name
         * @return  current object
         */
        public Builder setFirstname(String firstname){
            person.firstname = firstname;
            return this;
        }

        /**
         * Setter for lastname
         * @param lastname - surname
         * @return  current object
         */
        public Builder setLastname(String lastname){
            person.lastname = lastname;
            return this;
        }

        /**
         * Setter for dateOfBirth
         * @param dateOfBirth - date of birth
         * @return  current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            person.dateOfBirth = dateOfBirth;
            return this;
        }
        /**
         * Function of creating an object of class "Person"
         * @return  new object of class "Person"
         */
        public Person build(){
            validate(person);
            return person;
        }
    }



    public static void main(String args[]){
        try{
            Person person = new Person.Builder()
                    .setFirstname("sgrsg")
                    .setLastname("Hlj3")
                    .setDateOfBirth(LocalDate.of(2024, 2, 9))
                    .build();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}