package com.airlines.ticket.upgrader.data.field.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airlines.ticket.upgrader.data.TicketInfo;

/**
 * The class will be used to validate each ticket
 *
 * @author Gaurav Jeswani
 */
public class TicketValidator {

  private static final List<IFieldValidator> fieldlValidators = new ArrayList<>();

  static {
    fieldlValidators.add(new EmailValidator());
    fieldlValidators.add(new PhoneValidator());
    fieldlValidators.add(new DatesValidator());
    fieldlValidators.add(new PNRValidator());
    fieldlValidators.add(new CabinValidator());
  }

  /**
   * Method will return true if ticket is valid else false
   *
   * @param ticketInfo
   * @return
   */
  public static boolean validateTicket(final TicketInfo ticketInfo) {

    final Optional<IFieldValidator> result = fieldlValidators.stream()
        .filter(fieldValidators -> !fieldValidators.isValid(ticketInfo)).findFirst();

    return !result.isPresent();
  }

}
