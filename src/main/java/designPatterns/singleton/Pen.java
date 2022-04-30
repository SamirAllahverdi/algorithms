package designPatterns.singleton;

public class Pen {

    private static Pen pen = null;

    private Pen() {
    }


    public Pen getInstance() {
        if (pen == null) {
            pen = new Pen();
        }
        return pen;
    }

}
