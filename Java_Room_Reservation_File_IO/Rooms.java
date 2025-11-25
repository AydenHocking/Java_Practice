public class Rooms {
    String roomNum;
    int guestAmount; 
    double cost;
    int floor;
    int bedNum; 
    int bedSize; 
    boolean view; 
    boolean suite;

    public Rooms(){

    }
    
    public Rooms(String roomNum, int guestAmount, double cost, int floor, int bedNum, int bedSize, boolean view, boolean suite){
            this.roomNum = roomNum; 
            this.guestAmount = guestAmount;
            this.cost = cost; 
            this.floor = floor; 
            this.bedNum = bedNum;
            this.bedSize = bedSize;
            this.view = view;
            this.suite = suite; 
    }

    @Override
    public String toString(){
        return "Room " + roomNum + " Guest Amount: " + guestAmount + " Cost: " + cost + " Floor: " + floor + " Bed Amount: " + bedNum + " Bed Size: " + bedSize + " View: " + view + " Suite: " + suite;
    }

    public String printToCSV(){
        return roomNum + "," + guestAmount + "," + cost + "," + 
            floor + "," + bedNum + "," + bedSize + "," +
            view + "," + suite;
    }
    public String getRoomNum(){
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    public int getGuestAmount(){
        return guestAmount;
    }

    public void setGuestAmount(int guestAmount) {
        this.guestAmount = guestAmount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public int getBedSize() {
        return bedSize;
    }

    public void setBedSize(int bedSize) {
        this.bedSize = bedSize;
    }

    public boolean isView() {
        return view;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }
        public boolean isSuite() {
        return suite;
    }

    public void setView(boolean view) {
        this.view = view;
    }

}