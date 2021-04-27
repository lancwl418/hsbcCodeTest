package com.example.ui.state;

import com.example.preprocess.ValueExtractor;
import com.example.processor.InputLineItem;
import com.example.processor.Processor;
import com.example.ui.Monitor;

import java.util.Objects;

public class InputCommandState extends AbstractState {
    private final ValueExtractor valueExtractor;

    protected InputCommandState(Monitor monitor, Processor processor) {
        super(monitor, processor);
        valueExtractor = new ValueExtractor();
    }

    @Override
    public void doAction() {
        String line;
        monitor.printLine("Please input your data, type 'quit' to quit:");
        while (!(line = monitor.getScanner().nextLine()).equalsIgnoreCase("quit")) {
            InputLineItem inputLineItem = valueExtractor.extract(line);
            if (Objects.isNull(inputLineItem)) {
                monitor.printLine("Your input is invalid, and is discarded");
            } else {
                processor.putEntry(inputLineItem.getCurrencyCode(), inputLineItem);
            }
        }
        monitor.setState(new TerminationState(monitor, processor));
    }
}
