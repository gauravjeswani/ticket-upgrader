package com.airlines.ticket.upgrader.data.field.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be sued to validate Phone Field
 *
 * @author Gaurav Jeswani
 */
public class PhoneValidator implements IFieldValidator {

  public static final Pattern VALID_MOBILE_PHONE_REGEX = Pattern
      .compile("^([+][9][1]|[9][1]|[0]){0,1}([7-9]{1})([0-9]{9})$", Pattern.CASE_INSENSITIVE);

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {
    final Matcher matcher = VALID_MOBILE_PHONE_REGEX.matcher(ticketInfo.getPhone().trim());

    if (matcher.find()) {
      return true;
    }

    ticketInfo.setInvalidField(FieldType.PHONE);

    return false;
  }

}
