package com.example.AssetTracker_V2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @Column(name = "id",nullable = false,updatable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name ="cost",nullable = false,updatable = false)
    @NotNull(message = "The cost of the cannot be null")
    @Digits(integer = 10, fraction = 4,message = "The cost of the asset can only have {0} " +
                                                 "number of integers and {1} number of fractions")
    private BigDecimal cost;

    @Column(name = "currentValue",nullable = false)
    private BigDecimal currentValue;

    @Column(name = "depreciationRate",updatable = false,nullable = false)
    @NotNull(message = "The Depreciation Rate of the cannot be null")
    @Digits(integer = 2, fraction = 4,message = "The Depreciation Rate of the asset can only have {0} " +
                                                 "number of integers and {1} number of fractions")
    private BigDecimal depreciationRate;

    @Column(name = "purchaseDate",updatable = false,nullable = false)
    @NotNull(message = "The purchase date of the asset can not be null")
    @PastOrPresent(message = "You can only add already purchased assets")
    private Date purchaseDate;

    @Column(name = "title",nullable = false,updatable = false)
    @NotNull(message = "The title of the asset cannot be null")
    @NotEmpty(message = "The title of the asset cannot be blank")
    @NotBlank(message = "The title of the asset cannot be blank")
    private String title;

    private Asset(){
        super();
    }

    /**
     * Creates an Asset having specific attributes
     *
     * @param title                 is the title of the asset
     * @param cost                  is the cost of the asset
     * @param depreciationRate      is the depreciation rate of the asset
     * @param purchaseDate          is the purchase date of the asset
     */
    public Asset(final String title,
                 final BigDecimal cost,
                 final BigDecimal depreciationRate,
                 final Date purchaseDate) {
        this.title = title;
        this.cost = cost;
        this.depreciationRate = depreciationRate.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP);
        this.purchaseDate = purchaseDate;
        setCurrentValue();
    }


    /**
     * Get the cost of the asset
     *
     * @return the cost of the asset
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Get the current value of the asset
     *
     * @return the current value of the asset
     */
    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    /**
     * Get the depreciation rate of the asset
     *
     * @return the depreciation rate of the asset
     */
    public BigDecimal getDepreciationRate() {
        return depreciationRate;
    }


    /**
     * Get the id of the asset
     *
     * @return the id of the asset
     */
    public Long getId() {
        return id;
    }


    /**
     * Get the purchase date of the asset
     *
     * @return the purchase date of the asset
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Get the title of the asset
     *
     * @return the title of the asset
     */
    public String getTitle() {
        return title;
    }


    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setCurrentValue() {

        LocalDate currentDate = LocalDate.now();
        int current= currentDate.getYear() * 10000 + currentDate.getMonthValue()*100 + currentDate.getDayOfMonth();

        LocalDate localDate = purchaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Format LocalDate to yyyyMMdd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter);

        // Parse the formatted date string into an integer
        int purchaseDateInt = Integer.parseInt(formattedDate);

        this.currentValue=cost.multiply(BigDecimal.ONE.subtract(depreciationRate).pow((current-purchaseDateInt)/10000));
    }

    public void setDepreciationRate(BigDecimal depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // Ask sir whether should I use this or not
    /**
     * Sets the default timezone of the server as UTC

    @PrePersist
    void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    */
}
