package com.airlines.ticket.upgrader.data.field.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used to validate PNR field
 *
 * @author Gaurav Jeswani
 */
public class PNRValidator implements IFieldValidator {

  public static final Pattern VALID_PNR_REGEX = Pattern.compile("^[a-zA-Z0-9]{6}$", Pattern.CASE_INSENSITIVE);

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {
    final Matcher matcher = VALID_PNR_REGEX.matcher(ticketInfo.getPnr().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.PNR);

    return false;
  }

}
