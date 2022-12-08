package hw221207;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Library implements Comparable<Library> {
    private String writer;
    private String literaryWork;


    @Override
    public String toString() {
        return String.format( "Писатель : %-20s произведение : %-30s", writer, literaryWork);
    }

    @Override
    public int compareTo(Library o) {
        int res = writer.compareTo(o.writer);
        if (res == 0) res = literaryWork.compareTo(o.literaryWork);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(writer, library.writer) && Objects.equals(literaryWork, library.literaryWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(writer, literaryWork);
    }
}
