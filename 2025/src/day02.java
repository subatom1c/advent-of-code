import java.util.Scanner;


class Day02 {

    public static long id_sum_1 = 0;
    public static long id_sum_2 = 0;

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
            sequence_check_p1(start, end);
            sequence_check_p2(start, end);
        }
        System.out.println("Solution 1: " + id_sum_1);
        System.out.println("Solution 2: " + id_sum_2);
    }

    // Function for Solution 1
    public static void sequence_check_p1(long start, long end) {
        for (long i = start; i <= end; i++) {
            String str = Long.toString(i);
            if (str.length() % 2 != 0) {
                continue;
            }
            String first_half = str.substring(0, str.length() / 2);
            String second_half = str.substring(str.length() / 2);

            if (first_half.equals(second_half)) {
                id_sum_1 += Long.parseLong(first_half + second_half);
            }

        }
    }

    // Function for solution 2
    public static void sequence_check_p2(long start, long end) {
        for (long i = start; i <= end; i++) {
            String str = Long.toString(i);

            // Check for substrings
            for (int size = 1; size <= str.length() / 2; size++) {
                if (str.length() % size != 0) continue;
                String substring = str.substring(0, size);
                
                int repeated_number = str.length() / size;

                boolean valid = true;
                for (int n = 1; n < repeated_number; n++) {
                    String repeated = str.substring(n*size, n*size + size);
                    if (!substring.equals(repeated)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    id_sum_2 += Long.parseLong(str);
                    break;
                }

            }

        }
    }

}