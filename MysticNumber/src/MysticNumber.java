import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

//4 digit number, allows zero in the beginning
public class MysticNumber {
    private Integer[] digits = new Integer[4];

    public MysticNumber(Integer[] digits) {
        if (digits.length != 4)
            throw new IllegalArgumentException("Mystic number needs 4 different digits");
        for (Integer digit: digits)
            if (digit < 0 || digit > 9)
                throw new IllegalArgumentException("Mystic number needs 4 different digits");
        HashSet<Integer> check = new HashSet<Integer>();
        Collections.addAll(check, digits);
        if (check.size() != 4)
            throw new IllegalArgumentException("Mystic number needs 4 different digits");
        System.arraycopy(digits, 0, this.digits, 0, 4);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 4; i++)
            result = result.concat(Integer.toString(digits[i]));
        return result;
    }

    Integer getDigit(int position) {
        return digits[position];
    }
}
