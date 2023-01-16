package service;

import comparators.PersonComparator;
import comparators.PersonDateOfBirthComparator;
import militUnit.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MilitUnitService {
    private Unit unit;

    public MilitUnitService(Unit un) {
        unit = un;
    }

    public List<Worker> sortByFullName() {
        List<Worker> workers = new ArrayList<>();
        workers.addAll(unit.getWorkers());
        Collections.sort(workers);
        workers.sort(new PersonComparator());
        return workers;
    }

    public List<Worker> sortByFullNameStream() {
        return unit.getWorkers().stream().sorted(new PersonComparator()).collect(Collectors.toList());
    }

    public List<Worker>sortByDateOfBirth(){
        List<Worker> workers = new ArrayList<>();
        workers.addAll(unit.getWorkers());
        Collections.sort(workers);
        workers.sort(new PersonDateOfBirthComparator());
        return workers;
    }

    public List<Worker> sortByDateOfBirthStream(){
        return unit.getWorkers().stream().sorted(new PersonDateOfBirthComparator()).collect(Collectors.toList());
    }

    public List<Worker> findByPost(String post){
        List<Worker> workers = new ArrayList<>();
        for (Worker worker : unit.getWorkers()) {
            if (worker.getPost() == post) {
                workers.add(worker);
            }
        }
        return workers;
    }
    public List<Worker> findByPostStream(String p){
        return unit.getWorkers().stream().filter(post -> post.getPost().contains(p)).collect(Collectors.toList());
    }

    public List<Worker> filterByDate(int year){
        List<Worker> workers = new ArrayList<>();
        for (Worker worker : unit.getWorkers()) {
            if (worker.getDateOfBirth().getYear() < year ) {
                workers.add(worker);
            }
        }
        return workers;
    }
    public List<Worker> filterByDateStream(int year){
        return unit.getWorkers().stream().filter(dateOfBirth -> dateOfBirth.getDateOfBirth().isBefore(LocalDate.of(year, 1, 1 ))).collect(Collectors.toList());
    }
}