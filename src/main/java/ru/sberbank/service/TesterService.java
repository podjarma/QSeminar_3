package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService {
    ArrayList<Tester> testers = new ArrayList<>();

    public TesterService(){

    }

    public boolean CreateTester(String firstName, String secondName){
        if((firstName == null && firstName.isEmpty()) || (secondName == null && firstName.isEmpty())){
            throw new IllegalArgumentException("Фамилия или имя пустые");
        }
        int id = testers.size();
        Tester t = new Tester(++id, firstName, secondName);
        testers.add(t);
        return true;
    }

    public Tester GetTester(String firstName, String secondName){
        for (Tester t: testers) {
            if(t.firstName.equalsIgnoreCase(firstName) && t.secondName.equalsIgnoreCase(secondName)){
                return t;
            }
        }
        throw new IllegalStateException("Тестер не найден");
    }

    public ArrayList<Tester> GetFreeTesters(){
        ArrayList<Tester> t = new ArrayList<>();
        for(Tester tester: testers){
            if (tester.isFree == true){
                t.add(tester);
            }
        }
        return t;
    }
}
