package pl.wj.bookingmanager.common.enumerator;

import lombok.Getter;

@Getter
public enum CommentObjectType {
    DEVICE(1), ROOM(2), USER(3), BOOKING(4);
    private final int id;
    CommentObjectType(int id) {
        this.id = id;
    }
}
