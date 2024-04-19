class request {
    private String requestID;
    private String studentID;
    private String ISBN;
    private String status; // Example: "Pending", "Fulfilled", "Cancelled"

    // Constructor to initialize a new request
    public request(String requestID, String studentID, String ISBN) {
        this.requestID = requestID;
        this.studentID = studentID;
        this.ISBN = ISBN;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getRequestID() { return requestID; }
    public String getStudentID() { return studentID; }
    public String getISBN() { return ISBN; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 
