package hw221219StreamSimple;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10};
        int[] arr1 = {1,2,3,4,5};
        computeWithStream(arr);
    }

    public static void computeWithStream(int[] arr) {
        Arrays.stream(arr)
                .map(el -> (el % 2 == 0) ? el * 3 : el * 5)
                .filter(el -> el > 25)
                .reduce((el1, el2) -> el1 + el2)
                .ifPresentOrElse(el -> System.out.println("Сумма значений после заданной обработки " + el),
                        () -> System.out.println("Под условия обработки значения не попали, сумма 0"));

    }
}
