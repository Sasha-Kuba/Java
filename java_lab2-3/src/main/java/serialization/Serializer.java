package serialization;

import militUnit.*;

import java.util.List;

public interface Serializer {
    List<Soldier> listFromFile(String filename);

     Soldier fromFile(String fileName);

    void toFile(Soldier soldier, String fileName);

    void listToFile(List<Soldier> Soldier, String fileName);
}

