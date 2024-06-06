import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int frequency;
    Node left, right;

    Node(char ch, int frequency, Node left, Node right) {
        this.ch = ch;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class Huffman {
    public static Map<Character, String> encode(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue(), null, null));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }

        Node root = pq.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void buildCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.ch, code);
        }

        buildCodes(node.left, code + "0", huffmanCodes);
        buildCodes(node.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        String input = "Huffman coding is a data compression algorithm.";
        Map<Character, String> huffmanCodes = encode(input);
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
