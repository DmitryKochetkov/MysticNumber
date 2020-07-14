import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MysticNumber secret = new MysticNumber(new Integer[]{9, 2, 3, 8});
        System.out.println("Secret: " + secret);

        RangeTable table = new RangeTable();
        for (MysticNumber number: Generator.getAll())
            table.addNumber(number);

        ArrayList<RangeTable> tables = new ArrayList<>();
        tables.add(table);
        MysticNumber sample = new MysticNumber(new Integer[]{1, 2, 3, 4});

        int iteration = 0;

        Range range = new Range(secret, sample);

        while (true) {
            System.out.println("Iteration " + iteration + ": sample " + sample + ", range " + range);
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
                break;
            }

            if (tables.get(iteration).getNumbers().isEmpty()) {
                System.out.println(sample);
                break;
            }
            tables.get(iteration).getNumbers().remove(0);
            range = new Range(secret, sample);
        }
    }
}
