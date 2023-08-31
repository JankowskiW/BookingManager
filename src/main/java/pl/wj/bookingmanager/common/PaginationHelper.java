package pl.wj.bookingmanager.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationHelper {
    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 50;
    private static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.DESC;
    private static final String DEFAULT_SORT_BY_FIELD = "id";

    public static Pageable createPagination(Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        pageNumber = pageNumber == null ? DEFAULT_PAGE_NUMBER : pageNumber;
        pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
        direction = direction == null ? DEFAULT_SORT_DIRECTION : direction;
        sortBy = sortBy == null ? DEFAULT_SORT_BY_FIELD : sortBy;
        return PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
    }
}
