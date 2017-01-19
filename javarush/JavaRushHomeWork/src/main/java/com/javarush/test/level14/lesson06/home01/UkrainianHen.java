package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen {

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDescription())
                .append(" Моя страна - ")
                .append(Country.UKRAINE)
                .append(". Я несу ")
                .append(getCountOfEggsPerMonth())
                .append(" яиц в месяц.");
        return sb.toString();
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return 12;
    }
}