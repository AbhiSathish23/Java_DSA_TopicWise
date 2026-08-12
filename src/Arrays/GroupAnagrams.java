package Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(anagrams(str));
    }

    // given an array of strings, group all the anagrams together.
    // E.g. ["eat","tea","tan","ate","nat","bat"] → groups like [["eat","tea","ate"], ["tan","nat"], ["bat"]].
    public static List<List<String>> anagrams(String[] anams) {
        HashMap<String, List<String>> seen = new HashMap<>();
        for (String s : anams) {
            String sortedString = Stream.of(s.split("")).sorted().collect(Collectors.joining());
            if (seen.containsKey(sortedString)) {
                seen.get(sortedString).add(s);
            } else {
                List<String> listOfString = new ArrayList<>();
                listOfString.add(s);
                seen.put(sortedString, listOfString);
            }
        }
        return new ArrayList<>(seen.values());
    }

}
