import java.util.ArrayList;

public class RangeTable {
    private ArrayList<MysticNumber> numbers = new ArrayList<>();

    public void addNumber(MysticNumber number) {
        numbers.add(number);
    }

    public ArrayList<MysticNumber> getNumbers() {
        return numbers;
    }
}
