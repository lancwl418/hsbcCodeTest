package com.example.ui.state;

import com.example.processor.Processor;
import com.example.ui.Monitor;

public class TerminationState extends AbstractState {
    public TerminationState(Monitor monitor, Processor processor) {
        super(monitor, processor);
    }

    @Override
    public void doAction() {
        monitor.printLine("This program is now exiting");
    }
}
