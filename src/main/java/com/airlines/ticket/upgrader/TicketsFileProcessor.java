package com.airlines.ticket.upgrader;

import java.util.ArrayList;
import java.util.List;

import com.airlines.ticket.upgrader.common.DiscountUpdater;
import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.field.validator.TicketValidator;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeException;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeSystemException;
import com.airlines.ticket.upgrader.file.process.FileFormat;
import com.airlines.ticket.upgrader.file.process.FileProcessorFactory;
import com.airlines.ticket.upgrader.file.process.IFileProcessor;

/**
 * Ticket processor implementation class, with Default access.
 *
 * @author z0043nrm
 */
class TicketsFileProcessor implements ITicketsFileProcessor {

  private final String inputFilePath;

  private final List<TicketInfo> invalidData = new ArrayList<>();

  private FileFormat outputFileFormat;

  private final List<TicketInfo> validData = new ArrayList<>();

  /**
   * Constructor of the class with default access
   *
   * @param inputFilePath
   */
  TicketsFileProcessor(final String inputFilePath) {
    super();
    this.inputFilePath = inputFilePath;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void processFile() {
    try {

      //Get File Format
      final FileFormat inputFileFormat = FileProcessorFactory.getFactory(inputFilePath);

      //Read File Date
      final IFileProcessor inputFileProcessor = inputFileFormat.getFileProcessor();
      final List<TicketInfo> tickets = inputFileProcessor.readFile(inputFilePath);

      //Process File Data
      for (final TicketInfo ticketInfo : tickets) {

        //Validate Ticket
        final boolean isValid = TicketValidator.validateTicket(ticketInfo);

        if (isValid) {
          // Update discount code in valid record
          DiscountUpdater.updateDiscountCodeByFareClass(ticketInfo);
          validData.add(ticketInfo);
        } else {
          invalidData.add(ticketInfo);
        }
      }

      IFileProcessor writeProcessor = null;

      // Output file format same as input if not given provided by user
      if (outputFileFormat == null) {
        writeProcessor = inputFileProcessor;
        outputFileFormat = inputFileFormat;
      } else {
        writeProcessor = outputFileFormat.getFileProcessor();
      }

      final String inputWithoutExtention = inputFilePath.substring(0,
          inputFilePath.lastIndexOf(inputFileFormat.getExtention()));

      // Write Invalid Data
      writeProcessor.writeFile(invalidData, inputWithoutExtention + "_invalid" + outputFileFormat.getExtention());

      // Write Valid Data
      writeProcessor.writeFile(validData, inputWithoutExtention + "_valid" + outputFileFormat.getExtention());
    } catch (final Exception e) {

      // If it is TicketUpgradeException re-throw it
      if (e instanceof TicketUpgradeException) {
        throw e;
      }

      // Catching all exception and wrapping it into TicketUpgradeException
      throw new TicketUpgradeSystemException("System exception occured, please contact administrator!!!", "SS-101");
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setOutputFileFormat(final FileFormat outputFileFormat) {
    this.outputFileFormat = outputFileFormat;
  }

}
