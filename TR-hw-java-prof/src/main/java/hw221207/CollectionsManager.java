package hw221207;

import java.util.*;

public class CollectionsManager {
    private static final List<Library> libraryList = new ArrayList<>();
    private static final List<Literature> literatureList = new ArrayList<>();
    private static final Map<Literature, Library> map = new HashMap<>(); /* герой - писатель */

    public void addLibraryToList(Library library) {
        libraryList.add(library);
    }

    public void addLiteratureToList(Literature literature) {
        literatureList.add(literature);
    }

    public void makeMap() {
        Iterator<Library> libraryIterator = libraryList.listIterator();
        Iterator<Literature> literatureIterator = literatureList.listIterator();
        if (literatureList.size() == libraryList.size())
            while (libraryIterator.hasNext()) {
                map.put(literatureIterator.next(), libraryIterator.next());
            }
        else System.out.println("Некорректные входные данные");
    }

    public void printMap() {
        for (Map.Entry<Literature, Library> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + entry.getValue().toString());
        }
    }

    public void printWhoCharacter(Library library) {
        boolean isPresent = false;
        for (Map.Entry<Literature, Library> entry : map.entrySet()) {
            if (library.compareTo(entry.getValue()) == 0) {
                isPresent = true;
                System.out.println(library + " был написан/издан в " + entry.getKey().getYearOfCreate() + ", главный герой " + entry.getKey().getMainCharacter());
                break;
            }
        }
        if (!isPresent) System.out.println("Нет информации");
    }

    public void printWhoWriter(Literature literature) {
        for (Map.Entry<Literature, Library> entry : map.entrySet()) {
            if (literature.compareTo(entry.getKey()) == 0) literature = entry.getKey();
        }
        if (map.containsKey(literature)) {
            System.out.println(literature.getMainCharacter() + " был придуман писателем " + map.get(literature).getWriter() + " в произведении " + map.get(literature).getLiteraryWork());
        } else System.out.println("У нас нет информации об этом авторе");
    }

    public void printIsCharacter(String character) {
        boolean isPresent = false;
        for (Map.Entry<Literature, Library> entry : map.entrySet()) {
            if (entry.getKey().getMainCharacter().equals(character)) {
                isPresent = true;
                break;
            }
        }
        if (isPresent) System.out.println("В библиотеке есть книга с главным героем " + character);
        else System.out.println("у нас нет книги с главным героем " + character);
    }

    public void printReplaceAll(String str) {
        map.replaceAll((k, v) -> addString(v, str));
        printMap();
    }

    private Library addString(Library library, String str) {
        library.setWriter(library.getWriter().concat("-").concat(str));
        return library;
    }
}
