class Publication {
    String title;
    double price;
    int copies;

    // Constructor
    Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Common method
    void saleCopy() {
        System.out.println("Total Sale: " + (price * copies));
    }

    // Polymorphic method
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Copies: " + copies);
    }
}

class Book extends Publication {
    String author;

    Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    void orderCopies(int qty) {
        copies += qty;
        System.out.println("Book copies updated to: " + copies);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Author: " + author);
    }
}

class Magazine extends Publication {
    int orderQty;
    int currentIssue;

    Magazine(String title, double price, int copies, int issue) {
        super(title, price, copies);
        this.currentIssue = issue;
    }

    void receiveIssue() {
        currentIssue++;
        System.out.println("New Issue Received: " + currentIssue);
    }

    void orderQty(int qty) {
        this.orderQty = qty;
        copies += qty;
        System.out.println("Magazine copies updated to: " + copies);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Current Issue: " + currentIssue);
    }
}

public class PublicationDemo {
    public static void main(String[] args) {
        // Runtime Polymorphism
        Publication p;

        // Book object
        p = new Book("Java Programming", 500, 10, "James Gosling");
        p.display();
        p.saleCopy();

        System.out.println();

        // Magazine object
        p = new Magazine("Tech Monthly", 200, 5, 1);
        p.display();
        p.saleCopy();
    }
}
