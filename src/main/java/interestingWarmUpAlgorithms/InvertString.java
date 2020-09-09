package interestingWarmUpAlgorithms;

public class InvertString {
    // contains only [a-zA-Z]
    // abc -> ABC
    // aBc -> AbC
    // Abc -> aBC
    // 1.

    // 2. NO if. NO tern op.
    String invert(String origin) {
        byte[] bytes = origin.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            int bit = 0b100000;
            bytes[i] ^=32;
//            chars[i] = (char) (chars[i] ^ bit); // switch vice versa
        }
        return new String(bytes);
    }

    String toUpperCase(String origin) { // a -> A A -> A
        char[] chars = origin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int bit = 0b00100000;
            int mask = ~bit; //0b11011111
//            &  = multiplication
            chars[i] = (char) (chars[i] & mask); // switch OFF bit &&
        }
        return new String(chars);
    }

    String toLowerCase(String origin) { // A -> a a -> a
        char[] chars = origin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int bit = 0b100000;
//            | =  increment
            chars[i] = (char) (chars[i] | bit); // switch ON bit
        }
        return new String(chars);
    }
    // ~, &, |, <<, >>

    public static void main(String[] args) {
        InvertString is = new InvertString();
        System.out.println(is.invert("abCeee"));
        System.out.println(is.toLowerCase("abC"));
        System.out.println(is.toUpperCase("abC"));

    }
}
