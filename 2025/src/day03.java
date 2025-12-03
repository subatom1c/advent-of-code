import java.util.Scanner;
import java.lang.Math;


class Day03 {

    public static int joltage_1 = 0;
    public static long joltage_2 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        while (scanner.hasNextLine()) {
            
            input = scanner.nextLine();
            if (input.isEmpty()) break;
            max_bank_joltage_2(input);
        }
        System.out.println(joltage_2);
    }

    public static void max_bank_joltage_1(String line) {
        // Keep track of max and max after that
        // If max after that is bigger than max, max = max after and repeat
        char[] array = line.toCharArray();

        int max = 0, sub_max = 0;

        for (int i = 0; i < line.length(); i++) {
            int n = array[i] - '0';
            if (n > max && i != line.length() - 1) {
                max = n;
                sub_max = 0;
            } else if (n > sub_max) {
                sub_max = n;
            }
        }
        joltage_1 += max*10 + sub_max;
    }

    public static void max_bank_joltage_2(String line) {
        // we need to keep only 12 digits
        // Find the max (if there are 12 digits left including this one) and keep him
        // Find the following max after that index...

        char[] array = line.toCharArray();
        int[] answer = new int[12];

        int max = 0;
        int current_index = 0;


        for (int element = 0; element < 12; element++) { // Find 12 elements
            max = -1;

            for (int i = current_index; i <= array.length - (12 - element); i++) { // Iterate until there are enough elements to fulfill the rest of the array
                int n = array[i] - '0';

                if (n > max) {
                    max = n;
                    current_index = i + 1;
                }
            }
            answer[element] = max;
        }

        for (int i = 0; i < 12; i++) {
            joltage_2 += answer[i] * Math.pow(10, 11 - i);
        }

    }
}