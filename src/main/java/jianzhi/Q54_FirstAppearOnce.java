package jianzhi;

import java.util.*;

/*
 * 字符流中第一个出现的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * */

// Solu1：维护一个有序的Map(LinkedHashMap)，按序遍历读取value值，如果等于1则输出
// Solu2: 维护两个LinkedList，一个保存数量，一个保存字符(未测试)
public class Q54_FirstAppearOnce {
    LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)) {
            int newvalue = linkedHashMap.get(ch) + 1;
            linkedHashMap.put(ch, newvalue);
        } else {
            linkedHashMap.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> map : linkedHashMap.entrySet()) {
            if(map.getValue() == 1) return map.getKey();
        }
        return '#';
    }

    LinkedList<Character> charLinkedList = new LinkedList<>();
    LinkedList<Integer> numLinkedList = new LinkedList<>();
    //Insert one char from stringstream
    public void insert(char ch) {
        if(charLinkedList.contains(ch)){
            int index = charLinkedList.indexOf(ch);
            int newValue = numLinkedList.get(index) + 1;
            numLinkedList.set(index,newValue);
        }else{
            charLinkedList.add(ch);
            numLinkedList.add(1);
        }
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        ListIterator<Character> charListIterator = charLinkedList.listIterator();
        ListIterator<Integer> numListIterator = numLinkedList.listIterator();
        while(numListIterator.hasNext()){
            if(numListIterator.next() == 1) {
                return charListIterator.next();
            }
        }
        return '#';
    }

}
