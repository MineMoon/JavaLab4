package ru.mastiko.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ru.mastiko.Mpair.Pair;
import ru.mastiko.contraction.Contraction;
import ru.mastiko.house.House;
import ru.mastiko.mconverter.Mconverter;
import ru.mastiko.mfiller.Mfiller;
import ru.mastiko.mfilter.Mfilter;
import ru.mastiko.userinput.*;
import ru.mastiko.pairfiller.Pairfiller;
import ru.mastiko.datastructures.ImmutableListofValues;
import ru.mastiko.mcollect.MCollector;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserInput input = new UserInput();

        int choice = 2;
        int choiceTask = 0;
        int argument = 0;
        boolean exit = false;
        List<String> strings = new ArrayList<>();
        strings.add("qwerty");
        strings.add("asdfg");
        strings.add("zx");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-3);
        numbers.add(7);

        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{1, 5, 3});
        arrays.add(new int[]{-2, 0, 8, -5});
        arrays.add(new int[]{10});

        do{

            if(choice == 2){
                choiceTask = input.inputChoiceInt(1,8, "тему\n" +
                                                                        "1. Comparable\n" +
                                                                        "2. Array\n" +
                                                                        "3. Filler\n" +
                                                                        "4. Converter\n" +
                                                                        "5. Filter\n" +
                                                                        "5. Contraction\n" +
                                                                        "7. Collect\n" +
                                                                        "8. Pairs filler\n"
                        );
            }

            switch (choiceTask) {

                case 1:
                    System.out.println("=== Тестирование класса House ===");

                    System.out.println("\n1. Создание домов:");
                    House house1 = new House(5);
                    House house2 = new House(10);
                    House house3 = new House(1);
                    House house4 = new House(5);

                    System.out.println("house1: " + house1.toString());
                    System.out.println("house2: " + house2.toString());
                    System.out.println("house3: " + house3.toString());
                    System.out.println("house4: " + house4.toString());

                    System.out.println("\n2. Сравнение домов:");
                    System.out.println("(house1 < house2)" + house1.compareTo(house2));
                    System.out.println("(house2 > house1)" + house2.compareTo(house1));
                    System.out.println("(house1 == house4)" + house1.compareTo(house4));
                    System.out.println("(house1 > house3)" + house1.compareTo(house3));

                    break;

                case 2:
                    ImmutableListofValues<Integer> intArr = new ImmutableListofValues<Integer>(1,2,3);
                    ImmutableListofValues<Double> doubleArr = new ImmutableListofValues<Double>(1.0, 2.3, 3.4);
                    ImmutableListofValues<Float> floatArr = new ImmutableListofValues<Float>(1f, 2f, 3f);
                    ImmutableListofValues<Short> shortArr = new ImmutableListofValues<Short>((short)1,(short)2,(short)3);

                    System.out.println(intArr.toString());
                    System.out.println(doubleArr.toString());
                    System.out.println(floatArr.toString());
                    System.out.println(shortArr.toString());

                    break;

                case 3:

                    List<Integer> intList = new ArrayList<>();
                    Mfiller.oneHungredFiller(intList, i -> i * 2);
                    System.out.println("Тест 1 - целые числа: " + intList.size() + " элементов");
                    System.out.println("Первые 3: " + intList.subList(0, 3));
                    System.out.println("Последние 3: " + intList.subList(97, 100));

                    List<Double> doubleList = new ArrayList<>();
                    Mfiller.oneHungredFiller(doubleList, i -> i * (double) i);
                    System.out.println("\nТест 2 - дробные числа: " + doubleList.size() + " элементов");
                    System.out.println("Первые 3: " + doubleList.subList(0, 3));
                    System.out.println("Последние 3: " + doubleList.subList(97, 100));


                    break;

                case 4:

                    System.out.println("=== Тест 1: Строки в их длины ===");
                    List<Integer> lengths = Mconverter.function(strings, s -> s.length());
                    System.out.println("Вход: " + strings);
                    System.out.println("Выход: " + lengths);
                    System.out.println();

                    System.out.println("=== Тест 2: Отрицательные в положительные ===");

                    List<Integer> absoluteValues = Mconverter.function(numbers, n -> Math.abs(n));
                    System.out.println("Вход: " + numbers);
                    System.out.println("Выход: " + absoluteValues);
                    System.out.println();

                    System.out.println("=== Тест 3: Массивы и максимальные значения ===");

                    List<Integer> maxValues = Mconverter.function(arrays, arr -> {
                        int max = arr[0];
                        for (int num : arr) {
                            if (num > max) max = num;
                        }
                        return max;
                    });

                    System.out.println("Входные массивы: [1,5,3], [-2,0,8,-5], [10]");
                    System.out.println("Максимумы: " + maxValues);
                    System.out.println();

                    break;

                case 5:
                    System.out.println("=== Тест 1: Фильтрация строк с длиной менее 3 символов ===");

                    List<String> filteredStrings = Mfilter.filter(strings, s -> s.length() >= 3);
                    System.out.println("Вход: " + strings);
                    System.out.println("Выход: " + filteredStrings);
                    System.out.println();

                    System.out.println("=== Тест 2: Фильтрация положительных чисел ===");

                    List<Integer> filteredNumbers = Mfilter.filter(numbers, n -> n <= 0);
                    System.out.println("Вход: " + numbers);
                    System.out.println("Выход: " + filteredNumbers);
                    System.out.println();

                    System.out.println("=== Тест 3: Фильтрация массивов без положительных элементов ===");

                    List<int[]> filteredArrays = Mfilter.filter(arrays, arr -> {
                        for (int num : arr) {
                            if (num > 0) {
                                return false;
                            }
                        }
                        return true;
                    });

                    System.out.println("Входные массивы: [1,5,3], [-2,0,-8,-5], [-10], [-1,2]");
                    System.out.print("Отфильтрованные массивы: ");
                    for (int[] arr : filteredArrays) {
                        System.out.print("[");
                        for (int i = 0; i < arr.length; i++) {
                            System.out.print(arr[i]);
                            if (i < arr.length - 1) {
                                System.out.print(",");
                            }
                        }
                        System.out.print("] ");
                    }
                    System.out.println();
                    System.out.println();

                    break;

                case 6:
                    System.out.println("1. Конкатенация строк");

                    String concatenated = Contraction.contraction(strings, (s1, s2) -> s1 + s2);
                    System.out.println("Вход: " + strings);
                    System.out.println("Результат: " + concatenated);
                    System.out.println();

                    System.out.println("2. Сумма чисел");

                    Integer sum = Contraction.contraction(numbers, (a, b) -> a + b);
                    System.out.println("Вход: " + numbers);
                    System.out.println("Сумма: " + sum);
                    System.out.println();

                    System.out.println("3. Общее количество элементов в списках");
                    List<List<Integer>> listOfLists = new ArrayList<>();

                    List<Integer> l1 = new ArrayList<>();
                    l1.add(1);
                    l1.add(2);
                    l1.add(3);

                    List<Integer> l2 = new ArrayList<>();
                    l2.add(4);
                    l2.add(5);

                    List<Integer> l3 = new ArrayList<>();
                    l3.add(6);
                    l3.add(7);
                    l3.add(8);
                    l3.add(9);

                    listOfLists.add(l1);
                    listOfLists.add(l2);
                    listOfLists.add(l3);

                    // Сначала преобразуем каждый список в его длину
                    List<Integer> sizes = new ArrayList<>();
                    for (List<Integer> list : listOfLists) {
                        sizes.add(list.size());
                    }

                    // Затем суммируем все длины
                    Integer totalElements = Contraction.contraction(sizes, (a, b) -> a + b);

                    System.out.println("Списки: " + listOfLists);
                    System.out.println("Размеры каждого списка: " + sizes);
                    System.out.println("Общее количество элементов: " + totalElements);
                    System.out.println();

                    System.out.println("4. Тест с пустым списком");
                    try {
                        List<String> emptyList = new ArrayList<>();
                        String emptyResult = Contraction.contraction(emptyList, (s1, s2) -> s1 + s2);
                        System.out.println("Результат для пустого списка: " + emptyResult);
                    } catch (Exception e) {
                        System.out.println("Ошибка для пустого списка: " + e.getMessage());
                    }
                    System.out.println();
                    break;

                case 7:

                    System.out.println("1. Разбиение чисел на положительные и отрицательные:");
                    List<Integer> numbersForCollect = Arrays.asList(1, -3, 7);

                    List<List<Integer>> partitioned = MCollector.collect(numbersForCollect,
                            () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
                            (lists, number) -> {
                                if (number > 0) {
                                    lists.get(0).add(number); // positive
                                } else {
                                    lists.get(1).add(number); // negative
                                }
                            }
                    );

                    System.out.println("Вход: " + numbersForCollect);
                    System.out.println("Положительные: " + partitioned.get(0));
                    System.out.println("Отрицательные: " + partitioned.get(1));
                    System.out.println();

                    // 2. Группировка строк по длине
                    System.out.println("2. Группировка строк по длине:");
                    List<String> stringsForGrouping = Arrays.asList("qwerty", "asdfg", "zx", "qw");

                    List<List<String>> groupedByLength = MCollector.collect(stringsForGrouping,
                            ArrayList::new,
                            (groups, str) -> {
                                boolean foundGroup = false;
                                for (List<String> group : groups) {
                                    if (!group.isEmpty() && group.get(0).length() == str.length()) {
                                        group.add(str);
                                        foundGroup = true;
                                        break;
                                    }
                                }
                                if (!foundGroup) {
                                    List<String> newGroup = new ArrayList<>();
                                    newGroup.add(str);
                                    groups.add(newGroup);
                                }
                            }
                    );

                    System.out.println("Вход: " + stringsForGrouping);
                    System.out.println("Группировка по длине: " + groupedByLength);
                    System.out.println();

                    // 3. Уникальные строки (List без дубликатов)
                    System.out.println("3. Уникальные строки:");
                    List<String> stringsForSet = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

                    List<String> uniqueStrings = MCollector.collect(stringsForSet,
                            ArrayList::new,
                            (list, str) -> {
                                if (!list.contains(str)) {
                                    list.add(str);
                                }
                            }
                    );

                    System.out.println("Вход: " + stringsForSet);
                    System.out.println("Уникальные строки: " + uniqueStrings);
                    break;
                case 8:

                    List<Pair<Integer, Double>> list1 = new ArrayList<>();
                    Pairfiller.oneHungredFiller(list1, i -> i, i -> i * 1.0);
                    System.out.println("List1 - первые 3: " + list1.subList(0, 3));
                    System.out.println("List1 - последние 3: " + list1.subList(97, 100));

                    List<Pair<Short, Byte>> list2 = new ArrayList<>();
                    Pairfiller.oneHungredFiller(list2, i -> (short) i, i -> (byte)i);
                    System.out.println("List2 - первые 3: " + list2.subList(0, 3));
                    System.out.println("List2 - последние 3: " + list2.subList(97, 100));

                    List<Pair<Float, Long>> list3 = new ArrayList<>();
                    Pairfiller.oneHungredFiller(list3, i -> (float) i, i -> (long) i);
                    System.out.println("List3 - первые 3: " + list3.subList(0, 3));
                    System.out.println("List3 - последние 3: " + list3.subList(97, 100));
                    break;
            }
            System.out.println();

            System.out.println("Повторить?\n1. Да\n2. К выбору задания\n3. Выход");
            choice = input.inputDiaposonInt(1, 3, "вариант");
            if(choice == 3){
                exit = true;
            }
            System.out.println();

        }while (!exit);
    }

}
