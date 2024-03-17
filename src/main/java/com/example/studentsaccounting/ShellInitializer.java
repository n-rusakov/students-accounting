package com.example.studentsaccounting;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "students-accounting",
        value = "auto-create-enabled", havingValue = "true")
public class ShellInitializer {
    private final StudentsAccountingShell shell;

    @EventListener(ApplicationStartedEvent.class)
    public void appStart() {
        shell.init();
    }
}
