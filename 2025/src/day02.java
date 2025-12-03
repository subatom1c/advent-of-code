import java.util.Scanner;


class Day02 {

    public static long id_sum = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        String input;

        while (scanner.hasNext()) {
            
            input = scanner.next();
            if (input.isEmpty()) break;

            String[] parts = input.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            sequence_check(start, end);
        }
        System.out.println("Solution: " + id_sum);
    }

    public static void sequence_check(long start, long end) {
        for (long i = start; i <= end; i++) {
            String str = Long.toString(i);
            if (str.length() % 2 != 0) {
                continue;
            }
            String first_half = str.substring(0, str.length() / 2);
            String second_half = str.substring(str.length() / 2);

            if (first_half.equals(second_half)) {
                id_sum += Long.parseLong(first_half + second_half);
            }

        }
    }

}