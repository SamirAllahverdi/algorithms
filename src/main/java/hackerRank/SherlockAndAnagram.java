package hackerRank;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SherlockAndAnagram {

    public static void main(String[] args)  {
        long startTime = System.currentTimeMillis();

        String test = "cdcd";
//        System.out.println(sherlockAndAnagrams(test));

        System.out.println(sherlockAndAnagrams2(test));

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);

    }




    static int sherlockAndAnagrams2(String s)
    {
        int l=s.length(),c=0;
        for(int i=0;i<l;i++)
        {
            for(int j=i+1;j<=l;j++)
            {
                String a=s.substring(i,j);
                System.out.println("i = " + i + " j =  " + j + " ,ST = " + a);
                int la=a.length();
                for(int k=0;k<=l-la;k++)
                {
                        if(k!=i)
                        if(check(a,s.substring(k,k+la)))c++;
                }

            }

        }
        return c/2;
    }
    static boolean check(String a,String b)
    {
        int  [] ch=new int[26];
        for(int i=0;i<a.length();i++)
            ch[a.charAt(i)-97]++;
        for(int i=0;i<a.length();i++)
            ch[b.charAt(i)-97]--;
        for(int i=0;i<26;i++)
            if(ch[i]!=0)return false;


        System.out.println("TRUE STRINGS " + a + " && " + b);
        return true;
    }


    //    TODO get stuck in 1 test case
    static int sherlockAndAnagrams(String s) {
        return IntStream.range(1, s.length()).map(a -> findCount(a, s)).reduce(0, Integer::sum);
    }
    private static int findCount(int a, String s) {
        int count = 0;
        for (int c = 0; c < s.length() - a; c++) {
            String st = s.substring(c, c + a);
            for (int b = c + 1; b <= s.length() - a; b++) {
                String st2 = s.substring(b, b + a);
                if (IsAnagram(st, st2)) {
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean IsAnagram(String st, String st2) {
        int[] lettermap = new int[26];
        for(int j=0; j<st.length(); j++){
            char ch = st.charAt(j);
            lettermap[ch - 'a']++;
            ch = st2.charAt(j);
            lettermap[ch - 'a']--;
        }
        return IntStream.range(0,lettermap.length).anyMatch(a-> lettermap[a] != 0) ? false :true;
    }

}
