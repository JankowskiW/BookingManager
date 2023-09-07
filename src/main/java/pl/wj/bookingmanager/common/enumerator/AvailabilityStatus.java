package pl.wj.bookingmanager.common.enumerator;

import lombok.Getter;

@Getter
public enum AvailabilityStatus {
    ALL(0, null), AVAILABLE(1, true), UNAVAILABLE(2, false);
    private final int id;
    private final Boolean available;
    AvailabilityStatus(int id, Boolean available) {
        this.id = id;
        this.available = available;
    }
}