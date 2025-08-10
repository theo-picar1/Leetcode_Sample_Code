package intervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        List<Integer> answer = partitionLabels(s);

        System.out.println("LENGTH OF PARTITIONS ARE: " +answer);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), i);
        }

        int l = 0, end = freq.get(s.charAt(0));
        for(int r = 0; r < s.length(); r++) {
            end = Math.max(end, freq.get(s.charAt(r)));
            System.out.println("Currently at char " +s.charAt(r)+ ", updating end index to be " +end);

            if(r == end) {
                System.out.println("Right pointer has reached end index " +end+". Adding length of substring " +s.substring(l, r + 1)+ ", (" +(r-l+1)+ "), to the list");
                res.add(r - l + 1);

                if(r + 1 < s.length()) {
                    l = r + 1;
                    System.out.println("Updating left pointer to be " +l+ ". Left pointer is now pointing at char " +s.charAt(l)+ "\n");
                }
                else {
                    System.out.println("We have reached the end of string 's'. No longer updating l...\n");
                }
            }
        }

        return res;
    }
}
