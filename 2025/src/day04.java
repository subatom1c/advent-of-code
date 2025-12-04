import java.util.*;

class Day04 {

    public static int accessible_rolls_1 = 0;
    public static int accessible_rolls_2 = 0;
    public static boolean once = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int current_point = 50;
        String input;

        List<char[]> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.isEmpty()) break;

            list.add(input.toCharArray());
        }

        char[][] matrix = list.toArray(new char[0][]);
        accessible_rolls(matrix);
        while (accessible_rolls(matrix));
        
        System.out.println("Solution 1: " + accessible_rolls_1);
        System.out.println("Solution 2: " + accessible_rolls_2);
    }

    public static boolean accessible_rolls(char[][] matrix) {
        int temp = accessible_rolls_2;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] != '@') {
                    continue;
                }
                if (once) {
                    count_adjacent_1(matrix, x, y);
                } else {
                    count_adjacent_2(matrix, x, y);
                }
            }
        }
        once = false;
        return temp != accessible_rolls_2;
    }

    public static boolean in_bounds(int nrows, int ncollumns, int x, int y) {
        if (x < 0 || x >= ncollumns) {
            return false;
        }

        if (y < 0 || y >= nrows) {
            return false;
        }
        return true;
    }

    
    public static void count_adjacent_1(char[][] matrix, int x, int y) {

        int roll_count = 0;
        for (int add_y = -1; add_y <= 1; add_y++) {
            for (int add_x = -1; add_x <= 1; add_x++) {
                if (add_y == 0 && add_x == 0) {
                    continue;
                }

                if (!in_bounds(matrix.length, matrix[0].length, x + add_x, y + add_y)) {
                    continue;
                }


                if (matrix[y + add_y][x + add_x] == '@') {
                    roll_count++;
                }
            }  
        }

        if (roll_count < 4) {
            accessible_rolls_1 += 1;
        }
    }

    public static void count_adjacent_2(char[][] matrix, int x, int y) {

        int roll_count = 0;
        for (int add_y = -1; add_y <= 1; add_y++) {
            for (int add_x = -1; add_x <= 1; add_x++) {
                if (add_y == 0 && add_x == 0) {
                    continue;
                }

                if (!in_bounds(matrix.length, matrix[0].length, x + add_x, y + add_y)) {
                    continue;
                }


                if (matrix[y + add_y][x + add_x] == '@') {
                    roll_count++;
                }
            }  
        }

        if (roll_count < 4) {
            accessible_rolls_2 += 1;
            matrix[y][x] = '.';
        }
    }

}