package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyHashMap<Integer, String> myHashMap = new MyHashMap<>(3);
        myHashMap.put(1, "ronaldo");
        myHashMap.put(2, "beckham");
        myHashMap.put(3, "messi"); //Resize
        myHashMap.put(2, "kaka"); //Replace "beckham"

        String name = myHashMap.get(2);
        System.out.println("name: " + name); //Expect "kaka"
    }
}