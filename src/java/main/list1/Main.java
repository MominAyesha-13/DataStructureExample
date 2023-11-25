package src.java.main.list1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>();
        arrayList.add(1);

        GenericArrayList<String> arrayList1 = new GenericArrayList<>();
        arrayList1.add("A");
        arrayList1.add("B");
        arrayList1.add("C");
        arrayList1.add("C");
        arrayList1.add("C");
        arrayList1.add("C");

        System.out.println(arrayList1.lastIndexOf("C"));
        System.out.println(arrayList1.size());
        arrayList1.add(3, "D");
        arrayList1.set(4, "E");
        System.out.println(arrayList1);
        System.out.println(arrayList1.equals(arrayList));


        src.java.main.list1.ArrayList ar = new src.java.main.list1.ArrayList();
        ar.add(1);
        ar.add(2);
        ar.add(5);
//        System.out.println(ar.size());
        ar.remove(1);
//        System.out.println(ar);
//        System.out.println(ar.size());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("nla");
        strings.add(null);
        strings.add(null);
        strings.add(null);
        strings.add("nla");
        strings.remove(1);
        strings.get(1);
        strings.set(1,"Ar");
        List<String> strings2 = Arrays.asList("A","B","C");

        strings.addAll(strings2);
        strings.addAll(arrayList1);
        Object[] array = strings.toArray();
        arrayList1.addAll(strings);
       /* System.out.println(strings.equals(strings));
        strings.add(4, "A");*/
        System.out.println(strings);
        System.out.println(arrayList1);
        System.out.println(Arrays.toString(array));
    }
}
