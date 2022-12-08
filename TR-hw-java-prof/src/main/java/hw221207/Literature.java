package hw221207;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Literature implements Comparable<Literature>{
    private int yearOfCreate;
    private String mainCharacter;

    @Override
    public String toString() {
        return String.format( "Год написания : %-6s произведение : %-20s", yearOfCreate, mainCharacter);
    }

    @Override
    public int compareTo(Literature o) {
        int res = yearOfCreate - o.yearOfCreate;
        if (res == 0) res = mainCharacter.compareTo(o.mainCharacter);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Literature that = (Literature) o;
        return Objects.equals(yearOfCreate, that.yearOfCreate) && Objects.equals(mainCharacter, that.mainCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfCreate, mainCharacter);
    }
}
