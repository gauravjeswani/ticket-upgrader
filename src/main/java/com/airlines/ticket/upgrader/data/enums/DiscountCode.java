package com.airlines.ticket.upgrader.data.enums;

/**
 * Enum class will contain the Discount code to be used
 *
 * @author Gaurav Jeswani
 */
public enum DiscountCode {
  NO_DICOUNT("", 0), OFFER_20("OFFER_20", 1), OFFER_25("OFFER_25", 2), OFFER_30("OFFER_30", 3);

  private String discountCodeValue;

  private int mapping;

  DiscountCode(final String discountCodeValue, final int mapping) {
    this.discountCodeValue = discountCodeValue;
    this.mapping = mapping;
  }

  /**
   * @param className
   * @return
   */
  public static DiscountCode getDiscountByClass(final char className) {

    for (int i = 0; i < DiscountCode.values().length; i++) {
      if (DiscountCode.values()[i].mapping == (Character.getNumericValue(className) % 4)) {
        return DiscountCode.values()[i];
      }
    }

    return DiscountCode.NO_DICOUNT;

  }

  public String getDiscountCodeValue() {
    return this.discountCodeValue;
  }
}
