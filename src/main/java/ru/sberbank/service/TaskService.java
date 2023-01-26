package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public boolean createTask(int id, String summary) {
        if(summary != null && !summary.isEmpty()){
            arrayList.add(new Task(id, summary));
            return true;
        }
        return false;
    }

    public Task getTask(String summary) {
        for (Task n: arrayList) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: arrayList) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        return list;
    }

}