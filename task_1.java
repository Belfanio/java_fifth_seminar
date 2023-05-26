/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
Пример:
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 1242353
К: Введите 1) Добавление номера
2) Вывод всего
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 547568
К: Введите 1) Добавление номера
2) Вывод всего
Я: 2
Иванов: 1242353, 547568
 */
package Lesson5;

import java.util.*;

public class task1 { //
    public class ConsoleColors {
        // Цвета текста
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    
        // Цвета фона
        public static final String BLACK_BACKGROUND = "\u001B[40m";
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String GREEN_BACKGROUND = "\u001B[42m";
        public static final String YELLOW_BACKGROUND = "\u001B[43m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String MAGENTA_BACKGROUND = "\u001B[45m";
        public static final String CYAN_BACKGROUND = "\u001B[46m";
        public static final String WHITE_BACKGROUND = "\u001B[47m";
    }
    public class PhoneBook {
        public static void main(String[] args) {
            HashMap<String, List<String>> phoneBook = new HashMap<>();
            // --------------- Начало рабочего кода ----------------------
            System.out.println(ConsoleColors.BLUE + "Телефонная книга\n" + ConsoleColors.RESET);
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Выберите:\n1) Добавление нового абонента или добавление номера имеющегося.\n2) Вывод телефонной книги. \nQ выход.");
                    System.out.print(ConsoleColors.YELLOW);
                    String choice = scanner.nextLine();
                    System.out.print(ConsoleColors.BLUE);
                    if (choice.equalsIgnoreCase("1")) {
                        System.out.println(ConsoleColors.BLUE + "Введите фамилию:" + ConsoleColors.YELLOW);
                        String lastName = scanner.nextLine();
                        System.out.println(ConsoleColors.BLUE + "Введите номер:" + ConsoleColors.YELLOW);
                        String phoneNumber = scanner.nextLine();
                        System.out.println(ConsoleColors.RESET);
                        if (phoneBook.containsKey(lastName)) {
                            List<String> numbers = phoneBook.get(lastName);
                            numbers.add(phoneNumber);
                        } else {
                            List<String> numbers = new ArrayList<>();
                            numbers.add(phoneNumber);
                            phoneBook.put(lastName, numbers);
                        }
                        System.out.println(ConsoleColors.BLUE + "Запись добавлена.\n" + ConsoleColors.RESET);
                    } else if (choice.equalsIgnoreCase("2")) {
                        //В коде ниже предполагается, что фамилии уникальны и что один и тот же номер телефона не может 
                        //быть добавлен дважды для одной фамилии. Если нужно обрабатывать дублирующиеся номера или разные 
                        //имена с одинаковыми номерами, придётся изменить логику, вводить поле ID записи.
                        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                            String lastName = entry.getKey();
                            List<String> numbers = entry.getValue();
                            System.out.print(lastName + ": ");
                            for (String phoneNumber : numbers) {
                                System.out.print(phoneNumber + ", ");
                            }
                            System.out.println("\n" + ConsoleColors.RESET);
                        }
   
                    } else if (choice.equalsIgnoreCase("Q") || choice.equalsIgnoreCase("Й")) {
                        break;
                    } else {
                        System.out.println(ConsoleColors.RED + "Некорректный выбор. Попробуйте снова." + ConsoleColors.RESET);
                    }
                }
            }
    
            System.out.println(ConsoleColors.BLUE + "Программа завершена." + ConsoleColors.RESET);
        }
    }