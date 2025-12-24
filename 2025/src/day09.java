import java.util.*;


class Day09 {

    public static long sol_1 = 0;
    public static long sol_2 = 0;

    static class Coordinates {
        long col;
        long row;

        Coordinates(long row, long col) {
            this.row = row;
            this.col = col;
        }


        public long getRow() {
            return this.row;
        }
        public long getCol() {
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

        long max_area = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty())
                break;

            String[] parts = line.split(",");
            long x = Long.parseLong(parts[0].trim());
            long y = Long.parseLong(parts[1].trim());
            
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

    public static long calculate_area(Coordinates first, Coordinates second) {
        // We need to sum 1 because its inclusive
        long height = 1 + Math.abs(first.getCol() - second.getCol());
        long width = 1 + Math.abs(first.getRow() - second.getRow());

        return height * width;
    }

}