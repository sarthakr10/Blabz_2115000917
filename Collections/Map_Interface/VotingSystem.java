import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> voteCount = new HashMap<>();
        Map<String, Integer> voteOrder = new LinkedHashMap<>();
        String[] votes = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};
        for (String candidate : votes) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
            voteOrder.put(candidate, voteCount.get(candidate));
        }

        System.out.println("Vote Counts:");
        for (String candidate : voteCount.keySet()) 
            System.out.println(candidate + " -> " + voteCount.get(candidate));

        System.out.println("\nSorted Results:");
        Map<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        for (String candidate : sortedVotes.keySet()) 
            System.out.println(candidate + " -> " + sortedVotes.get(candidate));

        System.out.println("\nVote Order:");
        for (String candidate : voteOrder.keySet()) 
            System.out.println(candidate + " -> " + voteOrder.get(candidate));
    }
}