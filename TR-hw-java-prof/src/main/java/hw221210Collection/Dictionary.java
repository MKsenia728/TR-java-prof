package hw221210Collection;

import java.util.*;

public class Dictionary {

    Map<String, Set<String>> dictionaryList = new HashMap<>();

    public Set<String> get(String k) {
        if (dictionaryList.containsKey(k)) return dictionaryList.get(k);
        else return new HashSet<>();
    }

    public void add(String word, String translateWord) {
        if (dictionaryList.containsKey(word)) dictionaryList.get(word).add(translateWord);
        else {
            dictionaryList.putIfAbsent(word, new HashSet<>());
            dictionaryList.get(word).add(translateWord);
        }
    }

    public void remove(String str, String strForRemove) {
        if (dictionaryList.containsKey(str)) {
            if (dictionaryList.get(str).contains(strForRemove))
                dictionaryList.get(str).remove(strForRemove);
            else System.out.println("Нет такого слова в переводе");
        } else System.out.println("Нет такого слова в словаре");
    }

    public void printMap() {
        for (Map.Entry<String, Set<String>> entry : dictionaryList.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            printSet(entry.getValue());
        }
    }

    public void printSet(Set<String> set) {
        if (!set.isEmpty()) {
            for (String s : set) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else System.out.println("Список пустой");
    }


}
