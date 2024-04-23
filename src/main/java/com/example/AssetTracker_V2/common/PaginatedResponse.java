package com.example.AssetTracker_V2.common;

/**
 * An abstract class representing a paginated response, extending the base Response class.
 * It includes properties for page number, page size, and total items, along with methods to access and modify them.
 */
public abstract class PaginatedResponse extends Response {

    /**
     * The page number for pagination.
     */
    private int pageNumber;

    /**
     * The number of items per page for pagination.
     */
    private int pageSize;

    /**
     * The total number of items across all pages.
     */
    private long total;

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
     * Gets the total number of items across all pages.
     *
     * @return The total number of items.
     */
    public long getTotal() {
        return total;
    }

    /**
     * Sets the page number for pagination.
     *
     * @param pageNumber The desired page number.
     */
    public void setPageNumber(final int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Sets the page size for pagination.
     *
     * @param pageSize The desired page size.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Sets the total number of items across all pages.
     *
     * @param total The total number of items.
     */
    public void setTotal(final long total) {
        this.total = total;
    }
}