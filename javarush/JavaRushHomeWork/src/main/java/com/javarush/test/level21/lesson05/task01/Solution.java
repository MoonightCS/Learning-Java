package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Solution n = (Solution) obj;

        boolean firstPart = (first != null) ? first.equals(n.first) : n.first == null;
        boolean secondPart = (last != null) ? last.equals(n.last) : n.last == null;
        return firstPart && secondPart;

    }

    @Override
    public int hashCode() {
        int firstHashCode = (first == null) ? 0 : first.hashCode();
        int lastHashCode = (last == null) ? 0 : last.hashCode();
        return 31 * firstHashCode + lastHashCode;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
