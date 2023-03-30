package pojoDatas;

public class Restfullmapdisi {
    /*
    {
        "firstname": "Drake",
            "lastname": "F.",
            "totalprice": 4000,
            "depositpaid": true,
            "additionalneeds": "Full Stack Test Automation Course with API and Appium"

            "bookingdates": {
                "checkin": "2022-09-05",
                "checkout": "2023-06-01"
    }
     */






    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private Restfullmapici bookingdates;


    public Restfullmapdisi() {
    }

    public Restfullmapdisi(String firstname, String lastname, Integer totalprice, Boolean depositpaid, String additionalneeds, Restfullmapici bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public Restfullmapici getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Restfullmapici bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", depositpaid='" + depositpaid + '\'' +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingdates=" + bookingdates +
                '}';
    }

}
