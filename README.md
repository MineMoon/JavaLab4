# Лабораторная работа Java №4: Функциональное программирование и обобщенные типы

Данный проект представляет собой решение лабораторной работы №4 Java, вариант 6.

## Содержание
1. [Содержание](#содержание)
2. [Структура проекта](#структура-проекта)
3. [Пакет mcomrapable](#пакет-mcomrapable)
    - [Интерфейс Mcomparable](#интерфейс-mcomparable)
4. [Пакет house](#пакет-house)
    - [Класс House](#класс-house)
5. [Пакет datastructures](#пакет-datastructures)
    - [Класс ImmutableListofValues](#класс-immutablelistofvalues)
6. [Пакет mfiller](#пакет-mfiller)
    - [Класс Mfiller](#класс-mfiller)
7. [Пакет pairfiller](#пакет-pairfiller)
    - [Класс Pairfiller](#класс-pairfiller)
8. [Пакет mconverter](#пакет-mconverter)
    - [Класс Mconverter](#класс-mconverter)
9. [Пакет mfilter](#пакет-mfilter)
    - [Класс Mfilter](#класс-mfilter)
10. [Пакет contraction](#пакет-contraction)
    - [Класс Contraction](#класс-contraction)
11. [Пакет mcollect](#пакет-mcollect)
    - [Класс MCollector](#класс-mcollector)
12. [Пакет Mpair](#пакет-mpair)
    - [Класс Pair](#класс-pair)
13. [Пакет main](#пакет-main)
    - [Класс Main](#класс-main)
14. [Пакет userinput](#пакет-userinput)
    - [Класс UserInput](#класс-userinput)
    - [Класс Check](#класс-check)

## Структура проекта

Проект состоит из следующих пакетов и классов:

- **mcomrapable**
    - Mcomparable
- **house**
    - House
- **datastructures**
    - ImmutableListofValues
- **mfiller2**
    - Mfiller
- **pairfiller**
    - Pairfiller
- **mconverter**
    - Mconverter
- **mfilter**
    - Mfilter
- **contraction**
    - Contraction
- **mcollect**
    - MCollector
- **Mpair**
    - Pair
- **main**
    - Main

## Пакет mcomrapable

### Интерфейс Mcomparable

#### Назначение
Обобщенный интерфейс для сравнения объектов, гарантирующий наличие метода `compareTo`.

```java
public interface Mcomparable<T> {
    int compareTo(T obj);
}
```

#### Особенности реализации:
- **Обобщенный тип** `T` - позволяет сравнивать объекты любого типа
- **Единственный метод** `compareTo` - возвращает целое число: отрицательное если меньше, положительное если больше, 0 если равны

## Пакет house

### Класс House

#### Назначение
Класс, представляющий дом с количеством этажей. Реализует интерфейс `Mcomparable<House>`.

```java
public class House implements Mcomparable<House> {
    private final int floor;
    // конструкторы и методы
}
```
Реализация compareTo в классе House
```java
@Override
public int compareTo(House other) {
return Integer.compare(this.floor, other.floor);
}
```

#### Особенности реализации:
- **Поле `floor`** объявлено как `final` - нельзя изменить после создания
- **Реализация `compareTo`** - сравнение происходит по количеству этажей
- **Валидация в конструкторе** - этажи должны быть в диапазоне 0-164
- **Автоматическое определение окончания** для слова "этаж"

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/House1.png)

## Пакет datastructures

### Класс ImmutableListofValues

#### Назначение
Обобщенный класс, представляющий неизменяемый массив значений.

```java
public class ImmutableListofValues<T> {
    private final T[] array;
    // конструкторы и методы
}
```

#### Особенности реализации:
- **Обобщенный тип** `T` - может хранить значения любого типа
- **Безопасность** - методы `get()` и `set()` возвращают копию объекта
- **Неизменяемость** - при изменении возвращается новый объект
- **Копирование** - конструктор копирования создает глубокую копию массива

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Arrays1.png)
![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Arrays2.png)

## Пакет mfiller

### Класс Mfiller

#### Назначение
Метод для заполнения списка значениями от 1 до 100 с использованием функции преобразования.

```java
 public static <T extends Number> void oneHungredFiller(
        List<T> list,
        IntFunction<T> Converter ) {

    if (Converter == null ) {
        throw new NullPointerException("Converters cannot be null");
    }

    for (int i = 1; i <= 100; i++) {
        list.add(Converter.apply(i));
    }
}
```


#### Особенности реализации:
- **Обобщенный тип с ограничением** `T extends Number` - гарантирует что тип является числом
- **Функциональный интерфейс** `IntFunction<T>` - функциональный интерфейс, который представляет собой функцию,
  принимающую на вход аргумент типа int и возвращающую результат типа T
- **Проверка на null в функциональной ссылке**

#### Примеры использования
Добавить в double список 100 чисел
```java
Mfiller.oneHungredFiller(DoubleList, i -> (double) i);
```
Добавить 100 чисел, помноженные на 2
```java
Mfiller.oneHungredFiller(intList, i -> i * 2);
```

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Mfiller1.png)

## Пакет pairfiller

### Класс Pairfiller

#### Назначение
Метод для заполнения списка парами значений от 1 до 100.

```java
 public static <T extends Number, U extends Number> void oneHungredFiller(
        List<Pair<T, U>> list,
        IntFunction<T> firstConverter,
        IntFunction<U> secondConverter) {

    if (firstConverter == null || secondConverter == null) {
        throw new NullPointerException("Converters cannot be null");
    }

    for (int i = 1; i <= 100; i++) {
        list.add(new Pair<>(firstConverter.apply(i), secondConverter.apply(i)));
    }
}
```

#### Особенности реализации:
- **Два обобщенных типа** `T` и `U` - для первого и второго элемента пары
- **Два преобразователя** - отдельные функции для каждого элемента пары
- **Создание пар** - каждая пара создается из одного исходного числа
- **Проверка на null в функциональных ссылках**

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/pairFiller1.png)

## Пакет mconverter

### Класс Mconverter

#### Назначение
Метод для преобразования каждого элемента списка с помощью заданной функции.

```java
public static <T,P> List<P> function(List<T> list, Function<T, P> func)  {
    List<P> result = new ArrayList<>();
    for (T element : list) {
        result.add(func.apply(element));
    }
    return result;
}
```
Создает новый список, и в него добавляет преобразованные эл-ты исходного списка

#### Примеры использования:
1. **Строки в длины**
```java
    List<Integer> lengths = Mconverter.function(strings, s -> s.length());
```
2. **Модули чисел**
```java
   List<Integer> absoluteValues = Mconverter.function(numbers, n -> Math.abs(n));
```
3. **Максимумы массивов** - нахождение максимального элемента в каждом массиве
```java
  List<Integer> maxValues = Mconverter.function(arrays, arr -> {
    int max = arr[0];
    for (int num : arr) {
        if (num > max) max = num;
    }
    return max;
});
```
Тут уже в ламбла функции можем написать логику вычисления максимума.

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Mconverter1.png)

## Пакет mfilter

### Класс Mfilter

#### Назначение
Метод для фильтрации элементов списка по заданному условию.

```java
public static <T> List<T> filter(List<T> list, Predicate<T> pred) {
    List<T> result = new ArrayList<>();
    for (T t : list) {
        if (pred.test(t)) {
            result.add(t);
        }
    }
    return result;
}
```
Predicate — функциональный интерфейс для проверки соблюдения некоторого условия. 
Если условие соблюдается, возвращает true, иначе — false.
С помощью этого и производится фильтрация.
#### Примеры использования:
1. **Строки длиной ≥ 3** 
```java
    List<String> filteredStrings = Mfilter.filter(strings, s -> s.length() >= 3);
```
2. **Отрицательные числа** 
```java
    List<Integer> filteredNumbers = Mfilter.filter(numbers, n -> n <= 0);
```
3. **Массивы без положительных элементов** - проверка что все элементы ≤ 0
```java
   List<int[]> filteredArrays = Mfilter.filter(arrays, arr -> {
    for (int num : arr) {
        if (num > 0) {
            return false;
        }
    }
    return true;
});
```
![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Mfilter2.png)
![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Mfilter1.png)

## Пакет contraction

### Класс Contraction

#### Назначение
Метод для свертки (редукции) списка в одно значение с помощью бинарного оператора.

```java
public static <T> T contraction(List<T> list, BinaryOperator<T> contrn) {
    if (list == null || list.isEmpty()) {
        throw new IllegalArgumentException("Cannot contraction empty list without elements");
    }
    T result = list.get(0);
    for (int i = 1; i < list.size(); i++) {
        result = contrn.apply(result, list.get(i));
    }
    return result;

}
```

BinaryOperator - функциональный интерфейс, который принимает два операнда одного типа T
и возвращает результат того же типа T.
#### Примеры использования:
1. **Конкатенация строк** 
```java
String concatenated = Contraction.contraction(strings, (s1, s2) -> s1 + s2);
```

2. **Сумма чисел** 
```java
 Integer sum = Contraction.contraction(numbers, (a, b) -> a + b);
```

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/Contraction.png)

#### Особенности:
- **Исключение для пустого списка** - гарантирует осмысленный результат
- **Последовательное применение** - оператор применяется к элементам слева направо

## Пакет mcollect

### Класс MCollector

#### Назначение
Универсальный метод для коллекционирования элементов в произвольную структуру данных.

```java
 public static <T, P> P collect(List<T> list,
        Supplier<P> collectionFactory,
        BiConsumer<P, T> accumulator) {

    P result = collectionFactory.get();
    for (T element : list) {
        accumulator.accept(result, element);
    }
    return result;
}
```

#### Функциональные интерфейсы:
- **`Supplier<P>`** - предоставляет значение типа P, 
не принимая при этом никаких аргументов
- **`BiConsumer<P, T>`** -  принимает два аргумента разных типов P и T и выполняет 
- какое-то действие, не возвращая никакого результата.

#### Примеры использования:
1. **Разбиение чисел** - на положительные и отрицательные
```java
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
```
2. **Группировка строк** - по длине строки
```java
List<List<String>> groupedByLength = MCollector.collect(stringsForGrouping, ArrayList::new,
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
```
3. **Уникальные элементы** - создание списка без дубликатов
```java
List<String> uniqueStrings = MCollector.collect(stringsForSet, ArrayList::new,
        (list, str) -> {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
);
```

![Image](https://github.com/MineMoon/JavaLab4/blob/main/PNGFR/MCollector.png)

## Пакет Mpair

### Класс Pair

#### Назначение
Обобщенный класс для хранения пары значений.

```java
public class Pair<T, U> {
    private final T first;
    private final U second;
    // конструкторы и методы
}
```

#### Особенности реализации:
- **Два обобщенных типа** - независимые типы для первого и второго элемента
- **Неизменяемость** - поля объявлены как `final`
- **Переопределенные методы** - `equals()`, `hashCode()`, `toString()`

## Пакет main

### Класс Main

#### Назначение
Точка входа в программу, демонстрирующая работу всех реализованных методов.

#### Структура меню:
- **Comparable** - тестирование сравнения домов
- **Array** - работа с обобщенными массивами
- **Filler** - заполнение списков числами
- **Converter** - преобразование элементов списка
- **Filter** - фильтрация элементов по условию
- **Contraction** - свертка списка в одно значение
- **Collect** - коллекционирование в различные структуры
- **Pairs filler** - заполнение списков парами

## Пакет userinput
### Класс UserInput
Обеспечивает безопасный ввод данных с консоли:
- `inputInt()`, `inputPositiveInt()` - ввод чисел
- `inputDiaposonInt()` - ввод числа в диапазоне
- `inputChoiceInt()` - ввод выбора из меню
- `inputString()` - ввод строки


### Класс Check
Содержит методы валидации:
- `isInteger(String str)` - проверка целого числа
- `Positive(int num)` - проверка неотрицательности
