package com.example.AssetTracker_V2.common;
/**
 * An abstract class representing a paginated request, extending the base Request class.
 * It includes properties for page number and page size, along with methods to access and modify them.
 */
public abstract class PaginatedRequest extends Request {

    /**
     * The page number for pagination.
     */
    private int pageNumber;

    /**
     * The number of items per page for pagination.
     */
    private int pageSize;

    /**
     * Gets the current page number.
     *
     * @return The current page number.
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Gets the current page size.
     *
     * @return The current page size.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page number for pagination. Ensures the page number is non-negative.
     *
     * @param pageNumber The desired page number.
     */
    public void setPageNumber(final int pageNumber) {
        this.pageNumber = Math.max(0, pageNumber);
    }

    /**
     * Sets the page size for pagination. Ensures the page size is between 1 and 100.
     *
     * @param pageSize The desired page size.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = Math.min(100, Math.max(1, pageSize));
    }
}