package SlidingWindow;

import java.util.*;

import static javax.swing.UIManager.put;

class RepeatedDNA {

    public static List<String> findRepeatedSequences(String s, int k) {
        int windowSize = k;
        if (s.length()<= windowSize)
            return new ArrayList<String>();
        // parameters of rolling hash
        int base = 4; // 'a', the hash parameter
        int hiPlaceValue = (int) Math.pow(base, windowSize);
        // mapping of a character into an integer
        Map<Character, Integer> mapping = new HashMap<Character, Integer>() {
            {
                put('A', 1);
                put('C', 2);
                put('G', 3);
                put('T', 4);
            }
        };
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i<s.length(); i++)
            numbers.add(mapping.get(s.charAt(i)));
        int hashing = 0;
        Set<Integer> seen = new HashSet<Integer>();
        Set<String> output = new HashSet<String>();
        // iterate over all window-sized sub-strings
        for (int start = 0; start<s.length() - windowSize + 1; ++start) {
            // hash function of current subsequence
            if (start != 0) {
                hashing = hashing * base;
                hashing -= numbers.get(start - 1) * hiPlaceValue;
                hashing += numbers.get(start + windowSize - 1);
            } else {
                for (int j = 0; j<windowSize; j++) {
                    hashing = hashing * base + numbers.get(j);
                }
            }
            // subsequence and output sets
            if (seen.contains(hashing))
                output.add(s.substring(start, start + windowSize));
            seen.add(hashing);
        }
        return new ArrayList<String> (output);
    }

    public static void main(String args[]) {
        List<String> inputString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC", "GGGGGGGGGGGGGGGGGGGGGGGGG",
                "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "", "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT"
        );
        List<Integer> inputK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 10, 6);
        for (int i = 0; i<inputK.size(); i++) {
            System.out.println(i + 1 + ".\tInput Sequence: '" + inputString.get(i) + "'");
            System.out.println("\tk: " + inputK.get(i));
            System.out.println("\tRepeated Subsequence: " +
                    findRepeatedSequences(inputString.get(i), inputK.get(i)));
            System.out.println("--------------------------------");
        }
    }
}