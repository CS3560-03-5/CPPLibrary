class studyRoom {
	private String roomNumber;
	private boolean isReserved;
    
	// Constructor to initialize a new study room
	public studyRoom(String roomNumber) {
	    this.roomNumber = roomNumber;
	    this.isReserved = false; // Rooms are available by default
	}
    
    public String getRoomNumber() { return this.roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public boolean getIsReserved() { return this.isReserved; }
    public void reserve() { this.isReserved = true; }
	public void available() { this.isReserved = false; }
}