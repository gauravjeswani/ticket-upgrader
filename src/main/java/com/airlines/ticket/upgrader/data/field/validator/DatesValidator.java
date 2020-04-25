package com.airlines.ticket.upgrader.data.field.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airlines.ticket.upgrader.common.CommonConstants;
import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used to validate Date fields of ticket
 *
 * @author Gaurav Jeswani
 */
public class DatesValidator implements IFieldValidator {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConstants.DATE_FORMAT);

    final LocalDate travelDate = LocalDate.parse(ticketInfo.getTravelDate().trim(), formatter);
    final LocalDate ticketingDate = LocalDate.parse(ticketInfo.getTicketingDate().trim(), formatter);

    if (ticketingDate.isBefore(travelDate)) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.TRAVEL_DATE);
    return false;
  }

}
