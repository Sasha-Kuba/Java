package serialization;
import militUnit.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializerTXT implements Serializer{
    private String toString(Soldier s) {
        return
                "Firstname~" + s.getFirstname() + "~" +
                        "Lastname~" + s.getLastname() + "~" +
                        "Date of birth~" + s.getDateOfBirth() + "~" +
                        "Salary~" + s.getSalary() + "~" +
                        "Post~" + s.getPost() + "~" +
                        "Passport number~" + s.getPassportNumber() + "~" +
                        "Phone number" + s.getPhoneNumber();
    }
    private String toString(List<Soldier> soldiers) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < soldiers.size(); i++) {
            res.append(toString(soldiers.get(i)));
            if (i+1 < soldiers.size()) {
                res.append(";");
            }
        }
        return res.toString();
    }
    private Soldier fromString(String s){
        String [] obj = s.split("~");
        Soldier res = new Soldier();
        res.setFirstname(obj[1]);
        res.setLastname(obj[3]);
        res.setDateOfBirth(LocalDate.parse(obj[5]));
        res.setSalary(Integer.parseInt(obj[7]));
        res.setPost(obj[9]);
        res.setPassportNumber(obj[11]);
        res.setPhoneNumber(obj[12]);
        return res;
    }

    private  List<Soldier> fromStringList(String s){
        String [] obj = s.split(";");
        List<Soldier> res = new ArrayList<>();
        for(String item:obj){
            res.add(fromString(item));
        }
        return res;
    }

    @Override
    public List<Soldier> listFromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromStringList(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Soldier fromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromString(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toFile(Soldier soldier, String fileName) {
        try (
                FileWriter fw = new FileWriter(new File(fileName));
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(toString(soldier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listToFile(List<Soldier> soldiers, String fileName) {
        try(
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toString(soldiers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        Soldier soldier = new Soldier();
        soldier.setFirstname("Sanya");
        soldier.setLastname("Sancious");
        soldier.setDateOfBirth(LocalDate.of(1990, 12, 18));
        soldier.setSalary(25000);
        soldier.setPost("Sniper");
        soldier.setPassportNumber("1253453543");
        soldier.setPhoneNumber("432423442342");

        Serializer serializer = new SerializerTXT();
        serializer.toFile(soldier, "soldierTXT");


        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(soldier);

        soldier = new Soldier();
        soldier.setFirstname("Andrey");
        soldier.setLastname("Sancious");
        soldier.setDateOfBirth(LocalDate.of(1990, 12, 18));
        soldier.setSalary(25000);
        soldier.setPost("Sniper");
        soldier.setPassportNumber("1253453543");
        soldier.setPhoneNumber("432423442342");

        soldiers.add(soldier);
        serializer.listToFile(soldiers, "soldiersTXT");

        soldier = serializer.fromFile("soldierTXT");
        System.out.println(soldier);
        soldiers = serializer.listFromFile("soldiersTXT");
        System.out.println(soldiers);
    }
}