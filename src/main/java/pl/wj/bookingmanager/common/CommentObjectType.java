package pl.wj.bookingmanager.common;

import lombok.Getter;

@Getter
public enum CommentObjectType {
    DEVICE(1), ROOM(2), USER(3), BOOKING(4);
    private int id;
    CommentObjectType(int id) {
        this.id = id;
    }
}
