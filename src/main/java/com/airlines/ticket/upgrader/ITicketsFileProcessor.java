package com.airlines.ticket.upgrader;

import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeException;
import com.airlines.ticket.upgrader.file.process.FileFormat;

/**
 * Ticket Processor Interface to call ticket processor methods
 *
 * @author Gaurav Jeswani
 */
public interface ITicketsFileProcessor {

  /**
   * The method will process the file. It will validate data and create error
   * file with error code and processed files with discount code
   */
  void processFile() throws TicketUpgradeException;

  /**
   * The method will set the required Output File Format, if different from
   * Input format
   */
  void setOutputFileFormat(final FileFormat outputFileFormat);
}
