package pojoDatas;

public class Restfullmapici {

    /*
    {
        "checkin": "2022-09-05",
            "checkout": "2023-06-01"
    }

 */

    private String checkin;
    private String checkout;

    public Restfullmapici() {
    }

    public Restfullmapici(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Restfullmapici{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

}
