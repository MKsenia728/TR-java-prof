package hw221207;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CollectionsManager collectionsManager = new CollectionsManager();
        collectionsManager.addLibraryToList(new Library("Толстой","Война и мир"));
        collectionsManager.addLibraryToList(new Library("Грибоедов","Горе от ума"));
        collectionsManager.addLibraryToList(new Library("Пушкин","Евгений Онегин"));
        collectionsManager.addLibraryToList(new Library("Франко","Украденное счастье"));
        collectionsManager.addLibraryToList(new Library("Шевченко","Назар Стодоля"));
        collectionsManager.addLibraryToList(new Library("Булгаков","Мастер и Маргарита"));
        collectionsManager.addLibraryToList(new Library("Дюма","Три мушкетера"));
        collectionsManager.addLibraryToList(new Library("Гоголь","Мертвые души"));
        collectionsManager.addLibraryToList(new Library("Гюго","Собор Парижской Богоматери"));
        collectionsManager.addLibraryToList(new Library("Рид","Всадник без головы"));

        collectionsManager.addLiteratureToList(new Literature(1867, "Андрей Болконский"));
        collectionsManager.addLiteratureToList(new Literature(1824, "Чацкий"));
        collectionsManager.addLiteratureToList(new Literature(1831, "Татьяна Ларина"));
        collectionsManager.addLiteratureToList(new Literature(1894, "Николай Задорожный"));
        collectionsManager.addLiteratureToList(new Literature(1843, "Наталка"));
        collectionsManager.addLiteratureToList(new Literature(1966, "Воланд"));
        collectionsManager.addLiteratureToList(new Literature(1844, "д'Артаньян"));
        collectionsManager.addLiteratureToList(new Literature(1843, "Чичиков"));
        collectionsManager.addLiteratureToList(new Literature(1831, "Эсмеральда"));
        collectionsManager.addLiteratureToList(new Literature(1865,"Морис Джеральд"));

        Scanner scanner = new Scanner(System.in);

        collectionsManager.makeMap();
        collectionsManager.printMap();

        System.out.println("Напишите автора : ");
        String writer = scanner.nextLine();
        System.out.println("Напишите произведение, чтобы узнать имя персонажа и год издания: ");
        String literaryWork = scanner.nextLine();
        collectionsManager.printWhoCharacter(new Library(writer,literaryWork){});

        System.out.println("Напишите год издания произведения : ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Напишите имя персонажа : ");
        String character = scanner.nextLine();
        collectionsManager.printWhoWriter(new Literature(year, character));

        System.out.println("Введите персонажа и узнайте, есть ли у нас книга");
        String character1 = scanner.nextLine();
        collectionsManager.printIsCharacter(character1);

        System.out.println("Опишите одним-парой слов этих авторов, например: Мировой классик");
        String str = scanner.nextLine();
        collectionsManager.printReplaceAll(str);
        scanner.close();
    }
}
