import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friends;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private UserNode head;

    public SocialMedia() {
        this.head = null;
    }

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
            if (!user2.friends.contains(userId1)) user2.friends.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friends);
            mutualFriends.retainAll(user2.friends);
            System.out.println("Mutual Friends: " + mutualFriends);
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public void searchUser(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.userId + " - " + temp.name);
            }
            temp = temp.next;
        }
    }

    public void countFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friends.size() + " friends.");
        }
    }
}

public class SocialMediaNetwork {
    public static void main(String[] args) {
        SocialMedia network = new SocialMedia();
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 22);
        network.addUser(3, "Charlie", 28);
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.displayFriends(1);
        network.findMutualFriends(1, 2);
        network.removeFriend(1, 2);
        network.displayFriends(1);
        network.countFriends(1);
    }
}