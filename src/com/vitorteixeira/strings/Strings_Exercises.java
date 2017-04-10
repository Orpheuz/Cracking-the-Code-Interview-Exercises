package com.vitorteixeira.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitor on 30-03-2017.
 */
public class Strings_Exercises {

    // Strings ex: 6
    public static String compression(String s) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int numOccurences = 1;
            while(i+1 < s.length() && c == s.charAt(i+1)) {
                numOccurences++;
                i += 1;
            }
            sb.append(c);
            sb.append(numOccurences);
        }

        String result = sb.toString();

        if(result.length() >= s.length())
            return s;
        else return result;
    }

    // Strings ex: 5 - Not finished
    public static boolean oneAway(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if(s1.length() == s2.length()) {
            // Check replace
        }

        if(s1.length() - 1 == s2.length()) {
            // Check insertion
        }

        if(s1.length() + 1 == s2.length()) {
            // Check removal
        }

        return true;
    }

    // Strings ex: 4 - even and odd checked but its enough to check only "odd > 1"
    public static boolean palindromePermutation(String str) {

        boolean odd;
        int numSpaces = 0;
        HashMap<Character, Integer> counts = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                numSpaces++;
                continue;
            }
            if(counts.containsKey(ch))
                counts.put(ch, counts.get(ch) + 1);
            else counts.put(ch, 1);
        }

        int size = str.length() - numSpaces;

        if(size % 2 != 0)
            odd = true;
        else odd = false;

        boolean oddNumChars = false;

        for(Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if(odd) {
                if(entry.getValue() % 2 != 0)
                    if(oddNumChars)
                        return false;
                    else oddNumChars = true;
            }
            else {
                if(entry.getValue() % 2 != 0)
                    return false;
            }
        }
        return true;
    }

    // Strings ex: 3
    public static char[] urlify(char[] chArr, int length) {

        int spaceCount = 0;

        for(int i = 0; i < length; i++) {
            if(chArr[i] == ' ')
                spaceCount++;
        }

        int index = spaceCount * 2 + length;

        if (length < chArr.length) chArr[length] = '\0';

        for(int i = length - 1; i >= 0; i--) {
            if(chArr[i] == ' ') {
                chArr[index-1] = '0';
                chArr[index-2] = '2';
                chArr[index-3] = '%';
                index = index - 3;
            }
            else {
                chArr[index-1] = chArr[i];
                index--;
            }
        }
        return chArr;
    }

    // Strings ex: 2
    public static boolean isPermutation(String s1, String s2) {

        if(s1.length() != s2.length())
            return false;

        char[] ch1Arr = s1.toCharArray();
        java.util.Arrays.sort(ch1Arr);

        char[] ch2Arr = s2.toCharArray();
        java.util.Arrays.sort(ch2Arr);

        return java.util.Arrays.equals(ch1Arr, ch2Arr);
    }

    // Strings ex: 1
    public static boolean hasUniqueChars(char[] str) {

        boolean[] chars = new boolean[128];

        for(char ch : str) {
            System.out.println(ch);
            if(chars[ch] == true)
                return false;
            else chars[ch] = true;
        }

        return true;
    }
}
