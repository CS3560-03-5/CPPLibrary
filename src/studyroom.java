class studyRoom {
	private int studyRoomId;
	private int studyRoomNumber;
	private int studyRoomFloor;
	private String availability;
	private String broncoIdBookedBy;
	private int capacity;
	
	// Constructor to initialize a new study room
	public studyRoom(int studyRoomId, int studyRoomNumber, int studyRoomFloor, String availability, String broncoIdBookedBy, int capacity) {
	    this.studyRoomId = studyRoomId;
	    this.studyRoomNumber = studyRoomNumber;
	    this.studyRoomFloor = studyRoomFloor;
	    this.availability = availability;
	    this.broncoIdBookedBy = broncoIdBookedBy;
	    this.capacity = capacity;
	}
	
	public int getStudyRoomId() { return this.studyRoomId; }
	public void setStudyRoomId(int studyRoomId) { this.studyRoomId = studyRoomId; }
    
	public int getStudyRoomNumber() { return this.studyRoomNumber; }
	public void setStudyRoomNumber(int studyRoomNumber) { this.studyRoomNumber = studyRoomNumber; }
    
	public int getStudyRoomFloor() { return this.studyRoomFloor; }
	public void setStudyRoomFloor(int studyRoomFloor) { this.studyRoomFloor = studyRoomFloor; }
    
	public String getAvailability() { return this.availability; }
	public void setAvailability(String availability) { this.availability = availability; }
    
	public String getBroncoIdBookedBy() { return this.broncoIdBookedBy; }
	public void setBroncoIdBookedBy(String broncoIdBookedBy) { this.broncoIdBookedBy = broncoIdBookedBy; }
    
	public int getCapacity() { return this.capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }
    }
    