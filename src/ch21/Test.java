package ch21;

import java.util.HashSet;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("asf");
        hashSet.add("bnk");
        hashSet.add("lsk");
        hashSet.add("owie");
        
        System.out.println(hashSet);
        
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            String ele = (String) it.next();
            System.out.println(ele);
        }
        System.out.println("---------------------------");
        for (String ele : hashSet) {
            System.out.println(ele);
        }
    }
}
