import java.time.LocalDate;

class book {
    private int bookId; // Assuming this is the unique identifier for each book
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String ISBN;
    private int availableCopies;
    private String subject;

    // Constructor to initialize a new book
    public book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availableCopies = 1; // New books are available by default
    }

    // Getters and Setters
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDate getPublicationDate() { return publicationDate; }
    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public boolean isAvailable() { return availableCopies > 0; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}