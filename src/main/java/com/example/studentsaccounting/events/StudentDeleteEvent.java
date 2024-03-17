package com.example.studentsaccounting.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentDeleteEvent extends ApplicationEvent {
    private final int id;

    public StudentDeleteEvent(Object source, int id) {
        super(source);
        this.id = id;
    }
}
