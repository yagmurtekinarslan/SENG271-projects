public interface Reservable {

    void reserve(String holder);
    void cancelReservation();
    boolean isReserved();
    String getReservationHolder();

}
