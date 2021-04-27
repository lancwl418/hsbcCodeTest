package com.example.ui.state;

import com.example.processor.Processor;
import com.example.ui.Monitor;

public class InitialState extends AbstractState {
    public InitialState(Monitor monitor, Processor processor) {
        super(monitor, processor);
    }

    @Override
    public void doAction() {
        monitor.printLine("Please input the file path, type 'no' to skip:");
        monitor.setState(new InputFileState(monitor, processor));
    }
}
