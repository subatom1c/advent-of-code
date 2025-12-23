import java.util.*;


class Day09 {

    public static int sol_1 = 0;
    public static int sol_2 = 0;

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        List<Coordinates> matrix = new ArrayList<>();

        int max_area = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty())
                break;

            String[] parts = line.split(",");
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            
            Coordinates cord = new Coordinates(x, y);
            matrix.add(cord);

        }

        for (int i = 0; i < matrix.size() - 1; i++) {
            for (int j = i + 1; j < matrix.size(); j++) {
                if (calculate_area(matrix.get(i), matrix.get(j)) > max_area) {
                    max_area = calculate_area(matrix.get(i), matrix.get(j));
                }
            }
        }

        sol_1 = max_area;

        System.out.println("Solution 1: " + sol_1);
        System.out.println("Solution 2: " + sol_2);
    }

    public static int calculate_area(Coordinates first, Coordinates second) {
        int height = Math.abs(first.getCol() - second.getCol());
        int width = Math.abs(first.getRow() - second.getRow());
        return height * width;
    }

}