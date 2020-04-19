package com.airlines.ticket.upgrader.data.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum class will be used to hold all the fields used in incoming files
 *
 * @author Gaurav Jeswani
 */
public enum FieldType {

  BOOKED_CABIN("Booked_cabin", 10, "Booked cabin invalid"),
  DISCOUNT_CODE("Discount_code", 11),
  EMAIL("Email", 8, "Email invalid"),
  ERROR("Error", 12),
  FARE_CLASS("Fare_class", 4),
  FIRST_NAME("First_name", 1),
  LAST_NAME("Last_name", 2),
  PAX("Pax", 6),
  PHONE("Mobile_phone", 9, "Mobile phone invalid"),
  PNR("PNR", 3, "PNR invalid"),
  TICKETING_DATE("Ticketing_date", 7),
  TRAVEL_DATE("Travel_date", 5, "Travel date invalid");

  private String fieldError;

  private int fieldIndex;

  private String fieldTypeName;

  /**
   * Constructor of the class
   *
   * @param fieldTypeName
   * @param fieldIndex
   */
  FieldType(final String fieldTypeName, final int fieldIndex) {
    this.fieldTypeName = fieldTypeName;
    this.fieldIndex = fieldIndex;
    this.fieldError = "";
  }

  /**
   * Constructor of the class
   *
   * @param fieldTypeName
   * @param fieldIndex
   * @param fieldError
   */
  FieldType(final String fieldTypeName, final int fieldIndex, final String fieldError) {
    this.fieldTypeName = fieldTypeName;
    this.fieldIndex = fieldIndex;
    this.fieldError = fieldError;
  }

  /**
   * The method will return the fields used in error file
   *
   * @return
   */
  public static List<String> getErrorFieldTypes() {

    return getFilteredFields(FieldType.DISCOUNT_CODE);
  }

  /**
   * The method will return the fields used in output files
   *
   * @return
   */
  public static List<String> getProcessFieldTypes() {

    return getFilteredFields(FieldType.ERROR);
  }

  /**
   * @param filter
   * @return
   */
  private static List<String> getFilteredFields(final FieldType filter) {
    return Arrays.stream(values()).filter(p -> p != filter).sorted(Comparator.comparing(FieldType::getFieldIndex))
        .flatMap(p -> Stream.of(p.getFieldTypeName())).collect(Collectors.toList());
  }

  /**
   * @return
   */
  public String getFieldError() {
    return this.fieldError;
  }

  /**
   * @return the fieldIndex
   */
  public int getFieldIndex() {
    return fieldIndex;
  }

  public String getFieldTypeName() {
    return this.fieldTypeName;
  }
}
