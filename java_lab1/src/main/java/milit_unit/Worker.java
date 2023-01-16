package milit_unit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * class "Worker" with fields: phoneNumber, salary, passportNumber , post, soldier
 * @author Desktop_PC
 * @version 1.0
 */
public class Worker extends Person{
    public String phoneNumber;
    public int salary;
    public String passportNumber;
    public String post;
    public List<Soldier> soldier = new ArrayList<>();

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

    public List<Soldier> getSoldier() {
        return soldier;
    }

    public void setSoldier(List<Soldier> soldier) {
        this.soldier = soldier;
    }

    /**
     *  Overridden function
     *  an instance of a class "Worker"
     *  @return  the string representation
     */
    @Override
    public String toString() {
        return "Worker{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary + '\'' +
                ", passportNumber=" + passportNumber + '\'' +
                ", post=" + post + '\'' +
                ", soldiers=" + soldier + '\'' +
                '}';
    }

    /**
     * Overridden function of comparison
     * @param o
     * @return  the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        if (!super.equals(o)) return false;
        return salary == worker.salary && passportNumber.equals(worker.passportNumber) && post.equals(worker.post) &&
                phoneNumber.equals(worker.phoneNumber) && Objects.equals(soldier, worker.soldier);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, salary, passportNumber,post,soldier);
    }


    public static class Builder {
        private Worker worker;

        public Builder(){ worker = new Worker(); }

        /**
         * Setter for name
         *
         * @param firstname - name
         * @return  current object
         */
        public Builder setFirstname(String firstname){
            worker.firstname = firstname;
            return this;
        }

        /**
         * Setter for surname
         * @param lastname - surname
         * @return  current object
         */
        public Builder setLastname(String lastname){
            worker.lastname = lastname;
            return this;
        }

        /**
         * Setter for date
         * @param dateOfBirth - date of birth
         * @return  current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            worker.dateOfBirth = dateOfBirth;
            return this;
        }

        /**
         * Setter for passport
         * @param passportNumber - passport id
         * @return  current object
         */
        public Builder setPassportNumber(String passportNumber){
            worker.passportNumber = passportNumber;
            return this;
        }

        /**
         * Setter for salary
         * @param salary - salary
         * @return current object
         */
        public Builder setSalary(int salary){
            worker.salary = salary;
            return this;
        }

        /**
         * Setter for phone number
         * @param phoneNumber - phone number
         * @return current object
         */
        public Builder setPhoneNumber(String phoneNumber){
            worker.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for position
         * @param post - position
         * @return current object
         */
        public Builder setPost(String post){
            worker.post = post;
            return this;
        }

        /**
         * Setter for list of soldier
         * @param soldier - soldier
         * @return current object
         */
        public Builder setSoldier(List<Soldier> soldier){
            worker.soldier.addAll(soldier);
            return this;
        }


        public Worker build(){
            return worker;
        }
    }

    public static void main(String args[]) {
    }
}