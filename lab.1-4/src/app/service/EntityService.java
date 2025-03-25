package app.service;

import app.model.Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EntityService {
    private final List<Entity> entities = new ArrayList<>();

    public void create(String name) {
        Entity entity = new Entity(name);
        entities.add(entity);
        System.out.println("✅ Запис створено: " + entity);
    }

    public void delete(int id) {
        entities.removeIf(entity -> entity.getId() == id);
        System.out.println("❌ Запис з ID " + id + " видалено.");
    }

    public void readAll() {
        if (entities.isEmpty()) {
            System.out.println("ℹ️ Немає записів.");
        } else {
            entities.forEach(System.out::println);
        }
    }

    public void update(int id, String newName) {
        Optional<Entity> entityOpt = entities.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        entityOpt.ifPresent(entity -> {
            entity.setName(newName);
            System.out.println("✏️ Запис оновлено: " + entity);
        });
    }

    public void search(String name) {
        entities.stream()
                .filter(e -> e.getName().contains(name))
                .forEach(System.out::println);
    }

    public void sortByName() {
        entities.sort(Comparator.comparing(Entity::getName));
        System.out.println("📂 Записи відсортовано за назвою.");
        readAll();
    }
}