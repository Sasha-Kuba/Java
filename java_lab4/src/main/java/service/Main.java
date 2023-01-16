package service;

import militUnit.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Soldier soldier = new Soldier.Builder()
                .setFirstname("Sanya")
                .setLastname("Sancious")
                .setDateOfBirth(LocalDate.of(1990, 12, 18))
                .setSalary(25000)
                .setPost("Sniper")
                .setPassportNumber("1253453543")
                .setPhoneNumber("432423442342").build();

        List<Soldier> soldierList = List.of(soldier);
        Worker worker = new Worker.Builder()
                .setFirstname("Aleks")
                .setLastname("Arestov")
                .setDateOfBirth(LocalDate.of(1980, 11, 4))
                .setSoldier(soldierList)
                .setPost("General")
                .setPhoneNumber("34234242342")
                .setPassportNumber("323543234")
                .setSalary(41000).build();
        Worker worker1 = new Worker.Builder()
                .setFirstname("Paul")
                .setLastname("Brown")
                .setDateOfBirth(LocalDate.of(1985, 9, 8))
                .setSoldier(soldierList)
                .setPost("General")
                .setPhoneNumber("34234234542")
                .setPassportNumber("3235324534")
                .setSalary(40000).build();
        Worker worker2 = new Worker.Builder()
                .setFirstname("Chris")
                .setLastname("White")
                .setDateOfBirth(LocalDate.of(1971, 1, 14))
                .setSoldier(soldierList)
                .setPost("Admiral")
                .setPhoneNumber("34234242342")
                .setPassportNumber("323543234")
                .setSalary(39000).build();


        List<Worker> workers = List.of(worker2, worker1, worker);
        Unit unit = new Unit.Builder()
                .setAddress("Holovna 121")
                .setNumber(1)
                .setWorkers(workers).build();




        MilitUnitService militUnitService = new MilitUnitService(unit);

        System.out.println("Sort workers by full name:");
        System.out.println(militUnitService.sortByFullName());

        System.out.println("\nSort workers by full name (Stream):");
        System.out.println(militUnitService.sortByFullNameStream());

        System.out.println("\nSort workers by date of birth: ");
        System.out.println(militUnitService.sortByDateOfBirth());

        System.out.println("\nSort workers by date of birth (Stream): ");
        System.out.println(militUnitService.sortByDateOfBirthStream());

        System.out.println("\nFind worker by post - General");
        System.out.println(militUnitService.findByPost("General"));

        System.out.println("\nFind worker by post - General (Stream) ");
        System.out.println(militUnitService.findByPostStream("General"));

        System.out.println("\nWorkers who was born before 1981 year ");
        System.out.println(militUnitService.filterByDate(1981));

        System.out.println("\nWorkers who was born before 1981 year (Stream)");
        System.out.println(militUnitService.filterByDateStream(1981));



    }

}
