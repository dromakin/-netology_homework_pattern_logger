package org.dromakin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        try {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.print("Введите размер списка: ");
            int N = Integer.parseInt(scanner.nextLine());

            if (N < 0) {
                throw new Exception("Размер списка должен > 0!");
            }

            System.out.print("Введите верхнюю границу для значений: ");
            int M = Integer.parseInt(scanner.nextLine());

            if (M < 0) {
                throw new Exception("Верхняя граница списка должна > 0!");
            }

            logger.log("Создаём и наполняем список");
            Random random = new Random();

            for (int i = 0; i < N; i++) {
                list.add(random.nextInt(M));
            }

            System.out.println("Вот случайный список: " + list);

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int F = Integer.parseInt(scanner.nextLine());

            if (F < 0 || F > M) {
                throw new IllegalArgumentException("0 < F < Верхней границы!");
            }

            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(F);
            list = filter.filterOut(list);
            logger.log("Прошло фильтр " + filter.getCount() + " элемента из " + N);

            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + list.toString());

            logger.log("Завершаем программу");

        } catch (Exception e) {
            logger.log("Ошибка: " + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}