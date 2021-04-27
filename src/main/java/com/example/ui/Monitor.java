package com.example.ui;

import com.example.processor.Processor;
import com.example.schedule.Scheduler;
import com.example.schedule.Task;
import com.example.schedule.Trigger;
import com.example.ui.state.InitialState;
import com.example.ui.state.State;
import com.example.ui.state.TerminationState;

import java.util.Scanner;

public class Monitor {
    private final Scanner scanner;
    private final Processor processor;
    private final Scheduler scheduler = Scheduler.getInstance();
    private State state;

    public Monitor(Scanner scanner, Processor processor) {
        this.scanner = scanner;
        this.processor = processor;
    }

    public void run() {
        this.state = new InitialState(this, processor);
        scheduler.schedule(new Task(processor, this), new Trigger(60));
        scheduler.start();
        while (notTerminated()) {
            state.doAction();
        }
        state.doAction();
        scheduler.stop();
    }

    private boolean notTerminated() {
        return !(state instanceof TerminationState);
    }

    public void setState(State state) {
        this.state = state;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void printLine(String message) {
        System.out.println(message);
    }
}
