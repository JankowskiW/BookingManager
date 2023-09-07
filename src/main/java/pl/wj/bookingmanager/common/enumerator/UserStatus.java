package pl.wj.bookingmanager.common.enumerator;

import lombok.Getter;

@Getter
public enum UserStatus {
    ALL(0, null), ACTIVE(1, false), ARCHIVED(2, true);
    private final int id;
    private final Boolean archived;
    UserStatus(int id, Boolean archived) {
        this.id = id;
        this.archived = archived;
    }
}

