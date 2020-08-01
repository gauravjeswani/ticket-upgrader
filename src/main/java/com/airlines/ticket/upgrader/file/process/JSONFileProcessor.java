package com.airlines.ticket.upgrader.file.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.FieldType;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeSystemException;

/**
 * The class will read CSV input file and populate the data in Java Object
 *
 * @author Gaurav Jeswani
 */
class JSONFileProcessor implements IFileProcessor {

  private static final String JSON_SEPERATOR = ":";

  /**
   * Method will write line by line to output file
   *
   * @param w
   * @param values
   * @throws IOException
   */
  private static void writeLine(final Writer w, final List<String> values) throws IOException {

    boolean firstDataField = true;

    final StringBuilder sb = new StringBuilder();
    for (final String value : values) {
      //For all other than first field add seperator
      if (!firstDataField) {
        sb.append(JSON_SEPERATOR);
      }

      sb.append(value);

      firstDataField = false;
    }
    sb.append("\n");
    w.append(sb.toString());

  }

  /**
   * {@inheritDoc}
   */
  public List<TicketInfo> readFile(final String filePath) {
    System.out.println("Reading from path : " + filePath);

    String line = "";

    final List<TicketInfo> tickets = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

      // Skip First line as it contains headers
      br.readLine();

      // Read Remaing lines which contains actual data
      while ((line = br.readLine()) != null) {

        final String[] ticketData = line.split(JSON_SEPERATOR);

        final TicketInfo ticket = new TicketInfo(ticketData);

        tickets.add(ticket);

      }

    } catch (final IOException e) {
      throw new TicketUpgradeSystemException("Error occured during reading file " + filePath, "SS-103");
    }
    return tickets;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeFile(final List<TicketInfo> data, final String filePath) {

    System.out.println("Writing at path : " + filePath);

    try {
      final FileWriter writer = new FileWriter(filePath);

      boolean isValid = true;
      // Write Field Header
      if (filePath.contains("_invalid")) {
        writeLine(writer, FieldType.getErrorFieldTypes());
        isValid = false;
      } else {
        writeLine(writer, FieldType.getProcessFieldTypes());
      }

      // Write file ticket data
      for (final TicketInfo ticketInfo : data) {

        final List<String> ticketData = new ArrayList<>();
        ticketData.add(ticketInfo.getFirstName());
        ticketData.add(ticketInfo.getLastName());
        ticketData.add(ticketInfo.getPnr());
        ticketData.add(ticketInfo.getFareClass());
        ticketData.add(ticketInfo.getTravelDate());
        ticketData.add(ticketInfo.getPax());
        ticketData.add(ticketInfo.getTicketingDate());
        ticketData.add(ticketInfo.getEmail());
        ticketData.add(ticketInfo.getPhone());
        ticketData.add(ticketInfo.getBookedCabin());

        if (isValid) {
          ticketData.add(ticketInfo.getAppliedDiscount().getDiscountCodeValue());
        } else {
          ticketData.add(ticketInfo.getInvalidField().getFieldError());
        }

        writeLine(writer, ticketData);
      }

      writer.flush();
      writer.close();

    } catch (final IOException e) {
      throw new TicketUpgradeSystemException("Error occured during reading file " + filePath, "SS-102");
    }
  }

}
