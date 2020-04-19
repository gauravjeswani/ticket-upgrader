package com.airlines.ticket.upgrader.data.enums;

/**
 * Enum class will contain the Discount code to be used
 * 
 * @author Gaurav Jeswani
 */
public enum DiscountCode {
  NO_DICOUNT(""), OFFER_20("OFFER_20"), OFFER_25("OFFER_25"), OFFER_30("OFFER_30");

  private String discountCodeValue;

  DiscountCode(final String discountCodeValue) {
    this.discountCodeValue = discountCodeValue;
  }

  public String getDiscountCodeValue() {
    return this.discountCodeValue;
  }
}
