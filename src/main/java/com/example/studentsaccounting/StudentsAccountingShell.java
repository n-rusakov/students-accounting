package com.example.studentsaccounting;

import com.example.studentsaccounting.entities.Student;
import com.example.studentsaccounting.events.StudentCreateEvent;
import com.example.studentsaccounting.events.StudentDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.HashMap;

@ShellComponent
public class StudentsAccountingShell {
    private final HashMap<Integer, Student> students = new HashMap<>();
    private int lastId = 0;

    @Autowired
    private ApplicationEventPublisher publisher;

    private int getNextId(){
        return ++lastId;
    }

    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "f") String firstName,
                           @ShellOption(value = "l") String lastName,
                           @ShellOption(value = "a") int age) {

        int id = getNextId();
        Student student = new Student(id, firstName, lastName, age);

        students.put(id, student);

        StudentCreateEvent event = new StudentCreateEvent(this, student.toString());
        publisher.publishEvent(event);
    }

    @ShellMethod(key = "c")
    public void clear() {
        students.clear();
    }

    /*@ShellMethod(key = "e")
    public void exitewe() {
        this.ex
    }*/

    @ShellMethod(key = "p")
    public void print() {
        students.values().forEach(System.out::println);
    }

    @ShellMethod(key = "d")
    public void delete(int id) {
        if (students.containsKey(id)) {
            students.remove(id);
            StudentDeleteEvent event = new StudentDeleteEvent(this, id);
            publisher.publishEvent(event);
        }
    }

    public void init() {
        addStudent("Ivan", "Ivanov", 17);
        addStudent("Igor", "Olenev", 18);
        addStudent("Tatiana", "Smirnova", 20);
        addStudent("Oleg", "Pushkin", 19);
        addStudent("Vasiliy", "Lebedev", 17);
        addStudent("Artem", "Pavlov", 18);
    }

}
