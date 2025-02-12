class InventoryItem {
    String itemName;
    int itemID;
    int Quantity;
    int Price;
    InventoryItem next;

    public InventoryItem(String itemName, int itemID, int Quantity, int Price) {
        this.itemName = itemName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.itemID = itemID;
    }
}

public class InventoryManagement {
    private InventoryItem head;

    // addItemAtBeginning
    public void addAtBeginning(String itemName, int itemID, int Price, int Quantity) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, Quantity, Price);
        newItem.next = head;
        head = newItem;
    }

    // addItemAtEnd
    public void addAtLast(String itemName, int itemID, int Price, int Quantity) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, Quantity, Price);
        if (head == null) {
            head = newItem;
            return;
        } else {
            InventoryItem temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // addItemAtPosition
    public void addItemAtPosition(String itemName, int itemID, int Price, int Quantity, int position) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, Quantity, Price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
        }
        InventoryItem temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp == null)
            return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // removeItem
    public void removeItem(int itemID) {
        if (head == null)
            return;
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null)
            return;
        temp.next = temp.next.next;

    }

    // updateQuantity
    public void updateQuantity(int itemID, int newQuantity) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.Quantity = newQuantity;
            }
            temp = temp.next;
        }
    }

    // searchItemByID
    public InventoryItem searchItemByID(int itemID) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // searchItemByName
    public InventoryItem searchItemByName(String itemName) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // calculateTotalValue
    public int calculateTotalValue() {
        int total = 0;
        InventoryItem temp = head;
        while (temp != null) {
            total += temp.Price * temp.Quantity;
            temp = temp.next;
        }
        return total;
    }

    // mergeSort
    public InventoryItem mergeSort(InventoryItem head, boolean sortByName) {
        if (head == null || head.next == null)
            return head;
        InventoryItem middle = getMiddle(head);
        InventoryItem nextofMiddle = middle.next;
        middle.next = null;
        InventoryItem left = mergeSort(head, sortByName);
        InventoryItem right = mergeSort(nextofMiddle, sortByName);
        return merge(left, right, sortByName);
    }

    // merge
    private InventoryItem merge(InventoryItem left, InventoryItem right, boolean sortByName) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (sortByName) {
            if (left.itemName.compareToIgnoreCase(right.itemName) < 0) {
                left.next = merge(left.next, right, sortByName);
                return left;
            } else {
                right.next = merge(left, right.next, sortByName);
                return right;
            }
        } else {
            if (left.Price < right.Price) {
                left.next = merge(left.next, right, sortByName);
                return left;
            } else {
                right.next = merge(left, right.next, sortByName);
                return right;
            }
        }
    }
    // getMiddle

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null)
            return null;
        InventoryItem slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // sortInventory
    public void sortInventory(boolean sortByName) {
        head = mergeSort(head, sortByName);
    }

    // displayInventory
    public void displayInventory() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.print(" ID :" + temp.itemID);
            System.out.print(" NAME : " + temp.itemName);
            System.out.print(" PRICE : " + temp.Price);
            System.out.print(" Quantity : " + temp.Quantity);
            System.out.println();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement Inventory = new InventoryManagement();
        Inventory.addAtBeginning("Laptop", 101, 5, 50000);
        Inventory.addAtBeginning("Mouse", 102, 15, 500);
        Inventory.addAtLast("Keyboard", 103, 10, 1500);

        System.out.println("List before sorting");
        Inventory.displayInventory();
        System.out.println("--------------------------");
        Inventory.sortInventory(true);
        Inventory.displayInventory();
        System.out.println("--------------------------");
        Inventory.sortInventory(false);
        Inventory.displayInventory();
        System.out.println("\nTotal Inventory Value: " + Inventory.calculateTotalValue());

    }
}