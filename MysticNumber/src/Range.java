import java.util.Objects;

public class Range {
    private int bulls, cows, r1, r2, r;

    Range(MysticNumber n1, MysticNumber n2) {
        bulls = 0;
        cows = 0;

        for (int i = 0; i < 4; i++) {
            if (n1.getDigit(i).equals(n2.getDigit(i)))
                bulls++;

            for (int j = 0; j < 4; j++)
                if (n1.getDigit(i).equals(n2.getDigit(j)))
                    cows++;
        }

        r1 = 4 - cows;
        r2 = 4 - bulls;
        r = r1 + r2;
    }

    @Override
    public String toString() {
        return "(" + r1 + ", " + r2 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return r1 == range.r1 &&
                r2 == range.r2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r1, r2);
    }
}
