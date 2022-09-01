package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {


        List<People> Person = new ArrayList<>();

        Person.add(new People( "Dima", " Ludvigovich", -12001, "Russia",  "Nizniy Novgorod", " Al-Faraby", 16));
        Person.add(new People( "Dima", " Ludvigovich", -10944, "Russia", "Nizniy Tagil", " Udenitch", 1));
        Person.add(new People( "Olga", "Dmitrievna", 9186,"Russia",  "Tashkent", "Al-Faraby", 76));
        Person.add(new People("Dima", "Dmitrievich", 9857,"Russia",  "Semipalatinsk", "Al-Faraby", 11));
        Person.add(new People("Yuri", "Glebovich", 12500,"Russia",  "Baltabay", "Al-Faraby", 7));
        Person.add(new People( "Erbol", "Glebovich", 12711,"Russia",  "Fergana", "Al-Faraby", 3 ));
        Person.add(new People( "Raushan", "Glebovna", 12711,"Russia",  "Fergana", "Al-Faraby", 3 ));
        Person.add(new People("Saule", "Glebovna", 12500,"Russia",  "Baltabay", "Al-Faraby", 7));

        ArrayList<Link> tree = new ArrayList<>();

        tree.add(new Link(Person.get(0), Person.get(1), "Brother - Brother", "Brother - Brother")); // заполняем дерево персонажами и родственными отношениями между ними
        tree.add(new Link(Person.get(0), Person.get(2), "Parents - Children", "Children - Parents"));
        tree.add(new Link(Person.get(0), Person.get(3), "Parents - Children", "Children - Parents"));

        tree.add(new Link(Person.get(1), Person.get(4), "Parents - Children", "Children - Parents"));
        tree.add(new Link(Person.get(1), Person.get(5), "Parents - Children", "Children - Parents"));
        tree.add(new Link(Person.get(1), Person.get(6), "Parents - Children", "Children - Parents"));
        tree.add(new Link(Person.get(1), Person.get(7), "Parents - Children", "Children - Parents"));

        tree.add(new Link(Person.get(2), Person.get(3), "Sister - Brother", "Brother - Sister"));

        tree.add(new Link(Person.get(4), Person.get(5), "Brother - Brother", "Brother - Brother"));
        tree.add(new Link(Person.get(4), Person.get(6), "Brother - Sister", "Sister - Brother"));
        tree.add(new Link(Person.get(4), Person.get(7), "Brother - Sister", "Sister - Brother"));
        tree.add(new Link(Person.get(5), Person.get(6), "Brother - Sister", "Sister - Brother"));
        tree.add(new Link(Person.get(5), Person.get(7), "Brother - Sister", "Sister - Brother"));
        tree.add(new Link(Person.get(6), Person.get(7), "Sister - Sister", "Sister - Sister"));


        Supplier<User> userFactory = ()->{

        Scanner in = new Scanner(System.in);
        System.out.println("Indicate alternately your first and middle name: ");
        String name = in.nextLine();
        return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Dear " +  user1.getName() + user2.getName() +  " introducing the Family Tree Program. " );
        System.out.println("Press 1 for see Brother - Brother");
        System.out.println("Press 2 for see Parents - Children");
        System.out.println("Press 3 for see Sister - Brother");
        System.out.println("Press 4 for see Sister - Sister" + "\n" );


        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = in.nextInt();

        Function<Integer, String> convert = x-> "Pozition number " + String.valueOf(x)  ;

        if (num == 1) {
            for (int i = 0; i < tree.size(); i++) {
                if (!Objects.equals(tree.get(i).relationFirst, "Brother - Brother")) {
                    continue;
                }
                System.out.println("\n" + convert.apply(i));
                System.out.println(tree.get(i).toString());

            }
        }

         if (num == 2) {
             for (int i = 0; i < tree.size(); i++) {
                 if (!Objects.equals(tree.get(i).relationFirst, "Parents - Children")&&
                     !Objects.equals(tree.get(i).relationSecond, "Parents - Children"))
                 {
                     continue;
                 }
                 System.out.println(convert.apply(i));
                 System.out.println(tree.get(i).toString());
             }
         }

         if (num == 3) {
             for (int i = 0; i < tree.size(); i++) {
                  if (!Objects.equals(tree.get(i).relationFirst, "Sister - Brother") &&
                      !Objects.equals(tree.get(i).relationSecond, "Sister - Brother"))
                  {
                         continue;
                  }
                 System.out.println(convert.apply(i));
                  System.out.println(tree.get(i).toString());
             }
         }


         if (num == 4) {
             for (int i = 0; i < tree.size(); i++) {
                 if (!Objects.equals(tree.get(i).relationFirst, "Sister - Sister")) {
                    continue;
                 }
                 System.out.println(convert.apply(i));
                 System.out.println(tree.get(i).toString());
            }
        }
             
    }

}


   class User{
       private final String name;
       String getName(){
           return name;
       }
       User(String n){
           this.name= String.valueOf(n);
         }
  }
