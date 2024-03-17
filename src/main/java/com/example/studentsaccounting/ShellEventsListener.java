package com.example.studentsaccounting;

import com.example.studentsaccounting.events.StudentCreateEvent;
import com.example.studentsaccounting.events.StudentDeleteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@Slf4j
public class ShellEventsListener {

    @EventListener(StudentCreateEvent.class)
    private void studentCreateHandler(StudentCreateEvent event){
        log.info("Student created: " + event.getStudentInfo());
    }

    @EventListener(StudentDeleteEvent.class)
    private void studentDeleteHandler(StudentDeleteEvent event) {
        log.info(MessageFormat.format("Student with id {0} deleted", event.getId()));
    }
}
