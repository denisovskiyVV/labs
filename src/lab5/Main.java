package lab5;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание пустой очереди с помощью класса LinkedList
        Queue<String> queue = new LinkedList<>();
        // Создание объекта Scanner для чтения ввода пользователя с консоли
        Scanner scanner = new Scanner(System.in);
        // Бесконечный цикл для запроса действия у пользователя и выполнения соответствующих операций
        while (true) {
            // Вывод на экран меню выбора действия
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить элемент");
            System.out.println("2 - Удалить элемент");
            System.out.println("3 - Вывести текущий список элементов");
            // Чтение выбора пользователя
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера ввода
            switch (choice) {
                // Добавление элемента в очередь
                case 1:
                    System.out.print("Введите элемент: ");
                    String element = scanner.nextLine(); // Чтение введенного элемента
                    queue.add(element); // Добавление элемента в конец очереди
                    System.out.println("Элемент добавлен");
                    break;
                // Удаление элемента из очереди
                case 2:
                    if (queue.isEmpty()) { // Проверка, что очередь не пуста
                        System.out.println("Очередь пуста");
                    } else {
                        String removedElement = queue.remove(); // Удаление первого элемента из очереди
                        System.out.println("Удален элемент: " + removedElement);
                    }
                    break;
                // Вывод текущего списка элементов
                case 3:
                    System.out.println("Текущий список элементов: " + queue);
                    break;
                // Обработка неверного выбора
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}