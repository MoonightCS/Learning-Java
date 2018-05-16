package ru.popov.bodya.huffman;

public class HuffmanNode {
    char ch;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(char ch, int frequency, HuffmanNode left, HuffmanNode right) {
        this.ch = ch;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}