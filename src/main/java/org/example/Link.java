package org.example;

public class Link {
    People personFirst;
    People personSecond;
    String relationFirst;
    String relationSecond;

    public Link(People personFirst, People personSecond, String relationFirst, String relationSecond ) {
        this.personFirst = personFirst;
        this.personSecond = personSecond;
        this.relationFirst = relationFirst;
        this.relationSecond = relationSecond;
    }

    @Override
    public String toString() {
       return personFirst + " + " + personSecond + " = "  + relationFirst + "\n"
                + personSecond + " + " + personFirst + " = "  + relationSecond +  "\n" +"______________";
    }

}