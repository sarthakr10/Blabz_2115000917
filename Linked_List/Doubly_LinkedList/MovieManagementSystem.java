class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private Movie head;
    private Movie tail;


    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }


    public void addAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position == 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        
        newMovie.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        }
        temp.next = newMovie;
        newMovie.prev = temp;
        
        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie '" + title + "' removed.");
    }


    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }



    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Directed by " + temp.director);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating + " or higher.");
    }


    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating of '" + title + "' to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie temp = head;
        System.out.println("Movies in the list:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }


    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie temp = tail;
        System.out.println("Movies in reverse order:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManagement system = new MovieManagement();

        // Adding movies
        system.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        system.addAtEnd("Titanic", "James Cameron", 1997, 7.8);
        system.addAtPosition("Avatar", "James Cameron", 2009, 7.9, 1);


        system.displayForward();
        System.out.println();
        system.displayReverse();


        System.out.println("\nSearching movies by director 'Christopher Nolan':");
        system.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching movies with rating 8.0 and above:");
        system.searchByRating(8.0);


        System.out.println("\nUpdating rating for 'Titanic'...");
        system.updateRating("Titanic", 8.0);


        System.out.println("\nRemoving 'Avatar' from the list...");
        system.removeByTitle("Avatar");


        System.out.println("\nMovies after deletion:");
        system.displayForward();
    }
}

