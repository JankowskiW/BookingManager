package pl.wj.bookingmanager.common.enumerator;

import lombok.Getter;

@Getter
public enum BookingStatus {
    ALL(0), ACTIVE(1), EXPIRED(2), FUTURE(3);
    private final int id;
    BookingStatus(int id) {
        this.id = id;
    }
}