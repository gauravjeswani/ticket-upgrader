package com.airlines.ticket.upgrader.data.enums;

import java.util.Arrays;

/**
 * Enum class will hold the cabin types.
 *
 * @author Gaurav Jeswani
 */
public enum CabinType {

  BUSINESS("BUSINESS"), ECONOMY("Economy"), FIRST("First"), PREMIUM_ECONOMY("Premium Economy");

  private String cabinTypeName;

  /**
   * Constructor of the class
   *
   * @param cabinTypeName
   */
  CabinType(final String cabinTypeName) {
    this.cabinTypeName = cabinTypeName;
  }

  /**
   * The class will return the Cabin type enum by cabinTypeName
   *
   * @param cabinTypeName
   * @return
   */
  public static CabinType getCabinTypeByName(final String cabinTypeName) {

    return Arrays.stream(values()).filter(p -> p.cabinTypeName.equalsIgnoreCase(cabinTypeName.trim())).findAny()
        .orElse(null);

  }

  /**
   * @return
   */
  public String getCabinTypeName() {
    return this.cabinTypeName;
  }
}
