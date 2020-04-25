package com.airlines.ticket.upgrader.data.field.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used to validate email field of ticket
 *
 * @author Gaurav Jeswani
 */
public class EmailValidator implements IFieldValidator {

  public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
      Pattern.CASE_INSENSITIVE);

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {
    final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(ticketInfo.getEmail().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.EMAIL);

    return false;
  }

}
