package milit_unit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * class "Unit" with fields: number, address, workers
 * @author Desktop_PC
 * @version 1.0
 */
public class Unit{
    public int number;
    public String address;
    public List<Worker> workers = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    /**
     *  Overridden function
     *  an instance of a class "Unit"
     *  @return  the string representation
     */
    @Override
    public String toString() {
        return "Unit{" +
                "number=" + number +
                ", address='" + address + '\'' +
                ", workers=" + workers +
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
        if (!(o instanceof Unit unit)) return false;
        return number == unit.number && Objects.equals(address, unit.address) && Objects.equals(workers, unit.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address, workers);
    }

    public static class Builder {
        private Unit unit;

        public Builder(){ unit = new Unit(); }


        /**
         * Setter for unit number
         * @param number - unit number
         * @return current object
         */
        public Builder setNumber(int number){
            unit.number = number;
            return this;
        }

        /**
         * Setter for unit addres
         * @param address - unit address
         * @return  current object
         */
        public Builder setAddress(String address){
            unit.address = address;
            return this;
        }


        /**
         * Setter for workers of unit
         * @param workers - workers
         * @return current object
         */
        public Builder setWorkers(List<Worker> workers){
            unit.workers.addAll(workers);
            return this;
        }

        /**
         * Function of creating an object of class "Unit"
         * @return  new object of class "Unit"
         */
        public Unit build(){
            return unit;
        }
    }

    public static void main(String args[]) {
    }
}