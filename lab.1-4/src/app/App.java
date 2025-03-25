package app;

import app.service.EntityService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityService service = new EntityService();
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1 - Створити запис");
            System.out.println("2 - Видалити запис");
            System.out.println("3 - Зчитати всі записи");
            System.out.println("4 - Оновити запис");
            System.out.println("5 - Пошук запису");
            System.out.println("6 - Сортування записів");
            System.out.println("0 - Вихід");

            System.out.print("Виберіть дію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть назву: ");
                    String name = scanner.nextLine();
                    service.create(name);
                }
                case 2 -> {
                    System.out.print("Введіть ID запису для видалення: ");
                    int id = scanner.nextInt();
                    service.delete(id);
                }
                case 3 -> service.readAll();
                case 4 -> {
                    System.out.print("Введіть ID запису: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть нову назву: ");
                    String newName = scanner.nextLine();
                    service.update(id, newName);
                }
                case 5 -> {
                    System.out.print("Введіть текст для пошуку: ");
                    String search = scanner.nextLine();
                    service.search(search);
                }
                case 6 -> service.sortByName();
                case 0 -> {
                    System.out.println("Додаток завершено.");
                    running = false;
                }
                default -> System.out.println("❌ Невірний вибір.");
            }
        }
        scanner.close();
    }
}