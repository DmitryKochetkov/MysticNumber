import java.util.HashSet;
import java.util.Random;

public class Generator {
    public static MysticNumber generate() {
        Random random = new Random();
        HashSet<Integer> digits = new HashSet<>();
        while (digits.size() < 4)
            digits.add(random.nextInt(10));
        Integer[] arr = new Integer[4];
        arr = digits.toArray(arr);
        return new MysticNumber(arr);
    }

    public static MysticNumber[] getAll() {
        MysticNumber[] all = new MysticNumber[10 * 9 * 8 * 7];
        int id = 0;
        int check;
        for (int i = 0; i <= 9; i++)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    for (int l = 0; l <= 9; l++) {
                        check = (i - j) * (i - k) * (i - l) * (j - k) * (j - l) * (k - l);
                        if (check != 0)
                            all[id++] = new MysticNumber(new Integer[]{i, j, k, l});
                    }
        return all;
    }
}
