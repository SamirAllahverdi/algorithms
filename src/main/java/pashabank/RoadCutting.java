package pashabank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoadCutting {



    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(5, 4, 4, 2, 2, 8);
        System.out.println(rodOffcut(integers));
    }

    public static List<Integer> rodOffcut(List<Integer> list) {

        List<Integer> rodsList = new ArrayList<>();
        rodsList.add(list.size());
        Collections.sort(list);

        int sumMin = list.get(0);
        int rods = 1;

        for (int a = 1; a < list.size(); a++) {
            int second = list.get(a) - sumMin;
            int first = list.get(a - 1) - sumMin;
            if (second == first) {
                rods++;
            } else {
                rodsList.add(rodsList.get(rodsList.size() - 1) - rods);
                rods = 1;
                sumMin += list.get(a);
            }
        }


        return rodsList;
    }

}
