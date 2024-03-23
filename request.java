public class request {
    public String book;
    public String dateRequested;
    public String status;
    public String dateArrival;
    public request() {
        
    }
    public void updateStatus(request request, String status){
		this.status=status;
	}
	public String getStatus(request request){
		return this.status;
	}
} 
