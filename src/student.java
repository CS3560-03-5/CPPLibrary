class student {
    private String studentID;
    private String name;
    private String email;
    private String[] borrowedBooks;
    private int fines;


    // Constructor to initialize a new student
    public student(String studentID, String name, String email) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new String[0];
        this.fines = 0;
    }

    // Getters and Setters
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; } // Setter for student ID

    public String getName() { return name; }
    public void setName(String name) { this.name = name; } // Setter for name

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; } // setter for email

    public String[] getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(String[] borrowedBooks) { this.borrowedBooks = borrowedBooks; }

    public int setFines(){ return fines; }
    public void getFines(int fines){ this.fines = fines; }
}
