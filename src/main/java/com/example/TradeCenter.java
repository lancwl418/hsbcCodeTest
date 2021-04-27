package com.example;

import com.example.processor.Processor;
import com.example.ui.Monitor;

import java.util.Scanner;

public class TradeCenter {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(new Scanner(System.in), new Processor());
        monitor.run();
    }
}
