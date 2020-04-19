package com.airlines.ticket.upgrader.data.field.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.ticket.upgrader.common.CommonConstants;
import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.CabinType;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * The class will be used to validate each ticket
 *
 * @author Gaurav Jeswani
 */
public class TicketValidator {

  public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
      Pattern.CASE_INSENSITIVE);

  public static final Pattern VALID_MOBILE_PHONE_REGEX = Pattern
      .compile("^([+][9][1]|[9][1]|[0]){0,1}([7-9]{1})([0-9]{9})$", Pattern.CASE_INSENSITIVE);

  public static final Pattern VALID_PNR_REGEX = Pattern.compile("^[a-zA-Z0-9]{6}$", Pattern.CASE_INSENSITIVE);

  /**
   * Method will return true if ticket is valid else false
   *
   * @param ticketInfo
   * @return
   */
  public static boolean validateTicket(final TicketInfo ticketInfo) {

    if (!validateEmail(ticketInfo)) {
      return false;
    }

    if (!validatePhone(ticketInfo)) {
      return false;
    }

    if (!validateDates(ticketInfo)) {
      return false;
    }

    if (!validatePNR(ticketInfo)) {
      return false;
    }

    if (!validateCabin(ticketInfo)) {
      return false;
    }

    return true;
  }

  /**
   * Method will return true if cabin info is valid, else false
   *
   * @param ticketInfo
   * @return
   */
  private static boolean validateCabin(final TicketInfo ticketInfo) {

    final CabinType cabinType = CabinType.getCabinTypeByName(ticketInfo.getBookedCabin().trim());

    if (cabinType != null) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.BOOKED_CABIN);

    return false;
  }

  /**
   * Method will return true if dates info is valid, else false
   *
   * @param ticketInfo
   * @return
   */
  private static boolean validateDates(final TicketInfo ticketInfo) {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConstants.DATE_FORMAT);

    final LocalDate travelDate = LocalDate.parse(ticketInfo.getTravelDate().trim(), formatter);
    final LocalDate ticketingDate = LocalDate.parse(ticketInfo.getTicketingDate().trim(), formatter);

    if (ticketingDate.isBefore(travelDate)) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.TRAVEL_DATE);
    return false;
  }

  /**
   * Method will return true if email info is valid, else false
   *
   * @param ticketInfo
   * @return
   */
  private static boolean validateEmail(final TicketInfo ticketInfo) {
    final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(ticketInfo.getEmail().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.EMAIL);

    return false;
  }

  /**
   * Method will return true if phone info is valid, else false
   *
   * @param ticketInfo
   * @return
   */
  private static boolean validatePhone(final TicketInfo ticketInfo) {

    final Matcher matcher = VALID_MOBILE_PHONE_REGEX.matcher(ticketInfo.getPhone().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.PHONE);

    return false;
  }

  /**
   * Method will return true if PNR info is valid, else false
   *
   * @param ticketInfo
   * @return
   */
  private static boolean validatePNR(final TicketInfo ticketInfo) {

    final Matcher matcher = VALID_PNR_REGEX.matcher(ticketInfo.getPnr().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.PNR);

    return false;
  }

}
