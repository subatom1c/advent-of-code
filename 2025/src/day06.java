import java.util.*;


class Day06 {

    public static long sum_1 = 0;
    public static long sum_2 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        List<String> lines = new ArrayList<>(); 

        while (scanner.hasNextLine()) {
            
            input = scanner.nextLine();
            if (input.isEmpty()) break;
            lines.add(input);
        }

        process_cols_1(lines);
        process_cols_2(lines);
        System.out.println("Solution 1: " + sum_1);
        System.out.println("Solution 2: " + sum_2);
    }

    public static void process_cols_1(List<String> lines) {

        List<List<Long>> numbers = new ArrayList<>();
        List<Character> operations = new ArrayList<>();


        for (String input : lines) {

            if (!Character.isDigit(input.charAt(0))) {
                
                for (char c : input.toCharArray()) {
                    if (c != ' ') 
                        operations.add(c);
                }
            } else {
                String[] parts = input.split("\\s+");
                List<Long> intLine = new ArrayList<>();
                for (String p : parts) {
                    intLine.add(Long.parseLong(p));
                }
                numbers.add(intLine);
            }
        }
        
        for (int col = 0; col < operations.size(); col++) {
            long collective = numbers.get(0).get(col);
            for (int row = 1; row < numbers.size(); row++) {
                collective = calculator(operations.get(col), collective, numbers.get(row).get(col));
            }
            sum_1 += collective; 
        }
    }

    public static void process_cols_2(List<String> lines) {
        
        int nlines = lines.size();
        int line_size = lines.get(0).length();

        char operation = lines.get(nlines - 1).charAt(0);
        boolean empty_col = false;
        int blank_line_counter = 0;
        long collective = 0;
        if (operation == '*') {
            collective = 1;
        }

        // Go through each collumn
        for (int collumn = 0; collumn < line_size; collumn++) {
            
            if (empty_col) {
                empty_col = false;
                operation = lines.get(nlines - 1).charAt(collumn);
                sum_2 += collective;

                collective = 0;
                if (operation == '*') {
                    collective = 1;
                }
            }

            String built_line = "";

            for (int line = 0; line < nlines - 1; line++) {

                if (lines.get(line).charAt(collumn) == ' ') {
                    blank_line_counter++;
                    continue;
                }
                built_line = built_line + lines.get(line).charAt(collumn);
            }

            if (blank_line_counter == nlines - 1) {
                empty_col = true;
                
            }

            blank_line_counter = 0;

            if (!empty_col) {
                collective = calculator(operation, collective, Long.parseLong(built_line));  
            }
        }
        sum_2 += collective;

    }



    public static long calculator (char operation, long number1, long number2) {
        
        if (operation == '*') {
            return number1 * number2;
        }
        return number1 + number2;
    }

}