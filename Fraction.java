package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(double fraction){
            String s = String.valueOf(fraction);
            String[] mas = s.split("\\.");
            int power = mas[1].length();
            numerator = (int) fraction;
            denominator = 1;
            this.denominator = (int) Math.pow(10, mas[1].length());
            this.numerator = Integer.parseInt(mas[0]) * denominator + Integer.parseInt(mas[1]);
            reduction();
    }
    public Fraction(String fraction) throws StringNotConvertFractionException {
        try {
            int number = 0;
            int numer = 0;
            int denum = 0;
            String[] s;
            fraction.toLowerCase(Locale.ROOT);
            s = fraction.split(" ");
            if (s.length > 2 || s.length < 1) {
                throw new StringNotConvertFractionException("Wrong String");
            }
            number = Integer.parseInt(s[0]);
            String[] s2 = s[1].split("/");
            if (s.length > 2 || s.length < 1) {
                throw new StringNotConvertFractionException("Wrong String");
            }
            numer = Integer.parseInt(s2[0]);
            denum = Integer.parseInt(s2[1]);
            this.numerator = number * denum + numer;
            this.denominator = denum;
        }catch ( StringNotConvertFractionException e){
            System.out.println(e.getMessage());
        }
    }
    public int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }

    public void reduction(){
        int gcd=GCD(this.numerator,this.denominator);
        this.denominator = this.denominator/gcd;
        this.numerator = this.numerator/gcd;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double conv(int numerator,int denominator){
        double r = (double) numerator/denominator;
        return r;
    }

    public double conv(){
        return conv(this.numerator,this.denominator);
    }

    public double sum(double fraction){
            double rez = fraction + conv();
            return rez;
    }

    public double minus(double fraction){
        double rez = conv()-fraction;
        return rez;
    }

    public double multiply(double fraction){
        double rez = fraction * conv();
        return rez;
    }

    public double divide(double fraction){
        double rez = conv()/fraction;
        return rez;
    }

    public double exponentiating(int number){
        double rez = 0;
        rez = Math.pow(conv(),number);
        return rez;
    }

    public void viewFraction() {
        System.out.println(numerator +"/"+denominator);

    }

    public void viewFractionWithInt(){
        int i = numerator/denominator;
        int j = numerator%denominator;
        System.out.println(i + " " + j +"/" + denominator);
    }

    public void viewDouble(){
        double d = numerator/denominator;
        System.out.println(d);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
class StringNotConvertFractionException extends Exception{
    public StringNotConvertFractionException(String message) {
        super(message);
    }
}
class FractionDenumZeroException extends RuntimeException{
    public FractionDenumZeroException(String message) {
        super(message);
    }
}
