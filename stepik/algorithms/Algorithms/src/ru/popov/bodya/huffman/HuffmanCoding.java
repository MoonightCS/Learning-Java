package ru.popov.bodya.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class HuffmanCoding {

    //step 1 get char frequency map, Time O(n) Space O(n)
    private static Map<Character, Integer> getCharFrequency(String input) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                int val = map.get(ch);
                map.put(ch, ++val);
            }
        }
        return map;
    }

    //step 2 build tree, Time O(n) Space O(n)
    private static HuffmanNode buildTree(Map<Character, Integer> map) {
        Queue<HuffmanNode> nodeQueue = createQueue(map);

        while (nodeQueue.size() > 1) {
            HuffmanNode node1 = nodeQueue.remove();
            HuffmanNode node2 = nodeQueue.remove();
            HuffmanNode node = new HuffmanNode('\0', node1.frequency + node2.frequency, node1, node2);
            nodeQueue.add(node);
        }

        return nodeQueue.remove();
    }

    private static Queue<HuffmanNode> createQueue(Map<Character, Integer> map) {
        Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(11, new HuffManComparator());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
        }
        return pq;
    }

    //step 3 create Huffman code map, Time O(n) Space O(n)
    private static Map<Character, String> createHuffmanCodes(Set<Character> chars, HuffmanNode node) {
        Map<Character, String> map = new HashMap<Character, String>();
        createCodeRec(node, map, "");
        return map;
    }

    private static void createCodeRec(HuffmanNode node, Map<Character, String> map, String s) {
        if (node.left == null && node.right == null) {
            map.put(node.ch, s);
            return;
        }
        createCodeRec(node.left, map, s + '0');
        createCodeRec(node.right, map, s + '1');
    }

    public static void main(String[] args) {
        //the input is a sorted concatenate string
        Map<Character, Integer> charFreq = getCharFrequency("AAAAAABBCCDDEEFFFFF");
        HuffmanNode root = buildTree(charFreq);

        Map<Character, String> charCode = createHuffmanCodes(charFreq.keySet(), root);
        System.out.println(charCode);
    }
}