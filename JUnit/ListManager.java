import java.util.List;

public class ListManager {
    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element));
        }
    }

    public int getSize(List<Integer> list) {
        return (list == null) ? 0 : list.size();
    }
}
