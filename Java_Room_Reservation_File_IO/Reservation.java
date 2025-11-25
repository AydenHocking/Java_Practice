public class Reservation {

    String firstName;
    String lastName; 
    int startMonth; 
    int startDay;
    int startYear;
    int endMonth;
    int endDay; 
    int endYear; 
    int roomNumber; 
    boolean prepaid;

    public Reservation(){

    }
    
    public Reservation(String firstName, String lastName, int startMonth, int startDay,
        int startYear, int endMonth, int endDay, int endYear, int roomNumber, boolean prepaid){
            this.firstName = firstName;
            this.lastName = lastName; 
            this.startMonth = startMonth; 
            this.startDay = startDay;
            this.startYear = startYear;
            this.endMonth = endMonth;
            this.endDay = endDay; 
            this.endYear = endYear; 
            this.roomNumber = roomNumber; 
            this.prepaid = prepaid;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " has a reservation starting on " +
            startMonth + "\\" + startDay + "\\" + startYear + " and ending on " +
            endMonth + "\\" + endDay + "\\" + endYear + " for room " + roomNumber;
    }

    public String printToCSV(){
        return firstName + "," + lastName + "," + 
            startMonth + "," + startDay + "," + startYear + "," +
            endMonth + "," + endDay + "," + endYear + "," + roomNumber + "," + prepaid;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

}