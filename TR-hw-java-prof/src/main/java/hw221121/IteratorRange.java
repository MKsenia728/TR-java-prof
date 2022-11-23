package hw221121;

//import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorRange {
    public static void main(String[] args) {

        Integer[] arrInt = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1010, 1111, 1212, 1313, 1414, 1515};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arrInt);

        System.out.println(list);

        Range range = new Range(list);

        for (int i : range.fromTo(5, 55)) {
            System.out.println(i);
        }
    }

    private static class Range implements Iterable<Integer> {

        private final List<Integer> integerList;
        int point = -1;

        public Range(List<Integer> integerList) {
            this.integerList = integerList;
        }

        public List<Integer> fromTo(int startIndex, int endIndex) {

            Iterator iterator = iterator();
            List<Integer> listInRange = new ArrayList<>();
            if (startIndex < 0 || startIndex > endIndex) {
                System.out.println("Incorrect range data");
            } else if (endIndex > this.integerList.size()) {
                System.out.println("Range data out of list");
            } else {
                Integer intInRange;
                while (iterator.hasNext()) {
                    intInRange = iterator.next();
                    point++;
                    if (point >= startIndex && point <= endIndex) listInRange.add(intInRange);
                }
            }
            return listInRange;
        }

        @Override
        public Iterator iterator() {
            return new Iterator(integerList);
        }
    }

    static class Iterator implements java.util.Iterator<Integer> {

        List<Integer> integerList;
        private int cursor = -1;

        public Iterator(List<Integer> integerList) {
            this.integerList = integerList;
        }

        @Override
        public boolean hasNext() {
            return cursor < this.integerList.size() - 1;
        }

        @Override
        public Integer next() {
            if (hasNext()) return this.integerList.get(++cursor);
            else throw new NoSuchElementException();
        }
    }
}
