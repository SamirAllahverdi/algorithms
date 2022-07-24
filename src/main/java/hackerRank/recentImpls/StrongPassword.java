package hackerRank.recentImpls;

public class StrongPassword {


    /**
     * - https://www.hackerrank.com/challenges/strong-password
     */
//    public static void main(String[] args) {
//        System.out.println(minimumNumber(4,"Hac#"));
//    }

    public static int minimumNumber(int n, String password) {

        int min = 0;

        boolean containsDigit =false;
        boolean containsLowerCase =false;
        boolean containsUpperCase =false;
        boolean containsSpecialCharacter =false;

        for(char curr : password.toCharArray()){
            if(curr >= 48 && curr <= 57)
                containsDigit=true;
            else if( curr >= 97 && curr <=122)
                containsLowerCase =true;
            else if(curr >=65 && curr <=90)
                containsUpperCase= true;
            else
                containsSpecialCharacter=true;
        }


        if(!containsDigit){
            min++;
        }

        if(!containsLowerCase){
            min++;
        }

        if(!containsUpperCase){
            min++;
        }

        if(!containsSpecialCharacter){
            min++;
        }


        int newLength = n + min;
        if(newLength < 6){
            min += 6 - newLength;
        }

        return min;
    }
}
