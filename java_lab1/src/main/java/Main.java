import milit_unit.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Soldier soldier1 = new Soldier.Builder()
                .setFirstname("Sanya")
                .setLastname("Sancious")
                .setDateOfBirth(LocalDate.of(1990, 12, 18))
                .setSalary(25000)
                .setPost("Sniper")
                .setPassportNumber("1253453543")
                .setPhoneNumber("432423442342").build();

        System.out.println(soldier1);

        List<Soldier> soldierList = List.of(soldier1);
        Worker worker = new Worker.Builder()
                .setFirstname("Aleks")
                .setLastname("Arestov")
                .setDateOfBirth(LocalDate.of(1980, 11, 4))
                .setSoldier(soldierList)
                .setPost("General")
                .setPhoneNumber("34234242342")
                .setPassportNumber("323543234")
                .setSalary(39000).build();
        System.out.println(worker);

        List<Worker> workerList = List.of(worker);

        Unit hospital = new Unit.Builder()
                .setAddress("Holovna 121")
                .setNumber(1)
                .setWorkers(workerList).build();
        System.out.println(hospital);
    }
}


