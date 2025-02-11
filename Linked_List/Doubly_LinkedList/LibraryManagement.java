class BookNode {
    String title, author, genre;
    int bookId;
    boolean available;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = true;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private BookNode head, tail;
    private int count;

    public Library() {
        this.head = this.tail = null;
        this.count = 0;
    }

    public void addBook(String title, String author, String genre, int bookId, Integer position) {
        BookNode newBook = new BookNode(title, author, genre, bookId);
        if (head == null) {
            head = tail = newBook;
        } else if (position == null || position >= count) {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        } else if (position == 0) {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        } else {
            BookNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newBook.next = current.next;
            newBook.prev = current;
            if (current.next != null) {
                current.next.prev = newBook;
            }
            current.next = newBook;
        }
        count++;
    }

    public boolean removeBook(int bookId) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void searchBook(String title, String author) {
        BookNode current = head;
        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) || 
                (author != null && current.author.equalsIgnoreCase(author))) {
                System.out.println(current.bookId + ": " + current.title + " by " + current.author + " - " + (current.available ? "Available" : "Checked Out"));
            }
            current = current.next;
        }
    }

    public boolean updateAvailability(int bookId, boolean available) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.available = available;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayBooks() {
        BookNode current = head;
        while (current != null) {
            System.out.println(current.bookId + ": " + current.title + " by " + current.author + " - " + (current.available ? "Available" : "Checked Out"));
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        BookNode current = tail;
        while (current != null) {
            System.out.println(current.bookId + ": " + current.title + " by " + current.author + " - " + (current.available ? "Available" : "Checked Out"));
            current = current.prev;
        }
    }

    public int totalBooks() {
        return count;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Book A", "Author X", "Fiction", 101, null);
        library.addBook("Book B", "Author Y", "Mystery", 102, null);
        library.addBook("Book C", "Author X", "Drama", 103, 1);
        library.displayBooks();
        library.removeBook(102);
        library.updateAvailability(101, false);
        library.displayBooksReverse();
        System.out.println("Total books: " + library.totalBooks());
    }
}
