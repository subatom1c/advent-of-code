import java.util.*;


class Day07s {

    static class Coordinates {
        int col;
        int row;

        Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }


        public int getRow() {
            return this.row;
        }
        public int getCol() {
            return this.col;
        }

        @Override
        public boolean equals(Object o) {
            Coordinates c = (Coordinates)o;
            return c.getRow() == this.row && c.getCol() == this.col;
        }


        @Override
        public String toString() {
            return "row,col = " + this.row + "," + this.col;
        }

    }


    public static long splits_1 = 0;
    public static long splits_2 = 0;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Coordinates> last_line = new ArrayList<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                last_line.add(new Coordinates(0, i));
            } 
        }

        int row = 1;
        
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.isEmpty())
                break;

            last_line = calculate_line(last_line, input, row);
            row++;
        }

        System.out.println("Solution 1: " + splits_1);
        System.out.println("Solution 2: " + splits_2);
    }

    public static List<Coordinates> calculate_line(List<Coordinates> last_line, String input, int row) {

        // Extract splitters coordinates
        List<Coordinates> new_line = new ArrayList<>();

        for (Coordinates cord: last_line) { // Coordinates for | from last line
            int col = cord.getCol();

            if (input.charAt(col) == '^') { // Check if below | there's a splitter
                splits_1++;

                // Verificar se há um spliter ao lado do splitter 
                if (input.charAt(col - 1) != '^') {
                    if (!new_line.contains(new Coordinates(row, col - 1))) {                                
                        new_line.add(new Coordinates(row, col - 1));
                    }
                }
                if (input.charAt(col + 1) != '^') {
                    if (!new_line.contains(new Coordinates(row, col + 1))) {                                
                        new_line.add(new Coordinates(row, col + 1));
                    }
                }
            } else {
                if (!new_line.contains(new Coordinates(row, col))) {
                    new_line.add(new Coordinates(row , col));
                }
            }
        }
        
        return new_line;

    }
}