package app.model;

import java.time.LocalDateTime;

public class Entity {
    private static int counter = 0;
    private final int id;
    private String name;
    private LocalDateTime createdAt;

    public Entity(String name) {
        this.id = ++counter;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "ID: " + id + ", Назва: " + name + ", Створено: " + createdAt;
    }
}