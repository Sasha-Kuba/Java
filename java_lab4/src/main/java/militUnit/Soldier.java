package militUnit;
import java.time.LocalDate;
import java.util.Objects;

/**
 * class "Soldier" with fields: phoneNumber, salary, passportNumber , post
 * @author Desktop_PC
 * @version 1.0
 */
public class Soldier extends Person{

    public String phoneNumber;
    public int salary;
    public String passportNumber;
    public String post;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }


    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }
    /**
     *  Overridden function
     *  an instance of a class "Soldier"
     *  @return  the string representation
     */
    @Override
    public String toString() {
        return "Soldier{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", passportNumber=" + passportNumber +
                ", post=" + post +
                '}';
    }

    /**
     * Overridden function of comparison
     * @return  the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soldier soldier)) return false;
        if (!super.equals(o)) return false;
        return salary == soldier.salary && passportNumber.equals(soldier.passportNumber) && post.equals(soldier.post) &&
                phoneNumber.equals(soldier.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, salary, passportNumber,post);
    }

    /**
     * Class "Builder"
     * @author Desktop_PC
     * @version 1.0
     */
    public static class Builder {
        private Soldier soldier;

        public Builder(){ soldier = new Soldier(); }

        /**
         * Setter for firstname
         *
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            soldier.firstname = firstname;
            return this;
        }

        /**
         * Setter for lastname
         * @param lastname - surname
         * @return  current object
         */
        public Builder setLastname(String lastname){
            soldier.lastname = lastname;
            return this;
        }

        /**
         * Setter for dateOfBirth
         * @param dateOfBirth - date of birth
         * @return  current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            soldier.dateOfBirth = dateOfBirth;
            return this;
        }
        /**
         * Setter for passportNumber
         * @param passportNumber - passport ID
         * @return  current object
         */
        public Builder setPassportNumber(String passportNumber){
            soldier.passportNumber = passportNumber;
            return this;
        }

        /**
         * Setter for salary
         * @param salary - salary
         * @return  current object
         */
        public Builder setSalary(int salary){
            soldier.salary = salary;
            return this;
        }

        /**
         * Setter for phone number
         * @param phoneNumber - phone number
         * @return current object
         */
        public Builder setPhoneNumber(String phoneNumber){
            soldier.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for position
         * @param post - position
         * @return current object
         */
        public Builder setPost(String post){
            soldier.post = post;
            return this;
        }



        public Soldier build(){
            return soldier;
        }
    }

    public static void main(String args[]) {
    }
}