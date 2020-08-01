package com.airlines.ticket.upgrader.data.field.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.DiscountCode;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used to validate PNR field
 *
 * @author Gaurav Jeswani
 */
public class PNRValidator implements IFieldValidator {

  public static final Pattern VALID_PNR_REGEX = Pattern.compile("^[a-zA-Z0-9]{6}$", Pattern.CASE_INSENSITIVE);

  private static Map<String, TicketInfo> pnrTicketMapping = new HashMap<>();

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(final TicketInfo ticketInfo) {

    final String pnrNumber = ticketInfo.getPnr().trim();

    final Matcher matcher = VALID_PNR_REGEX.matcher(pnrNumber);

    if (matcher.find()) {

      final TicketInfo existingTicketWithSamePNR = pnrTicketMapping.get(ticketInfo.getPnr());

      // Already existing PNR. mark it and previous one as Invalid
      if (existingTicketWithSamePNR == null) {
        pnrTicketMapping.put(pnrNumber, ticketInfo);
        return true;
      } else {
        existingTicketWithSamePNR.setAppliedDiscount(DiscountCode.NO_DICOUNT);
        existingTicketWithSamePNR.setInvalidField(FieldType.PNR);
      }
    }

    ticketInfo.setInvalidField(FieldType.PNR);

    return false;
  }

}
