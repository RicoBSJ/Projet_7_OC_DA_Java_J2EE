package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="task_id_generator", sequenceName = "task_id_seq", allocationSize=1)
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "task_id_generator")
    @Column(name = "id_task")
    private Integer taskId;
    @Column(name = "task_name")
    private String taskName;

    public Task() {
    }

    public Task(Integer taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
