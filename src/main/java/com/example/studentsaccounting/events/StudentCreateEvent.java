package com.example.studentsaccounting.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentCreateEvent extends ApplicationEvent {
    private final String studentInfo;

    public StudentCreateEvent(Object source, String studentInfo) {
        super(source);
        this.studentInfo = studentInfo;
    }
}
