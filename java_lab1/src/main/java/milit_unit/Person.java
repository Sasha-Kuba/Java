package milit_unit;

import java.time.LocalDate;
import java.util.Objects;
/**
 * class "Person" with fields: firstname, lastname, dateOfBirth
 * @author Desktop_PC
 * @version 1.0
 */
public class Person {
    public String firstname;
    public String lastname;
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
            return person;
        }
    }

    public static void main(String args[]) {
    }

}