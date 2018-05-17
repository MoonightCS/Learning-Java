package ru.popov.bodya.chapter2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EncodeHuffman {

    private static Map<Character, Integer> getInputCharsFrequency(final String input) {

        final Map<Character, Integer> frequencyMap = new HashMap<>();
        final char[] chars = input.toCharArray();
        for (char ch : chars) {
            frequencyMap.compute(ch, (character, integer) -> integer == null ? 1 : integer + 1);
        }
        return frequencyMap;
    }

    private static Node buildTree(final Map<Character, Integer> map) {

        final Queue<Node> nodeQueue = createQueue(map);

        while (nodeQueue.size() > 1) {
            final Node node1 = nodeQueue.remove();
            final Node node2 = nodeQueue.remove();
            final Node node = new Node('\0', node1.frequency + node2.frequency, node1, node2);
            nodeQueue.add(node);
        }

        return nodeQueue.remove();
    }

    private static Queue<Node> createQueue(Map<Character, Integer> map) {
        final Queue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.frequency));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue(), null, null));
        }
        return priorityQueue;
    }

    private static Map<Character, String> createHuffmanCodes(Node node) {
        final Map<Character, String> huffmanCodesMap = new HashMap<>();
        if (node.left == null && node.right == null) {
            huffmanCodesMap.put(node.ch, "0");
        } else {
            createCodeRec(node, huffmanCodesMap, "");
        }
        return huffmanCodesMap;
    }

    private static void createCodeRec(Node node, Map<Character, String> map, String s) {
        if (node.left == null && node.right == null) {
            map.put(node.ch, s);
            return;
        }
        createCodeRec(node.left, map, s + '0');
        createCodeRec(node.right, map, s + '1');
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String initialString = scanner.nextLine();
        final Map<Character, Integer> charFreq = getInputCharsFrequency(initialString);
        final Node root = buildTree(charFreq);

        final Map<Character, String> huffmanCodesMap = createHuffmanCodes(root);
        printAnswer(initialString, huffmanCodesMap);
    }

    private static void printAnswer(String initialString, Map<Character, String> huffmanCodesMap) {
        final StringBuilder sb = new StringBuilder();
        final char[] chars = initialString.toCharArray();
        for (char ch : chars) {
            sb.append(huffmanCodesMap.get(ch));
        }
        final String encodedString = sb.toString();
        System.out.println(huffmanCodesMap.size() + " " + encodedString.length());
        for (Map.Entry<Character, String> entry: huffmanCodesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(encodedString);

    }

    private static class Node {

        final int frequency;
        final char ch;
        final Node left;
        final Node right;

        Node(char ch, int frequency, Node left, Node right) {
            this.ch = ch;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }
}