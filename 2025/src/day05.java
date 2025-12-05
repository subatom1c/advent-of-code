import java.util.*;


class Day05 {


    static class Range {
        long start;
        long end;

        Range(long start, long end) {
            this.start = start;
            this.end = end;
        }


        public long getStart() {
            return this.start;
        }
        public long getEnd() {
            return this.end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "" + this.start + "-" + this.end;
        }
    }

    public static long fresh_elements_1 = 0;
    public static long fresh_elements_2 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        // index par - inicio
        // index impar - fim
        List<Range> intervals = new ArrayList<>();
        List<Long> elements = new ArrayList<>();
        
        boolean interval = true; 

        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                if (interval) {
                    interval = false;
                    continue;
                }
                break;
            }

            if (interval) {

                String[] parts = input.split("-");

                Long start = Long.parseLong(parts[0]);
                Long end = Long.parseLong(parts[1]);

                intervals.add(new Range(start, end));
            } else {
                elements.add(Long.parseLong(input));
            }

        }
        check_validity_1(intervals, elements);
        check_validity_2(intervals);
        System.out.println("Solution 1: " + fresh_elements_1);
        System.out.println("Solution 2: " + fresh_elements_2);
    } 

    public static void check_validity_1(List<Range> intervals, List<Long> elements) {
        
        for (Long elem: elements) {
            for (int i = 0; i < intervals.size(); i += 1) {
                Long start = intervals.get(i).getStart();
                Long end = intervals.get(i).getEnd();

                if (elem >= start && elem <= end) {
                    fresh_elements_1 += 1;
                    break;
                }

            }
        }
    }

    public static void check_validity_2(List<Range> intervals) {

        // Order by first number    
        intervals.sort(Comparator.comparingLong(Range::getStart));  

        long last_end = 0;

        // Sum everything (handling intersections)
        for (Range interval: intervals) {
            System.out.println(interval);
            long start = interval.getStart(); 
            long end = interval.getEnd();

            if (interval.getEnd() < last_end) {
                continue;
            }

            if (interval.getStart() < last_end) {
                start = last_end;
            }

            last_end = end + 1;
            long a = end - start + 1;
            System.out.println("adding " + a);
            fresh_elements_2 += end - start + 1;

        }
        

    }
}

