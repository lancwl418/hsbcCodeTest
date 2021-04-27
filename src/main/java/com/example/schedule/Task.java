package com.example.schedule;

import com.example.processor.InputLineItem;
import com.example.processor.OutputLineItem;
import com.example.processor.Processor;
import com.example.ui.Monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task {
    private final Processor processor;
    private final Monitor monitor;

    public Task(Processor processor, Monitor monitor) {
        this.processor = processor;
        this.monitor = monitor;
    }

    public void execute() {
        Map<String, InputLineItem> snapshot = processor.getAllRecords();
        List<OutputLineItem> outputLineItems = new ArrayList<>();
        for (InputLineItem item : snapshot.values()) {
            if (item.getAmount() != 0) {
                outputLineItems.add(new OutputLineItem(item));
            }
        }
        for (OutputLineItem outputLineItem : outputLineItems) {
            monitor.printLine(outputLineItem.toString());
        }
    }
}
