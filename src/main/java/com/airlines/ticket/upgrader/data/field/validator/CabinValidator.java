package com.airlines.ticket.upgrader.data.field.validator;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.CabinType;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used to validate Cabin field
 *
 * @author Gaurav Jeswani
 */
public class CabinValidator implements IFieldValidator {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {

    final CabinType cabinType = CabinType.getCabinTypeByName(ticketInfo.getBookedCabin().trim());

    if (cabinType != null) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.BOOKED_CABIN);

    return false;
  }

}
