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
            System.out.println("1 - ✏\uFE0F Створити запис");
            System.out.println("2 - ☠\uFE0F Видалити запис");
            System.out.println("3 - \uD83D\uDCC1 Зчитати всі записи");
            System.out.println("4 - \uD83D\uDD04 Оновити запис");
            System.out.println("5 - \uD83D\uDD0D Пошук запису");
            System.out.println("6 - \uD83D\uDDC3\uFE0F Сортування записів за назвою");
            System.out.println("7 - \uD83D\uDDC3\uFE0F Сортування записів за ідентифікатором");
            System.out.println("0 - \uD83D\uDD0D Вихід");

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
                case 7 -> service.sortById();
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