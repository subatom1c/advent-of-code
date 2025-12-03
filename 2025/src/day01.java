import java.util.Scanner;


class Day01 {

    public static int zero_hits = 0;
    public static int zero_clicks = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int current_point = 50;
        String input;

        while (scanner.hasNextLine()) {
            
            input = scanner.nextLine();
            if (input.isEmpty()) break;
            char direction = input.charAt(0);
            int number = Integer.parseInt(input.substring(1));
            
            current_point = move_pointer(current_point, direction, number);
            if (current_point == 0) {
                zero_hits += 1;
            }
        }
        System.out.println("Solution 1: " + zero_hits);
        System.out.println("Solution 2: " + zero_clicks);
    }

    public static int move_pointer(int current_point, char direction, int number) {

        int hundreds = number / 100;
        zero_clicks += hundreds; 
        number = number % 100;

        if (direction == 'L') {
            number = number * -1;
        }

        int new_point = current_point + number;
        
        if (new_point == 0) {
            if (current_point != 0) {
                zero_clicks += 1;
            }
        }

        if (new_point < 0) {
            // If you're already on 0, you're not clicking it
            if (current_point != 0) { 
                zero_clicks += 1;
            }
            new_point = 100 + new_point;

        } 
        
        if (new_point > 99) {
            zero_clicks += 1;
            new_point = new_point - 100;
        }

        return new_point;
    }   
}