package me.riguron.bungee.task;

import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.scheduler.TaskScheduler;
import me.riguron.system.task.ExecutionStrategy;
import me.riguron.system.task.SchedulerTask;
import me.riguron.system.task.repeating.RepeatingAction;

@RequiredArgsConstructor
public class BungeeSchedulerTask implements SchedulerTask {

    private final ExecutionStrategy executionStrategy;
    private final TaskScheduler taskScheduler;
    private final RepeatingAction repeatingAction;

    private int bungeeTaskId = -1;

    @Override
    public int getTaskId() {
        return bungeeTaskId;
    }

    @Override
    public void cancel() {
        taskScheduler.cancel(bungeeTaskId);
    }

    @Override
    public void start() {
        this.bungeeTaskId = executionStrategy.execute(() -> repeatingAction.run(this));
    }
}
