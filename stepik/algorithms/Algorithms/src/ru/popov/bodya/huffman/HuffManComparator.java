package ru.popov.bodya.huffman;

import java.util.Comparator;

public class HuffManComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.frequency - node2.frequency;
    }
}