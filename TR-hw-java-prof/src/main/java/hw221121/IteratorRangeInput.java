package hw221121;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorRangeInput {

    public static void main(String[] args) {

        for (int i : Range.fromTo(-100, 100)) {
            System.out.println(i);
        }
    }

    static class Range implements Iterable<Integer> {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public static Range fromTo(int start, int end) {
        return new Range(start, end);
    }

        @Override
        public Iterator iterator() {
            return new Iterator(this);
        }

    }

    static class Iterator implements java.util.Iterator<Integer> {

        private Range range;
        private int pointer;

        public Iterator(Range range) {
            this.range = range;
            this.pointer = range.end;
        }

        @Override
        public boolean hasNext() {
            return pointer < range.start;
        }


        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return pointer++;
        }
    }
}

//static class CollectionRange<T> implements Iterable<T> {
//
//    private int from;
//    private int to;
//    private Collection<T> collection;
//
//    private CollectionRange(Collection<T> collection, int from, int to) {
//        this.from = from;
//        this.to = to;
//        this.collection = collection;
//    }
//
//    public static <T> CollectionRange<T> fromTo(Collection<T> collection, int from, int to) {
//        if (from < 0) throw new IllegalArgumentException();
//        return new CollectionRange<T>(collection, from, to);
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new CollectionRangeIterator<T>(this);
//    }
//}

//static class CollectionRangeIterator<T> implements Iterator<T> {
//
//    private CollectionRange<T> range;
//    private int pointer;
//    private List<T> list;
//
//    public CollectionRangeIterator(CollectionRange<T> range) {
//        this.range = range;
//        this.pointer = range.from;
//        this.list = new ArrayList<>(range.collection);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return pointer < range.to && pointer < range.collection.size();
//    }
//
//    @Override
//    public T next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        return list.get(pointer++);
//    }
//}

//static class Range implements Iterable<Integer> {
//
//    private int from;
//    private int to;
//
//    public Range(int from, int to) {
//        this.from = from;
//        this.to = to;
//    }
//
//    public static Range fromTo(int from, int to) {
//        return new Range(from, to);
//    }
//
//    @Override
//    public Iterator<Integer> iterator() {
//        return new RangeIterator(this);
//    }
//}

//static class RangeIterator implements Iterator<Integer> {
//
//    private Range range;
//    private int pointer;
//
//    public RangeIterator(Range range) {
//        this.range = range;
//        this.pointer = range.from;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return pointer < range.to;
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        return pointer++;
//    }
//}


