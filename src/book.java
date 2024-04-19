class book {
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;
    
	// Constructor to initialize a new book
	public book(String title, String author, String ISBN) {
	    this.title = title;
	    this.author = author;
	    this.ISBN = ISBN;
	    this.isAvailable = true; // New books are available by default
	}
    
	// Getters and Setters
	public String getTitle() {
		return title; 
	}
	public String getAuthor(){
		return author;
	}
	public String getISBN(){ 
		return ISBN; 
	}
	public boolean isAvailable(){ 
		return isAvailable; 
	}
	public void setAvailable(boolean available){ 
		isAvailable = available; 
	}
}
    