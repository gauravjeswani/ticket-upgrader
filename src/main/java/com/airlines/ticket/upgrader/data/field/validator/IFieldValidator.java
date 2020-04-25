package com.airlines.ticket.upgrader.data.field.validator;

import com.airlines.ticket.upgrader.data.TicketInfo;

/**
 * Base Interface for all field validators
 *
 * @author z0043nrm
 */
public interface IFieldValidator {

  boolean isValid(TicketInfo ticketInfo);
}
