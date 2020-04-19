package com.airlines.ticket.upgrader.file.process;

import com.airlines.ticket.upgrader.data.enums.FileFormat;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeBusinessException;

/**
 * The class will be used to resolve the File Processor by file format
 *
 * @author Gaurav Jeswani
 */
public class FileProcessorResolver {

  /**
   * Private constructor to prevent initialization
   */
  private FileProcessorResolver() {
    super();
  }

  /**
   * The method will return FileProcessor object by file format
   * 
   * @param fileFormat
   * @return
   */
  public static IFileProcessor getFileProcessor(final FileFormat fileFormat) {

    if (fileFormat == FileFormat.CSV) {
      return new CSVFileProcessor();
    }

    throw new TicketUpgradeBusinessException("File processing not supported for " + fileFormat, "BS-102");
  }
}
