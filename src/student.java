class Student {
    private int studentId;
    private String broncoId;
    private String name;
    private String major;
    private String email;
    private String password;
    private String[] borrowedBooks;
    private int fines;

    // Constructor to initialize a new student
    public Student(int studentId, String broncoId, String name, String major, String email, String password) {
        this.studentId = studentId;
        this.broncoId = broncoId;
        this.name = name;
        this.major = major;
        this.email = email;
        this.password = password;
        this.borrowedBooks = new String[0];
        this.fines = 0;
    }

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getBroncoId() { return broncoId; }
    public void setBroncoId(String broncoId) { this.broncoId = broncoId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String[] getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(String[] borrowedBooks) { this.borrowedBooks = borrowedBooks; }

    public int getFines() { return fines; }
    public void setFines(int fines) { this.fines = fines; }
}

