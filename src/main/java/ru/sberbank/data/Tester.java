package ru.sberbank.data;

public class Tester {
    public int id;
    public boolean isFree;
    public Task currentTask;
    public String firstName;
    public String secondName;

    public Tester(int id, String firstName, String secondName){
        this.id = id;
        this.isFree = true;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public boolean equ(Tester d){
        if(this.id == d.id){
            if(this.firstName.equalsIgnoreCase(d.firstName) && this.secondName.equalsIgnoreCase(d.secondName)) {
                return true;
            }
        }
        return false;
    }

    public boolean AddTask(Task t){
        if (this.isFree == true && this.currentTask == null){
            this.currentTask = t;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task CheckTask(){
        if(this.currentTask != null && this.currentTask.isDeveloped == true){
            this.currentTask.isTested = true;
        }
        return this.currentTask;
    }

    public void Release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", isFree=" + isFree +
                ", currentTask=" + currentTask +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
