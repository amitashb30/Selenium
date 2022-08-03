package Collections;

import java.util.ArrayList;

public class Arraylist
{
    public static void main(String args[])
    {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        System.out.println(al);

        ArrayList al2 = new ArrayList();
        al2.add(20);
        al2.add(40);
        al2.add(60);

        al.retainAll(al2);
        System.out.println(al);


        /*System.out.println("al2 is"+al2);

        al.addAll(1,al2);
        al.add(9999);

        System.out.println("after merging"+al);

        System.out.println(al.indexOf(1000));

        al2.clear();
        System.out.println(al2);

         */
    }



}
