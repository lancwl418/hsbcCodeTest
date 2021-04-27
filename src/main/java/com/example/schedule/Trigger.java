package com.example.schedule;

public class Trigger {
    // Trigger interval, in second
    private Integer interval;

    public Trigger(Integer interval) {
        this.interval = interval;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
