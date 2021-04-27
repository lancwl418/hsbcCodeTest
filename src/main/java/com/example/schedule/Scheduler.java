package com.example.schedule;

import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private Task task;
    private Trigger trigger;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    private static final Scheduler scheduler = new Scheduler();

    private Scheduler() {
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(16);
    }

    public static Scheduler getInstance() {
        return scheduler;
    }

    public void schedule(Task task, Trigger trigger) {
        Objects.requireNonNull(task);
        Objects.requireNonNull(trigger);
        this.task = task;
        this.trigger = trigger;
    }

    public void start() {
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> task.execute(), 0, trigger.getInterval(), TimeUnit.SECONDS);
    }

    public void stop() {
        scheduledThreadPoolExecutor.shutdown();
    }
}
