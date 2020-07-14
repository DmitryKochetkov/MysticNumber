import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int solve(MysticNumber secret) {
        RangeTable table = new RangeTable();
        for (MysticNumber number: Generator.getAll())
            table.addNumber(number);

        ArrayList<RangeTable> tables = new ArrayList<>();
        tables.add(table);
        MysticNumber sample = new MysticNumber(new Integer[]{1, 2, 3, 4});

        int iteration = 0;

        Range range = new Range(secret, sample);

        while (true) {
            //System.out.println("Iteration " + iteration + ": sample " + sample + ", range " + range);
            iteration++;

            tables.add(new RangeTable());
            for (MysticNumber number: tables.get(iteration - 1).getNumbers()) {
                Range range2 = new Range(number, sample);
                if (range.equals(range2)) {
                    tables.get(iteration).getNumbers().add(number);
                }
            }

            try {
                sample = tables.get(iteration).getNumbers().get(0);
            }
            catch (IndexOutOfBoundsException e) {
                return iteration;
            }

            if (tables.get(iteration).getNumbers().isEmpty()) {
                return iteration;
            }
            tables.get(iteration).getNumbers().remove(0);
            range = new Range(secret, sample);
        }
    }

    static void checkIterations() {
        HashMap<Integer, Integer> stat = new HashMap<>();
        for (MysticNumber number: Generator.getAll()) {
            int iterations = solve(number);
            stat.merge(iterations, 1, Integer::sum);
        }

        System.out.println("*** Statistics ***");
        for (int key: stat.keySet()) {
            System.out.println(key + " iterations: " + stat.get(key) + " cases");
        }
    }

    public static void main(String[] args) {
        checkIterations();

        System.out.println(solve(new MysticNumber(new Integer[]{1, 2, 3, 4})));
    }
}
