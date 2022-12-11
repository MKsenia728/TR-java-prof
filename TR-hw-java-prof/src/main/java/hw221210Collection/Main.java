package hw221210Collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        задание 1-2
        List<String> list = new ArrayList<>();
        list.add("Массив — это упорядоченное множество элементов одного типа, примитивного или ссылочного.");
        list.add("Массив — это упорядоченное множество элементов одного типа");
        list.add("упорядоченное множество элементов одного типа, примитивного или ссылочного.");
        list.add("Массив — это множество элементов одного типа, примитивного или ссылочного.");
        list.add("Массив — это упорядоченное множество элементов типа, примитивного или ссылочного.");
        list.add("Массив — это упорядоченное , примитивного или ссылочного.");
        list.add("Массив — это упорядоченное множество.");
        list.add("Массив — это упорядоченное множество элементов одного типа, примитивного или ссылочного.");
        System.out.println("Список строк без дубликатов");
        for (String s : stringSet(list)) {
            System.out.println(s);
        }
        System.out.println("Количество повторений слов ");
        Map<String, Integer> map = makeListNumberOfDuplicates(list);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("В данном тексте " + entry.getValue() + " слов \"" + entry.getKey() + "\"");
        }

//        задание 3
        Dictionary dictionary = new Dictionary();
        dictionary.add("take", "брать");
        dictionary.add("take", "принимать");
        dictionary.add("take", "считать");
        dictionary.add("use", "использовать");
        dictionary.add("use", "применять");
        dictionary.add("use", "употреблять");
        dictionary.add("do", "делать");
        dictionary.add("do", "выполнять");
        dictionary.add("do", "заниматься");
        dictionary.add("do", "поступать");

        dictionary.printMap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово, которое желаете перевести : ");
        String str = scanner.nextLine();
        dictionary.printSet(dictionary.get(str));
        System.out.println("Удаление слова, введите перевод какого слова хотите удалить:");
        String str1 = scanner.nextLine();
        System.out.println("Введите удаляемый перевод:");
        String str2 = scanner.nextLine();
        dictionary.remove(str1, str2);
        dictionary.printMap();
    }

    public static Set<String> stringSet(List<String> list) {
        return new HashSet<>(list);
    }

    public static Map<String, Integer> makeListNumberOfDuplicates(List<String> list) {
        Map<String, Integer> duplicatesMap = new HashMap<>();
        for (String str : list) {
            String[] strings = str.split("[^a-zA-Zа-яА-Я]+");
            for (String word : strings) {
                duplicatesMap.computeIfPresent(word, (k, value) -> value + 1);
                duplicatesMap.putIfAbsent(word, 1);
            }
        }
        return duplicatesMap;
    }
}
