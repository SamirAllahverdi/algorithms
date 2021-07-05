package newAlgorithms.hackerRank;

public class LibraryFine {


    public static final int FINE_IF_IN_SAME_MONTH = 15;
    public static final int FINE_IF_IN_SAME_YEAR = 500;
    public static final int FINE_IF_IN_NEXT_YEAR = 10000;
    public static final int NO_FINE = 0;


    /**
     * https://www.hackerrank.com/challenges/library-fine
     */
//    public static void main(String[] args) {
//
//        System.out.println(libraryFine(9, 6, 2015, 6, 6, 2015)); /* expected 45*/
//    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        if (y1 > y2)
            return FINE_IF_IN_NEXT_YEAR;
        else if (y1 == y2)
            if (m1 > m2)
                return (m1 - m2) * FINE_IF_IN_SAME_YEAR;
            else if (d1 > d2 && m1 == m2)
                return (d1 - d2) * FINE_IF_IN_SAME_MONTH;

        return NO_FINE;
    }


}
