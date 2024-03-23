class student {
    private String studentID;
    private String name;
    private String email;

    // Constructor to initialize a new student
    public student(String studentID, String name, String email) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; } // Setter for student ID

    public String getName() { return name; }
    public void setName(String name) { this.name = name; } // Setter for name

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; } // setter for email
}
