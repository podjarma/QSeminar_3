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

    public Task getTaskBId(int id){
        for (Task t: arrayList) {
            if (t.id == id) {
                return t;
            }
        }
        throw new IllegalStateException("Исключение");
    }


    public void addCommentToTask(int id, String comment){
        Task t = getTaskBId(id);
        if (comment.isEmpty() && comment == null){
            throw new IllegalArgumentException("Комментарий пустой");
        }
        int cnt = 0;
        for (Integer i: t.comments.keySet()){
            if (i > cnt){
                cnt = i;
            }
        }
        t.comments.put(++cnt, comment);
    }
}