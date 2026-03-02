import java.util.Date;
import java.text.SimpleDateFormat;

public class Campaign {

    public static final double MAX_DISCOUNT_RATE = 50.0;

    private Date startDate;
    private Date endDate;
    private ItemType itemType;
    private double discountRate;

    public Campaign(Date startDate, Date endDate, ItemType itemType, double discountRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemType = itemType;
        this.discountRate = discountRate;
    }


    public Date getStartDate() {

        return startDate;
    }

    public Date getEndDate() {

        return endDate;
    }

    public ItemType getItemType() {

        return itemType;
    }

    public double getDiscountRate() {

        return discountRate;
    }


    public boolean isActive(Date onDate) {

        boolean afterStart = !onDate.before(startDate);
        boolean beforeEnd = !onDate.after(endDate);

        if (afterStart && beforeEnd) {
            return true;
        } else {
            return false;
        }
    }


    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }


    public String toString() {
        int rateAsInt = (int) discountRate;
        return rateAsInt + "% sale of " + itemType.name()
                + " until " + formatDate(endDate);
    }
}

