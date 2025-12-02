import java.util.Scanner;


class Day01 {

    public static int zero_hits = 0;

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
            //System.out.println("current point = " + current_point);
        }
        System.out.println(zero_hits);
        System.out.println("current point = " + current_point);
    }

    public static int move_pointer(int current_point, char direction, int number) {
        // Directions basically means the operation we're gonna apply
        // Left is for subtraction, Right is for Addition
        // Let's just make a if for each one

        // We can also strip the hundreds number since it doesnt do anything
        current_point = current_point % 100;

        if (direction == 'L') {
            int difference = current_point - number;

            if (difference < 0) {
                return 100 + difference;
            } else if (difference == 0) {
                System.out.println(String.valueOf(direction) + number);
                zero_hits += 1;
            }
            return difference;
        }

        if (direction == 'R') {
            int addition = current_point + number;

            if (addition > 99) {
                return addition - 100;
            } else if (addition == 0) {
                System.out.println(String.valueOf(direction) + number);
                zero_hits += 1;
            }
            return addition;
        }
        
        return 0;
    }   
}