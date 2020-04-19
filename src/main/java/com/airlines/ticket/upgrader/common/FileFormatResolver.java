package com.airlines.ticket.upgrader.common;

import com.airlines.ticket.upgrader.data.enums.FileFormat;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeBusinessException;

/**
 * Class will be used to get the File Format
 *
 * @author Gaurav Jeswani
 */
public class FileFormatResolver {

  /**
   * Private constructor to prevent initialization of class Constructor of the
   * class
   */
  private FileFormatResolver() {
    super();
  }

  /**
   * The class will return the file format with the input file path
   *
   * @param filePath
   * @return
   */
  public static FileFormat getFileFormat(final String filePath) {

    if (filePath.endsWith(FileFormat.CSV.getExtention())) {

      return FileFormat.CSV;
    }

    throw new TicketUpgradeBusinessException("Invalid File Format Received!!!", "BS-101");

  }
}
