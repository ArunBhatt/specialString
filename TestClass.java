package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        System.out.println("Count: " + count);
        if (1 <=  count && count <= 10) {
            for (int i = 0; i < count; i++) {
                String str = reader.readLine();
                System.out.println("string " + i + ": " + str);
                if(str.contains(" ")) {
                    generateSpecialString(str);
                }
            }
        } else {
            throw new Exception("Value of T is not correct: T: " + count + "\n expected value is 1<=T<=10. ");
        }

        reader.close();
    }

    private static void generateSpecialString(String str) throws Exception {
        String[] strArr = str.split(" ");
        if (strArr.length == 2) {
            int K = Integer.parseInt(strArr[0]);
            if (1 <= K && K <= 100) {
                String S = strArr[1].toLowerCase();
                int len = S.length();
                int cost = (int)Math.pow(10,6);
                if (1 <= len && len <= cost) {
                    if (len % K == 0) {
                        for (int i = 0; i < (S.length() - K); i = i + K) {
                            String str1 = S.substring(i, i + K);
                            int currCost = getCost(str1 + str1.repeat(K - 1), S);
                            if (currCost < cost) {
                                cost = currCost;
                            }
                        }
                        System.out.println("Cost : " + cost);
                    } else {
                        throw new Exception("Given string's length " + len +" is not a multiple of K " + K );
                    }
                }
                else {
                    throw new Exception("Length of S is inappropriate: len: " + len + "\n expected length is 10^6. ");
                }
            } else {
                throw new Exception("Value of K is not correct: K: " + K + "\n expected value is 1<=K<=100. ");
            }
        } else {
            throw new Exception("Given string is not correct: val: " + str);
        }
    }

    private static int getCost(String specialString, String completeString) {
        int cost = 0;
        for (int i=0; i<completeString.length(); i++) {
            char char2 = specialString.charAt(i);
            int charCost = getCharCost(completeString, char2, 0, i, 100);
            cost = cost + charCost;
        }
        return cost;
    }

    private static int getCharCost(String completeString, char c, int currIndex, int charIndex, int cost) {
        int i = completeString.indexOf(c, currIndex);

        int cost1 = Math.abs(charIndex-i);
        int cost2 = i + (completeString.length() - charIndex);
        int currCost = Math.min(cost2, cost1);
        if (currCost < cost)
            cost = currCost;

        if (i == charIndex) {
            return 0;
        } else if (completeString.substring(i+1).contains(Character.toString(c))){
            currCost = getCharCost(completeString, c, i+1, charIndex, cost);
            if (currCost < cost)
                cost = currCost;
        }
        return cost;
    }
}
