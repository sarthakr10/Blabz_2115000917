import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> symDiff = new HashSet<>(set1);
        symDiff.addAll(set2);

        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        symDiff.removeAll(intersection);
        return symDiff;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
