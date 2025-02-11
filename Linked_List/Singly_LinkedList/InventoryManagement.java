class InventoryItem {
    String itemName;
    int itemID;
    int quantity;
    double price;
    InventoryItem next;

    public InventoryItem(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private InventoryItem head;

    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        InventoryItem newItem = new InventoryItem(itemName, itemID, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItem(int itemID) {
        if (head == null) return;
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void updateQuantity(int itemID, int newQuantity) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public InventoryItem searchItemByID(int itemID) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) return temp;
            temp = temp.next;
        }
        return null;
    }

    public InventoryItem searchItemByName(String itemName) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        InventoryItem temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    private InventoryItem mergeSort(InventoryItem head, boolean sortByName) {
        if (head == null || head.next == null) return head;
        InventoryItem middle = getMiddle(head);
        InventoryItem nextOfMiddle = middle.next;
        middle.next = null;
        InventoryItem left = mergeSort(head, sortByName);
        InventoryItem right = mergeSort(nextOfMiddle, sortByName);
        return merge(left, right, sortByName);
    }

    private InventoryItem merge(InventoryItem left, InventoryItem right, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;
        if (sortByName) {
            if (left.itemName.compareToIgnoreCase(right.itemName) < 0) {
                left.next = merge(left.next, right, sortByName);
                return left;
            } else {
                right.next = merge(left, right.next, sortByName);
                return right;
            }
        } else {
            if (left.price < right.price) {
                left.next = merge(left.next, right, sortByName);
                return left;
            } else {
                right.next = merge(left, right.next, sortByName);
                return right;
            }
        }
    }

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null) return null;
        InventoryItem slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void sortInventory(boolean sortByName) {
        head = mergeSort(head, sortByName);
    }

    public void displayInventory() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemID + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        inventory.addItemAtEnd("Laptop", 101, 5, 50000);
        inventory.addItemAtEnd("Mouse", 102, 15, 500);
        inventory.addItemAtEnd("Keyboard", 103, 10, 1500);

        System.out.println("Inventory before sorting:");
        inventory.displayInventory();

        System.out.println("\nSorting inventory by Name:");
        inventory.sortInventory(true);
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());
    }
}

