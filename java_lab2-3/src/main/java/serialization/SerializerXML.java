package serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import militUnit.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializerXML implements Serializer{
    private ObjectMapper objectMapper;
    public SerializerXML(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Override
    public List<Soldier> listFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public Soldier fromFile(String fileName){
        try {
            return objectMapper.readValue(new File(fileName), Soldier.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Soldier soldier, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), soldier);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void listToFile(List<Soldier> soldiers, String fileName) {
        try {
            objectMapper.writeValue(new File(fileName), soldiers);
        } catch (IOException exc) {
            throw new RuntimeException(exc);
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
        Serializer serializer = new SerializerXML();
        serializer.toFile(soldier, "soldierXML");

        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(soldier);
        soldier = new Soldier();
        soldier.setFirstname("Andrey");
        soldier.setLastname("Sancious");
        soldier.setDateOfBirth(LocalDate.of(1990, 12, 18));
        soldier.setSalary(35000);
        soldier.setPost("Sniper");
        soldier.setPassportNumber("1253453543");
        soldier.setPhoneNumber("432423442342");
        soldiers.add(soldier);
        serializer.listToFile(soldiers, "soldiersXML");

        soldier = serializer.fromFile("soldierXML");
        System.out.println(soldier);
        soldiers = serializer.listFromFile("soldiersXML");
        System.out.println(soldiers);
    }

}
