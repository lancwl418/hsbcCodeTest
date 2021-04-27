package com.example.ui.state;

import com.example.processor.Processor;
import com.example.ui.Monitor;

abstract class AbstractState implements State {
    protected Monitor monitor;
    protected Processor processor;

    protected AbstractState(Monitor monitor, Processor processor) {
        this.monitor = monitor;
        this.processor = processor;
    }
}
