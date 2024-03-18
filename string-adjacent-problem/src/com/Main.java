package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String s = "aaaabbccddee-";

//        System.out.println("Begin...");

        String result = arrangement(s);
        System.out.println(result);

//        System.out.println("End...");

    }

    /**
     * @param s
     * @return
     */
    private static String arrangement(String s) {

        Map<Character, Integer> map = freq(s);
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
//        System.out.println(maxEntry.getKey());
//        System.out.println(maxEntry.getValue());
        String s2 = s.replaceAll(String.valueOf(maxEntry.getKey()), "");
//        System.out.println("s2 = " + s2);
        int remainCharsAmount = s.length() - maxEntry.getValue();


        //not possible to arrange
        if (maxEntry.getValue() >= remainCharsAmount + 1) {
            return "";
        }

        //Print valid string
        LinkedList<Character> result = new LinkedList<Character>();
        for (int i = 0; i < maxEntry.getValue(); i++) {
            result.add(maxEntry.getKey());
        }
//        System.out.println(result);
        int latestInsert = 1;

        for (int i = 0; i < s2.length(); i++) {
            result.add(latestInsert, s2.charAt(i)); //TODO: must not use s2, should use the freq map
            if (latestInsert + 1 >= result.size())
                latestInsert = 0;
            for (int j = latestInsert; j < result.size(); j++) {
                if (result.get(j) == maxEntry.getKey()) {
                    latestInsert = j + 1;
                    break;
                }
            }
        }
//        System.out.println(result);
        return result.stream().map(c -> c.toString()).collect(Collectors.joining());
    }

    /**
     * Store every character & its frequency
     *
     * @param s
     * @return a Map
     */
    private static Map<Character, Integer> freq(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        return map;
    }
}
