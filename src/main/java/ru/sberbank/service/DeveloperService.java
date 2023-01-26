package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService {
    public ArrayList<Developer> list;

    public DeveloperService() {
        this.list = new ArrayList<>();
    }

    public boolean createDeveloper(int id, String firstName, String secondName) {
        if((firstName != null && !firstName.isEmpty()) && (secondName != null  && !secondName.isEmpty())) {
            list.add(new Developer(id, firstName, secondName));
            return true;
        }
        return false;
    }

    public Developer getDeveloper(String firstName, String secondName) {
        for (Developer t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Developer> getFreeDevelopers() {
        ArrayList<Developer> freeTester = new ArrayList<>();
        for (Developer n: list) {
            if(n.isFree) {
                freeTester.add(n);
            }
        }
        return freeTester;
    }

}