/*    Пусть дан список сотрудников:
    Иван Иванов
    Светлана Петрова
    Кристина Белова
    Анна Мусина
    Анна Крутова
    Иван Юрин
    Петр Лыков
    Павел Чернов
    Петр Чернышов
    Мария Федорова
    Марина Светлова
    Мария Савина
    Мария Рыкова
    Марина Лугова
    Анна Владимирова
    Иван Мечников
    Петр Петин
    Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени. */
import java.util.*;
public class task2 {
    public static void main(String[] args) {
        List<String> employeeList = Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        );

        Map<String, Integer> nameCountMap = new HashMap<>();

        // Подсчет количества повторений имен
        for (String employee : employeeList) {
            String firstName = employee.split(" ")[0]; // Получаем имя сотрудника
            nameCountMap.put(firstName, nameCountMap.getOrDefault(firstName, 0) + 1);
        }

        // Сортировка по убыванию популярности имени
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCountMap.entrySet());
        sortedNames.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        
        
        // Вывод повторяющихся имен с количеством повторений
        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }