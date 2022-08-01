package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CavityMap {

//    public static void main(String[] args) {
//        List<String> grid = Arrays.asList("1112", "1912", "1892", "1234");
//        System.out.println(cavityMap(grid));
//    }

    public static List<String> cavityMap(List<String> grid) {

        List<String> cavityGrid = new ArrayList<>();
        cavityGrid.add(grid.get(0));

        for (int row = 1; row < grid.size() - 1; row++) {
            String currentRow = grid.get(row);
            StringBuilder builder = new StringBuilder();
            builder.append(currentRow.charAt(0));
            for (int col = 1; col < currentRow.length() - 1; col++) {
                int val = Integer.parseInt(String.valueOf(currentRow.charAt(col)));
                if (isCavity(val, col, row, grid))
                    builder.append("X");
                else
                    builder.append(currentRow.charAt(col));
            }
            builder.append(currentRow.charAt(currentRow.length() - 1));
            cavityGrid.add(builder.toString());
        }

        if (grid.size() != 1)
            cavityGrid.add(grid.get(grid.size() - 1));

        return cavityGrid;


    }

    public static boolean isCavity(int val, int col, int row, List<String> grid) {
        return val >= Integer.parseInt(String.valueOf(grid.get(row + 1).charAt(col))) &&
                val >= Integer.parseInt(String.valueOf(grid.get(row - 1).charAt(col))) &&
                val >= Integer.parseInt(String.valueOf(grid.get(row).charAt(col + 1))) &&
                val >= Integer.parseInt(String.valueOf(grid.get(row).charAt(col - 1)));
    }

}
