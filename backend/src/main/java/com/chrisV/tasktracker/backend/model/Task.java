package com.chrisV.tasktracker.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate dueDate;
    private String title;
    private Boolean completed;

    @Enumerated(EnumType.STRING) //store/convert to "HIGH", "MEDIUM" in DB
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    public Task() {}

    public Task(String tile, boolean completed, Priority priority, String description) {
        this.title = tile;
        this.completed = completed;
        this.priority = priority;
        this.description = description;
    }
    
    //getters
    public String getDescription() {return description;}
    public LocalDate getDueDate() {return dueDate;}
    public Priority getPriority() {return priority;}
    public Long getId() {return id;}
    public String getTiltle() {return title;}
    public Boolean isCompleted() {return completed;}
    public Project getProject() {return project;}

    //setters
    public void setDescription(String description) {this.description = description;}
    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}
    public void setPriority(Priority priority) {this.priority = priority;}
    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setCompleted(Boolean completed) {this.completed = completed;}
    public void setProject(Project project) {this.project = project;}
}
