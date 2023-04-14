package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService {
    ArrayList<Tester> testers = new ArrayList<>();

    public TesterService(){

    }

    public boolean CreateTester(String firstName, String secondName){
        if(firstName != null && firstName.isEmpty()){
            if (secondName == null && firstName.isEmpty()){
                return false;
            }
        }
        int id = (int)(1 + Math.random() * 10);
        boolean f = false;
        for(Tester t: testers){
            if(t.id == id){
                f = true;
            }
        }
        if(!f){
            Tester t = new Tester(id, firstName, secondName);
            testers.add(t);
            return true;
        }
        return false;
    }

    public Tester GetTester(String firstName, String secondName){
        for (Tester t: testers) {
            if(t.firstName.equalsIgnoreCase(firstName) && t.secondName.equalsIgnoreCase(secondName)){
                return t;
            }
        }
        return null;
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
