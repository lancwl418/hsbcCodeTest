package com.example.ui.state;

import com.example.preprocess.ValueExtractor;
import com.example.processor.InputLineItem;
import com.example.processor.Processor;
import com.example.ui.Monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

public class InputFileState extends AbstractState {
    private String errorMsg;

    protected InputFileState(Monitor monitor, Processor processor) {
        super(monitor, processor);
    }

    @Override
    public void doAction() {
        String input;
        if ((input = monitor.getScanner().nextLine()).equalsIgnoreCase("no"))
            monitor.setState(new InputCommandState(monitor, processor));
        else {
            if (readFileInput(input)) {
                monitor.setState(new InputCommandState(monitor, processor));
            } else {
                Optional.ofNullable(errorMsg).ifPresent((msg) -> monitor.printLine(msg));
                monitor.setState(new TerminationState(monitor, processor));
            }
        }
    }

    private boolean readFileInput(String pathStr) {
        ValueExtractor extractor = new ValueExtractor();
        Path path = Paths.get(pathStr);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            InputLineItem extractedVal;
            while ((line = reader.readLine()) != null) {
                if (Objects.isNull(extractedVal = extractor.extract(line))) {
                    errorMsg = "Invalid data found in the file, program will terminate now";
                    return false;
                }
                processor.putEntry(extractedVal.getCurrencyCode(), extractedVal);
            }
        } catch (IOException e) {
            errorMsg = "Cannot read from file, please check file existence or user permission";
            return false;
        }
        return true;
    }
}
