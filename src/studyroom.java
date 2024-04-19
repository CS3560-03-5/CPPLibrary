class studyRoom {
	private String roomNumber;
	private boolean isReserved;
    
	// Constructor to initialize a new study room
	public studyRoom(String roomNumber) {
	    this.roomNumber = roomNumber;
	    this.isReserved = false; // Rooms are available by default
	}
    
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public boolean isReserved() { return isReserved; }
    public void setReserved(boolean reserved) { isReserved = reserved; } 
}