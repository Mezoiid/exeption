package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws StringNotConvertFractionException {
        try {
            List<Fraction> fractions = new ArrayList<>();
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(1.4);
            Fraction c = new Fraction("2 6/7");
            fractions.add(a);
            fractions.add(b);
            fractions.add(c);
            Collections.sort(fractions, new Comparator<Fraction>() {
                @Override
                public int compare(Fraction o1, Fraction o2) {
                    return (int) (o1.conv() - o2.conv());
                }
            });
            System.out.println(fractions);
            double q = 0;
            q = a.sum(1.2);
            System.out.println(q);
        }catch (Exception e){
            throw new FractionDenumZeroException("Error");
        }
    }
}
