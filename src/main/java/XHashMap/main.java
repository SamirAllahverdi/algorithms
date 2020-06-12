package XHashMap;

public class main {
    public static void main(String[] args) {
        XHashMap xHashMap = new XHashMap(16);
        xHashMap.put(34, "sd");
        xHashMap.put(2, "dsasa");
        xHashMap.put(1, "dsaassa");




        System.out.println(xHashMap.get(1).value);

    }
}
